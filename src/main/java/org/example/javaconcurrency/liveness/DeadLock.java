package org.example.javaconcurrency.liveness;

public class DeadLock {
    static Object lock1 = new Object();
    static Object lock2 = new Object();

    public static void main(String[] args) {
        new Thread(()->{
            try{
                synchronized (lock1) {
                    Thread.sleep(500);
                    synchronized (lock2) {
                        System.out.println("Thread 1 successfully started execution");
                    }
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try{
                synchronized (lock2) {
                    Thread.sleep(500);
                    synchronized (lock1) {
                        System.out.println("Thread 2 successfully started execution");
                    }
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
