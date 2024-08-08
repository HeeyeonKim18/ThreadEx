package org.example.ex3;

class MyThread1 extends Thread{
    @Override
    public void run() {
        System.out.println(getName() + " : " + (isDaemon()? "Daemon Thread" : "Default Thread"));
        for (int i = 0; i < 6; i++) {
            System.out.println(getName() + " : " + i + " sec");
            try {Thread.sleep(1000);} catch (InterruptedException e) {}
        }
    }
}

/**
 * As soon as the main thread or any normal thread ends, daemon thread is also terminated
 */
public class ThreadProperties3 {
    public static void main(String[] args) throws InterruptedException {
        // normal thread
        Thread thread1 = new MyThread1();
        thread1.setDaemon(false);
        thread1.setName("thread1");
        thread1.start();

        // daemon thread
        Thread thread2 = new MyThread1();
        thread2.setDaemon(true);
        thread2.setName("thread2");
        thread2.start();

        // after 3 sec, terminate main thread
        Thread.sleep(3000);
        System.out.println("main thread ends");

    }
}
