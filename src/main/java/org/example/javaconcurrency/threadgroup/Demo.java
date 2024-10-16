package org.example.javaconcurrency.threadgroup;

public class Demo {
    public static void main(String[] args) {
        Thread subThread = new Thread(()-> {
            System.out.println("The name of the thread group where subThread is located is: " +
                    Thread.currentThread().getThreadGroup().getName());

            System.out.println("The name of the current thread(subThread) is: " +
                    Thread.currentThread().getName());
        });

        subThread.start();
        System.out.println("The thread group name of the thread in which the main() method is executed is: "
                + Thread.currentThread().getThreadGroup().getName());
        System.out.println("The name of the current thread is: "
                + Thread.currentThread().getName());
    }
}
