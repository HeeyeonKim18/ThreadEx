package org.example.javaconcurrency.threadstop;

public class SleepSplitCase implements Runnable {
    @Override
    public void run() {
        try {
            move();
        } catch (InterruptedException e) {
            System.out.println("error: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
        if(Thread.currentThread().isInterrupted()){
            goBack();
        }
    }

    private void move() throws InterruptedException {
        System.out.println("Start moving...");
        for (int i = 0; i < 5; i++) {
            // Simulation of time required to move
            Thread.sleep(1);
            System.out.println(i + " batches have been moved");
        }
        System.out.println("End of moving...");
    }

    private void goBack() {

    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new SleepSplitCase());
        thread.start();
        // Try to stop it later.
        Thread.sleep(3);
        thread.interrupt();
    }
}
