package org.example.ex3;

public class ThreadProperties {
    public static void main(String[] args) {

        // getInstance(currentThread() / activeCount())
        Thread curThread = Thread.currentThread();
        System.out.println("This Thread: " + curThread.getName());
        System.out.println("Active Thread: " + Thread.activeCount());

        // setName
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread();
            thread.setName("thread " + i + " 번째");
            System.out.println(thread.getName());
            thread.start();
        }

        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread();
            System.out.println(thread.getName());
            thread.start();
        }

        System.out.println("Active Thread: " + Thread.activeCount());
    }
}
