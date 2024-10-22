package org.example.javaconcurrency.synchronize;

public class StaticSynchronizedBlockDemo implements Runnable {

    static int count;

    public static void perform(){
        synchronized(StaticSynchronizedBlockDemo.class){
            for (int i = 0; i < 10000; i++) {
                count++;
            }
        }
    }

    public void run(){
        perform();
    }

    public static void main(String[] args) throws InterruptedException {
        StaticSynchronizedBlockDemo staticSynchronizedBlockDemo = new StaticSynchronizedBlockDemo();

        Thread t1 = new Thread(staticSynchronizedBlockDemo);
        Thread t2 = new Thread(staticSynchronizedBlockDemo);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count);
    }

}
