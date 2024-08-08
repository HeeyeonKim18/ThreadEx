package org.example.ex5;

class MyBlockTest{
    // shared instance
    MyClass mc = new MyClass();

    // create three threads
    Thread thread1 = new Thread(()->{
        mc.syncMethod();
    });

    Thread thread2 = new Thread(()->{
        mc.syncMethod();
    });

    void startAll(){
        thread1.start();
        thread2.start();
        thread3.start();
    }

    Thread thread3 = new Thread(()->{
        mc.syncMethod();
    });

    class MyClass{
        synchronized void syncMethod() {
            try {Thread.sleep(100);} catch (InterruptedException e) {}
            System.out.println("=== " + Thread.currentThread().getName() + " ==== ");
            System.out.println("t1 -> " + thread1.getState());
            System.out.println("t2 -> " + thread2.getState());
            System.out.println("t3 -> " + thread3.getState());

            for (long i = 0; i < 1000000000L; i++) {}
        }
    }
}
public class BlockedState {
    public static void main(String[] args) {
        MyBlockTest mbt = new MyBlockTest();
        mbt.startAll();
    }
}
