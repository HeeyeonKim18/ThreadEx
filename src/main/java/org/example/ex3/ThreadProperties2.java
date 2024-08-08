package org.example.ex3;

class MyThread extends Thread {
    @Override
    public void run() {
        for (long i = 0; i < 10000000; i++) {}
        System.out.println(getName() + " priority: " + getPriority());

    }
}

public class ThreadProperties2 {
    public static void main(String[] args) {
        // CPU core count
        System.out.println("Core: " + Runtime.getRuntime().availableProcessors());

        // Default priority
        for (int i = 0; i < 3; i++) {
            Thread thread = new MyThread();
            thread.start();
        }

        for (int i = 0; i < 10; i++) {
            Thread thread = new MyThread();
            thread.setName(i + " Thread");
            if(i == 7) thread.setPriority(Thread.MAX_PRIORITY);
            thread.start();
        }
    }
}
