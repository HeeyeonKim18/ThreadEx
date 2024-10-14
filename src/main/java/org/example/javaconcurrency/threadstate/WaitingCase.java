package org.example.javaconcurrency.threadstate;

public class WaitingCase {
    private synchronized void businessProcessing(){
        try{
            System.out.println("Thread[" + Thread.currentThread().getName() + "] expects to process business, but the computer is broken");
            // Release the monitor(lock)
            wait();
            System.out.println("Thread[" + Thread.currentThread().getName() + "] continues to process business");
            Thread.sleep(2000L);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    private synchronized void repairComputer(){
        System.out.println("Thread[" + Thread.currentThread().getName() + "] comes to repair the computer");
        try{
            // Simulated Repair
            Thread.sleep(1000L);
            System.out.println("Thread[" + Thread.currentThread().getName() + "] has completed the repair");
            notify();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        WaitingCase waitingCase = new WaitingCase();
        Thread A = new Thread(waitingCase::businessProcessing, "A");
        Thread B = new Thread(waitingCase::repairComputer, "B");

        A.start();
        Thread.sleep(500);
        B.start();
        System.out.println("Thread[" + A.getName() + "] state: " + A.getState());
        System.out.println("Thread[" + B.getName() + "] state: " + B.getState());
    }
}
