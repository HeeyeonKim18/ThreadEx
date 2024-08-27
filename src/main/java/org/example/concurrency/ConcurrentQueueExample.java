package org.example.concurrency;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentQueueExample {
    public static void main(String[] args) {
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();

        queue.offer("element 1");
        queue.offer("element 2");
        queue.offer("element 3");

        System.out.println("queue.size() = " + queue.size());

        String element = queue.poll();
        System.out.println("removed element = " + element);

        String firstElement = queue.peek();
        System.out.println("firstElement = " + firstElement);
    }
}
