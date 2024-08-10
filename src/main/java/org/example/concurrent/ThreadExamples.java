package org.example.concurrent;

public class ThreadExamples {
    public static void main(String[] args) {
        // method 1
        ExampleThread et = new ExampleThread();
        et.start();
        // method 2
        Runnable runnable = new ExampleRunnable();
        new Thread(runnable).start();
        // method 3
        Thread thread = new Thread(()->{
            System.out.println(Thread.currentThread().getName());
        });
        thread.start();
    }
}
