package org.example.javaconcurrency.threadpriority;

// This priority setting is really not reliable since the result is not same as expected(t3 -> t2 -> t1)
public class TestExecuteOrder {

    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            System.out.printf("The currently executing thread is :%s, priority:%s",
                    Thread.currentThread().getName(), Thread.currentThread().getPriority() + "\n");
        }
    }
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunnable());
        t1.setPriority(1);

        Thread t2 = new Thread(new MyRunnable());
        t2.setPriority(5);

        Thread t3 = new Thread(new MyRunnable());
        t3.setPriority(10);

        t3.start();
        t2.start();
        t1.start();
    }
}
