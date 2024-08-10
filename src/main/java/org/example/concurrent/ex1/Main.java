package org.example.concurrent.ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int taskNum = 10;
        ExecutorService es = Executors.newFixedThreadPool(2);

        List<CallableEx> list = new ArrayList<>();
        for (int i = 0; i < taskNum; i++) {
            list.add(new CallableEx(i + 1));
        }

        System.out.println("------start------");
        List<Future<String>> futures = es.invokeAll(list);
        System.out.println("------end-------\n");

        System.out.println("------result------");
        for (Future<String> future : futures) {
            System.out.println(future.get());
        }

        es.shutdown();
    }
}
