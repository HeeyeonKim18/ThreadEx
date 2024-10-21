package org.example.javaconcurrency.threadsafe;

public class ResultError {

    static int count;

    public static void main(String[] args) throws InterruptedException {
        Runnable r = ()->{
            for(int i = 0; i < 10000; i++){
                count++;
            }
        };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count); // the result should be 20000
    }
}
