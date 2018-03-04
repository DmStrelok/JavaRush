package com.javarush.task.task33.task3310.strategy;

import java.io.IOException;

public class FileStorageStrategy implements StorageStrategy {
    private static final int DEFAULT_INITIAL_CAPACITY = 2;
    private static final long DEFAULT_BUCKET_SIZE_LIMIT = 10000;
    private FileBucket[] table = new FileBucket[DEFAULT_INITIAL_CAPACITY];
    private int size;
    private long bucketSizeLimit = DEFAULT_BUCKET_SIZE_LIMIT;
    long maxBucketSize = 10_000_000L;

    public long getBucketSizeLimit() {
        return bucketSizeLimit;
    }

    public void setBucketSizeLimit(long bucketSizeLimit) {
        this.bucketSizeLimit = bucketSizeLimit;
        resize(bucketSizeLimit);
    }

    public int hash(Long k) {
        int h;
        return (k == null) ? 0 : (h = k.hashCode()) ^ (h >>> 16);
    }

    public int indexFor(int hash, int length) {
        return hash & (length - 1);
    }

    public Entry getEntry(Long key) {
        FileBucket first;
        int hash = hash(key);
        if (table != null && table.length > 0 && (first = table[(table.length - 1) & hash]) != null) {
            Entry entry = first.getEntry();
            for (; entry != null; entry = entry.next) {
                if (entry.key == key || (key != null && key.equals(entry.key)))
                    return entry;
            }
        }
        return null;
    }

    public void resize(long newBucketSize) {
        if (newBucketSize < 1) return;
        bucketSizeLimit = newBucketSize;
        if (bucketSizeLimit >= maxBucketSize) bucketSizeLimit = maxBucketSize;
        FileBucket[] newTable = new FileBucket[table.length];
        transfer(newTable);
        for (int i = 0; i < table.length; i++) {
            table[i].remove();
        }
        table = newTable;
    }

    public void transfer(FileBucket[] newTable) {
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                Entry entry = table[i].getEntry();
                int bucket = indexFor(entry.hash, newTable.length);
                if (newTable[bucket] == null)
                    newTable[bucket] = new FileBucket();
                else {
                    Entry e = newTable[bucket].getEntry();
                    e.next = entry;
                    entry = e;
                }
                newTable[bucket].putEntry(entry);
            }
        }
    }

    public void addEntry(int hash, Long key, String value, int bucketIndex) {
        if (getEntry(key) != null) {
            Entry entry = table[bucketIndex].getEntry();
            for (Entry e = entry; e != null; e = e.next) {
                if (e.key == key || (key != null && key.equals(e.key))) {
                    e.value = value;
                    table[bucketIndex].remove();
                    table[bucketIndex] = new FileBucket();
                    table[bucketIndex].putEntry(entry);
                }
            }
        }
        else {
            createEntry(hash, key, value, bucketIndex);
            size++;
        }
        if (table[bucketIndex].getFileSize() >= bucketSizeLimit) resize(bucketSizeLimit * 2);
    }

    public void createEntry(int hash, Long key, String value, int bucketIndex) {
        Entry entry = new Entry(hash, key, value, null);
        Entry e = null;
        if (table[bucketIndex] != null) {
            e = table[bucketIndex].getEntry();
            table[bucketIndex].remove();
        }
        entry.next = e;
        table[bucketIndex] = new FileBucket();
        table[bucketIndex].putEntry(entry);
    }

    @Override
    public boolean containsKey(Long key) {
        return getEntry(key) != null;
    }

    @Override
    public boolean containsValue(String value) {
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                Entry entry = table[i].getEntry();
                for (Entry e = entry; e != null; e = e.next) {
                    if (e.value == value || (value != null && value.equals(e.value))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public void put(Long key, String value) {
        int h = hash(key);
        addEntry(h, key, value, indexFor(h, table.length));
    }

    @Override
    public Long getKey(String value) {
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                Entry entry = table[i].getEntry();
                for (Entry e = entry; e != null; e = e.next) {
                    if (e.value == value || (value != null && value.equals(e.value))) {
                        return e.getKey();
                    }
                }
            }
        }
        return null;
    }

    @Override
    public String getValue(Long key) {
        return getEntry(key).value;
    }
}
