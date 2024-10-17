package org.example.javaconcurrency.threadstop;

// Using the interrupt flag, the current thread finishes right away
public class InterruptThread implements Runnable {
    @Override
    public void run() {
        System.out.println("Start moving...");
        for (int i = 0; i < 100; i++) {
            if(Thread.currentThread().isInterrupted()){
                // Do some finishing work
                break;
            }

            // Simulation of time required to move
            int j = 50000;
            while(j > 0) j--;
            System.out.println(i + "batches have been moved");
        }
        System.out.println("End of moving...");
    }
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new InterruptThread());
        thread.start();
        // Try to stop it later.
        Thread.sleep(2);
        thread.interrupt();
    }
}
