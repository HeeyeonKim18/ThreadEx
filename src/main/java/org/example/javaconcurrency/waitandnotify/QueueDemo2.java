package org.example.javaconcurrency.waitandnotify;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo2 {

    Queue<String> buffer = new LinkedList<String>();

    public synchronized void save(String data){
        System.out.println("Produce a data");
        buffer.add(data);
        notify();   // Since someone maybe waiting in take()
    }

    public synchronized String take() throws InterruptedException {
        System.out.println("Try to consume a data");
        while(buffer.isEmpty()){
            wait();
        }
        return buffer.remove();
    }

    public static void main(String[] args) {
        QueueDemo2 queue = new QueueDemo2();
        Thread producer = new Thread(()->{
            queue.save("Hello World");
        });

        Thread consumer = new Thread(()->{
            try{
                System.out.println(queue.take());
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });

        consumer.start();
        producer.start();
    }
}
