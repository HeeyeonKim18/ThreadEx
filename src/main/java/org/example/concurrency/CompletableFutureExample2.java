package org.example.concurrency;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample2 {
    public static void main(String[] args) {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(()-> 10);
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(()-> 20);

        CompletableFuture<Integer> combinedFuture = future1.thenCombine(future2, Integer::sum);

        int result = combinedFuture.join();
        System.out.println("result = " + result);

    }
}
