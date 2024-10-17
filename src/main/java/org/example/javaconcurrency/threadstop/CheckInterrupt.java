package org.example.javaconcurrency.threadstop;

public class CheckInterrupt {
    public static void main(String[] args) {
        Thread subThread = new Thread(()->{
            for(; ; ){
            }
        });

        subThread.start();
        subThread.interrupt();
        // Get interrupt flag
        System.out.println("subThread.isInterrupted() = " + subThread.isInterrupted());
        // Thread.interrupted() has the same effect as subThread.interrupted();
        System.out.println("Thread.interrupted() = " + Thread.interrupted());
    }
}
