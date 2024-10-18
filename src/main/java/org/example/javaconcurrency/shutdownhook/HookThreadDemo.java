package org.example.javaconcurrency.shutdownhook;

public class HookThreadDemo {
    private static class HookRunnable implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println("Hook " + Thread.currentThread().getName() + " is executing...");
                Thread.sleep(2000L);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hook " + Thread.currentThread().getName() + " is about to end execution");
        }
    }

    public static void main(String[] args) {
        HookRunnable runnable = new HookRunnable();
        // add hook thread 0
        Runtime.getRuntime().addShutdownHook(new Thread(runnable));
        // add hook thread 1
        Runtime.getRuntime().addShutdownHook(new Thread(runnable));

        System.out.println("The main thread is going to finish executing.");
    }
}
