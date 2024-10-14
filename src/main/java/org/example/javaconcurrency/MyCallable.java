package org.example.javaconcurrency;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int res = 0;
        for (int i = 0; i < 5; i++) {
            res += i;
        }
        return res;
    }
}