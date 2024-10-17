package org.example.javaconcurrency.threadstop;

// Using interrupt() method, we can find that there is no effect since it seems to ignore us completely.
public class StopThread implements Runnable {
    @Override
    public void run() {
        System.out.println("Start moving...");
        for (int i = 0; i < 6; i++) {
            // Simulation of time required to move
            int j = 50000;
            while(j > 0) j--;
            System.out.println(i + "batches have been moved");
        }
        System.out.println("End of moving...");
    }
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new StopThread());
        thread.start();
        // Try to stop it later.
        Thread.sleep(2);
        //thread.stop(); // It is deprecated
        thread.interrupt();
    }
}
