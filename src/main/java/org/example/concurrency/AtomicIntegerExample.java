package org.example.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {
    private static final AtomicInteger counter = new AtomicInteger(0);
    private static int nonThreadSafeCounter = 0;

    public static void main(String[] args) {
        Thread incrementThread = new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                counter.incrementAndGet();
                nonThreadSafeCounter++;
            }

        });

        Thread decrementThread = new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                counter.decrementAndGet();
                nonThreadSafeCounter--;
            }
        });

        incrementThread.start();
        decrementThread.start();

        try{
            incrementThread.join();
            decrementThread.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("Counter value: " + counter.get());
        System.out.println("nonThreadSafeCounter value: " + nonThreadSafeCounter);
    }
}
