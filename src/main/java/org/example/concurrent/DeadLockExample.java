package org.example.concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ThreadA acquires lockA and is waiting to lockB.
 * ThreadB has acquired lockB and is waiting to acquire lockA.
 * Here, threadA will never acquire lockB as it is held by threadB.
 * Similarly, threadB can never acquire lockA as it is held by threadA.
 * This kind of situation is called a deadlock.
 */
public class DeadLockExample {
    public static void main(String[] args) {
        ReentrantLock lockA = new ReentrantLock();
        ReentrantLock lockB = new ReentrantLock();

        Thread threadA = new Thread(()->{
            lockA.lock();
            try{
                System.out.println("ThreadA has acquired lockA");
                lockB.lock();
                try{
                    System.out.println("ThreadA has acquired lockB");
                }finally {
                    lockB.unlock();
                }
            }finally {
                lockA.unlock();
            }
        });

        Thread threadB = new Thread(()->{
            lockB.lock();
            try{
                System.out.println("ThreadB has acquired lockB");
                lockA.lock();
                try{
                    System.out.println("ThreadB has acquired lockA");
                }finally {
                    lockA.unlock();
                }
            }finally {
                lockB.unlock();
            }
        });

        threadA.start();
        threadB.start();
    }
}
