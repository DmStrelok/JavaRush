package com.javarush.task.task33.task3310.strategy;

public class OurHashMapStorageStrategy implements StorageStrategy {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private Entry[] table = new Entry[DEFAULT_INITIAL_CAPACITY];
    private int size = 0;
    private int threshold = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
    private float loadFactor = DEFAULT_LOAD_FACTOR;

    public int hash(Long k) {
        int h;
        return (k == null) ? 0 : (h = k.hashCode()) ^ (h >>> 16);
    }

    public int indexFor(int hash, int length) {
        return hash & (length - 1);
    }

    public Entry getEntry(Long key) {
        Entry[] tab;
        Entry first;
        int n;
        Long k;
        int hash = hash(key);
        if ((tab = table) != null && (n = tab.length) > 0) {
            for (first = tab[(n - 1) & hash]; first != null; first = first.next) {
                if (first.hash == hash && ((k = first.key) == key || (key != null && key.equals(k))))
                    return first;
            }
        }
        return null;
    }

    public void resize(int newCapacity) {
        if (newCapacity < 1) return;
        Entry[] newTable = new Entry[newCapacity];
        transfer(newTable);
        table = newTable;
        threshold = (int)(newCapacity * loadFactor);
    }

    public void transfer(Entry[] newTable) {
        for (int i = 0; i < table.length; i++) {
            for (Entry e = table[i]; e != null; e = e.next) {
                Entry ee = new Entry(e.hash, e.key, e.value, null);
                int bucket = indexFor(ee.hash, newTable.length);
                if (newTable[bucket] == null) {
                    newTable[bucket] = ee;
                } else {
                    e.next = newTable[bucket];
                    newTable[bucket] = e;
                }
            }
        }
    }

    public void addEntry(int hash, Long key, String value, int bucketIndex) {
        for (Entry e = table[bucketIndex]; e != null; e = e.next) {
            if (e.hash == hash && (e.key == key || (key != null && key.equals(e.key)))) {
                e.value = value;
                return;
            }
        }
        createEntry(hash, key, value, bucketIndex);
        size++;
        if (size >= threshold) resize(table.length * 2);
    }

    public void createEntry(int hash, Long key, String value, int bucketIndex) {
        Entry e = new Entry(hash, key, value, table[bucketIndex]);
        table[bucketIndex] = e;
    }

    @Override
    public boolean containsKey(Long key) {
        return getEntry(key) != null;
    }

    @Override
    public boolean containsValue(String value) {
        for (Entry aTable : table) {
            for (Entry e = aTable; e != null; e = e.next) {
                if (e.value == value || (value != null && value.equals(e.value)))
                    return true;
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
        for (Entry aTable : table) {
            for (Entry e = aTable; e != null; e = e.next) {
                if (e.value == value || (value != null && value.equals(e.value)))
                    return e.key;
            }
        }
        return null;
    }

    @Override
    public String getValue(Long key) {
        return getEntry(key).value;
    }
}
