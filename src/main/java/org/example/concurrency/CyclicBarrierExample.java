package org.example.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    public static void main(String[] args) {
        int numberOfThreads = 3;
        CyclicBarrier barrier = new CyclicBarrier(numberOfThreads, () ->
                System.out.println("Barrier reached. All threads have arrived."));

        Runnable task = () -> {
            try{
                System.out.println(Thread.currentThread().getName()+ " is waiting at the barrier.");
                barrier.await();
                System.out.println(Thread.currentThread().getName()+ " has passed the barrier.");
            }catch(InterruptedException | BrokenBarrierException e){
                e.printStackTrace();
            }
        };

        // Create and start multiple threads
        for (int i = 0; i < numberOfThreads; i++) {
            new Thread(task).start();
        }
    }
}
