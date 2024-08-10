package org.example.concurrent;

import java.util.concurrent.locks.ReentrantLock;

public class LockExample {
    private final ReentrantLock lock = new ReentrantLock();
    private int count = 0;

    // When we call the lock() method in a thread, it tries to acquire the lock.
    // If it’s successful, it executes the task.
    // However, if it’s unsuccessful, the thread is blocked until the lock is released.
    // The unlock() method releases the lock.
    public int increment(){
        lock.lock();
        try{
            return this.count++;
        }finally {
            lock.unlock();
        }
    }
}
