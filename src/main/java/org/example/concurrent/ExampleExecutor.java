package org.example.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExampleExecutor {
    public static void main(String[] args) {
        // create and queue up only two threads and reuse existing threads
        ExecutorService executor = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 20; i++) {
            int finalI = i;
            executor.submit(()->
                System.out.println(Thread.currentThread().getName() + " is executing task " + finalI)
            );
        }
        executor.shutdown();
    }
}
