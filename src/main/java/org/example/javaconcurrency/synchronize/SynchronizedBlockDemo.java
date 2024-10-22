package org.example.javaconcurrency.synchronize;

// If a small part of the code that needs to be synchronized,
// it may be worth to user the synchronized code block to wrap the code that needs to be synchronized.
public class SynchronizedBlockDemo {

    static int count;

    public static void main(String[] args) throws InterruptedException {
        SynchronizedBlockDemo synchronizedBlockDemo = new SynchronizedBlockDemo();

        Runnable runnable = () -> {
            synchronized (synchronizedBlockDemo) {
                for (int i = 0; i < 10000; i++) {
                    count++;
                }
            }
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count);
    }
}
