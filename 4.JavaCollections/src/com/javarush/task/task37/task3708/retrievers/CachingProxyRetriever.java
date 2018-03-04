package com.javarush.task.task37.task3708.retrievers;

import com.javarush.task.task37.task3708.cache.LRUCache;
import com.javarush.task.task37.task3708.storage.Storage;

public class CachingProxyRetriever implements Retriever {
    OriginalRetriever originalRetriever;
    LRUCache<Long, Object> lruCache = new LRUCache<>(10);

    public CachingProxyRetriever(Storage storage) {
        originalRetriever = new OriginalRetriever(storage);
    }

    @Override
    public Object retrieve(long id) {
        Object obj;
        if ((obj = lruCache.find(id)) != null) return obj;
        obj = originalRetriever.retrieve(id);
        lruCache.set(id, obj);
        return obj;
    }
}
