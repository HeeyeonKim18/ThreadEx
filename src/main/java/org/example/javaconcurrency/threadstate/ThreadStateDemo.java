package org.example.javaconcurrency.threadstate;

public class ThreadStateDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
        });
        System.out.println("thread.getState() = " + thread.getState());  // NEW

        thread.start(); // first call
        System.out.println("thread.getState() = " + thread.getState()); // RUNNABLE
        thread.start(); // second call, Error occurs
    }
}
