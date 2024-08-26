package org.example.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {
    public static void main(String[] args) {
        // Create an ExecutorService with a fixed thread pool of 3 threads
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // Submit tasks for execution
        executorService.submit(()-> System.out.println("task 1"));
        executorService.submit(()-> System.out.println("task 2"));
        executorService.submit(()-> System.out.println("task 3"));

        // Shutdown the ExecutorService
        executorService.shutdown();
    }
}
