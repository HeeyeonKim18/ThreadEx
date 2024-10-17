package org.example.javaconcurrency.threadstop;

public class SleepWithIsInterrupted implements Runnable {
    @Override
    public void run() {
        System.out.println("Start moving...");
        for (int i = 0; i < 5; i++) {
            if(Thread.currentThread().isInterrupted()) break;

            // Simulation of time required to move
            try{
                Thread.sleep(1);
                System.out.println(i + " batches have been moved");
            } catch (Exception e) {
                System.out.println("error: "+ e.getMessage());
                break;
            }
        }
        System.out.println("End of moving...");
    }
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new InterruptWithSleep());
        thread.start();
        // Try to stop it later.
        Thread.sleep(3);
        thread.interrupt();
    }
}
