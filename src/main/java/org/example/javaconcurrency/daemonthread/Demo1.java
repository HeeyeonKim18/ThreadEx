package org.example.javaconcurrency.daemonthread;

public class Demo1 {
    public static void main(String[] args) throws InterruptedException {
        // Create a user thread
        Thread userThread = new Thread(()->{
            // Infinite loop
            while(true){
                System.out.println("User thread is running..");
                try{
                    Thread.sleep(2000L);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        userThread.start();
        Thread.sleep(1000);
        Runtime.getRuntime().addShutdownHook(new Thread(()-> System.out.println("shutdown hook is running...")));
        System.out.println("The main thread is about to finish execution");
    }
}
