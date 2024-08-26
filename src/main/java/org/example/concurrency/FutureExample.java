package org.example.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureExample {
    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();

        // Submit a task and retrieve the Future
        Future<String> future = service.submit(()->{
            Thread.sleep(2000);
            return "Task completed";
        });

        // Perform other operations while the task is running

        try{
            //Retrieve the result of the task (blocking call)
            String result = future.get();
            System.out.println("result = " + result);
        }catch (Exception e){
            e.printStackTrace();
        }

        service.shutdown();
    }
}
