package com.javarush.task.task37.task3708.retrievers;

import com.javarush.task.task37.task3708.cache.LRUCache;
import com.javarush.task.task37.task3708.storage.Storage;

public class CachingProxyRetriever implements Retriever{
    private OriginalRetriever originalRetriever;
    private LRUCache lruCache;

    public CachingProxyRetriever(Storage storage) {
        originalRetriever  = new OriginalRetriever(storage);
        lruCache = new LRUCache(1000);
    }

    @Override
    public Object retrieve(long id) {
        Object value = null;
        if(lruCache.find(id)!=null){
            return lruCache.get(id);
        }else {
            value = originalRetriever.retrieve(id);
            lruCache.set(id,value);
        }
        return value;
    }
}
