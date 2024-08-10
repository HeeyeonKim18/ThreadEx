package org.example.thread.ex5;

public class NewRunnableTerminated {
    public static void main(String[] args) throws InterruptedException {

        // thread state
        Thread.State state;

        // create instance
        Thread thread = new Thread(() ->{
            for (long i = 0; i < 10000000L; i++) {}
        });

        state = thread.getState();
        System.out.println("thread state: " + state); // NEW

        // start thread
        thread.start();
        state = thread.getState();
        System.out.println("thread state: " + state); // Runnable

        // terminate thread
        thread.join();
        state = thread.getState();
        System.out.println("thread state: " + state); // Terminated
    }
}
