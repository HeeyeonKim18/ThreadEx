package org.example.javaconcurrency.synchronize;

public class InstanceMethodDemo {
    public int count = 0;

    public synchronized void increase(){
        count++;
    }

    public static void main(String[] args) throws InterruptedException {
        InstanceMethodDemo instanceMethodDemo = new InstanceMethodDemo();
        Runnable runnable = () -> {
            for (int i = 0; i < 10000; i++) {
                instanceMethodDemo.increase();
            }
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(instanceMethodDemo.count);
    }
}
