package org.example.concurrency;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        int numberOfTasks = 3;
        CountDownLatch latch = new CountDownLatch(numberOfTasks);

        Runnable task = () -> {
            // Perform the task
            System.out.println(Thread.currentThread().getName()+ " Task completed.");

            // Signal that the task is completed
            latch.countDown();
        };

        // Create and start multiple threads
        for (int i = 0; i < numberOfTasks; i++) {
            new Thread(task).start();
        }

        // Wait for all tasks to complete
        latch.await();

        System.out.println("All tasks completed. Proceeding further.");
    }
}
