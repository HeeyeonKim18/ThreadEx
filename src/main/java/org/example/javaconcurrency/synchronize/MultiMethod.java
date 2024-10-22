package org.example.javaconcurrency.synchronize;

// Since the locks required to enter increase and increaseNonStatic are different,
// t1 and t2 will not execute the operations on the shared variable count in a mutually exclusive manner,
// which will cause thread safety issues and result in the value of count not being 20000.
public class MultiMethod {
    static int count = 0;

    static class StaticIncreaseThread implements Runnable {
        public static synchronized void increase() {
            count++;
        }

        public void run() {
            for (int i = 0; i < 10000; i++) {
                increase();
            }
        }
    }

    static class NonStaticIncreaseThread implements Runnable {
        public static synchronized void increaseNonStatic() {
            count++;
        }

        public void run() {
            for (int i = 0; i < 10000; i++) {
                increaseNonStatic();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new StaticIncreaseThread());
        Thread t2 = new Thread(new NonStaticIncreaseThread());

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println(count);
    }


}
