package org.example.javaconcurrency.threadstate;

public class BlockCase {
    private synchronized void businessProcessing(){
        try{
            System.out.println("Thread[" + Thread.currentThread().getName() + "] performs business processing");
            Thread.sleep(2000L);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BlockCase blockCase = new BlockCase();
        Thread A = new Thread(blockCase::businessProcessing, "A");
        Thread B = new Thread(blockCase::businessProcessing, "B");

        A.start();
        // Thread.sleep(1000); // Sleep time should be less than business processing: TIMED_WAITING
        B.start();
        System.out.println("Thread[" + A.getName() + "] state: " + A.getState());
        System.out.println("Thread[" + B.getName() + "] state: " + B.getState());
    }
}
