package org.example.javaconcurrency.liveness;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LiveLock {

    private Lock lock1 = new ReentrantLock(true);
    private Lock lock2 = new ReentrantLock(true);

    public static void main(String[] args) {
        LiveLock lock = new LiveLock();
        new Thread(lock::operation1, "T1").start();
        new Thread(lock::operation2, "T2").start();
    }

    public void operation1() {
        while(true) {
            lock1.tryLock();
            System.out.println("Acquired lock1, trying to acquire lock2.");
            sleep(50);

            if(lock2.tryLock()){
                System.out.println("Acquired lock2.");
            }else {
                System.out.println("Unable to acquire lock2, releasing lock1");
                lock1.unlock();
                continue;
            }

            System.out.println("Executing operation1.");
            break;
        }
        lock2.unlock();;
        lock1.unlock();
    }

    public void operation2() {
        while(true) {
            lock2.tryLock();
            System.out.println("Acquired lock2, trying to acquire lock1.");
            sleep(50);

            if(lock1.tryLock()){
                System.out.println("Acquired lock1.");
            }else {
                System.out.println("Unable to acquire lock1, releasing lock2");
                lock2.unlock();
                continue;
            }

            System.out.println("Executing operation2.");
            break;
        }
        lock1.unlock();;
        lock2.unlock();
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
