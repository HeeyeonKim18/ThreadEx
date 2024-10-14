package org.example.javaconcurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable myCallable = new MyCallable();
        FutureTask<Integer> futureTask = new FutureTask<>(myCallable);
        Thread t = new Thread(futureTask);
        t.start();
        Integer res = futureTask.get();
        System.out.println("res = " + res);
    }
}
