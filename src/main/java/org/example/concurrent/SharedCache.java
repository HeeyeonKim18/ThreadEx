package org.example.concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReadWriteLock Interface achieves this by using two locks instead of one.
 * The read lock can be acquired by multiple threads at a time if no thread has acquired the write lock.
 * The write lock can be acquired only if both read and write lock have not been acquired
 */
public class SharedCache {
    private Map<String, String> cache = new HashMap<>();

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public String readData(String key){
        lock.readLock().lock();
        try{
            return cache.get(key);
        }finally {
            lock.readLock().unlock();
        }
    }

    public void writeData(String key, String value){
        lock.writeLock().lock();
        try{
            cache.put(key, value);
        }finally {
            lock.writeLock().unlock();
        }
    }
}
