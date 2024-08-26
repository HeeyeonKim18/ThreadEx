package org.example.concurrency;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    private static final ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) {
        lock.lock();
        try{
            System.out.println("Outer lock acquired");
            nestedMethod();
        }finally {
            lock.unlock();
            System.out.println("Outer lock released");
        }
    }

    private static void nestedMethod() {
        lock.lock();
        try{
            System.out.println("Inner lock acquired");
            // Perform operations within the nested lock
        }finally {
            lock.unlock();
            System.out.println("Inner lock released");
        }
    }
}
