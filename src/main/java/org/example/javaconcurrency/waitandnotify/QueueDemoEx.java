package org.example.javaconcurrency.waitandnotify;

// Error: current thread is not owner
public class QueueDemoEx {
    public static void main(String[] args) throws InterruptedException {
        QueueDemo q = new QueueDemo();
        q.start();

        q.save("a");
        q.take();

        q.save("b");
        q.take();
    }
}
