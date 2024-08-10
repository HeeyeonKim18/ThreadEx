package org.example.concurrent.ex1;

import java.time.Duration;
import java.time.LocalTime;
import java.util.concurrent.Callable;

public class CallableEx implements Callable<String> {
    private int idx;

    public CallableEx(int idx) {
        this.idx = idx;
    }

    @Override
    public String call() throws Exception {
        LocalTime startTime = LocalTime.now();
        System.out.println(Thread.currentThread().getName() + ": " + idx + ", startTime: " + startTime);
        LocalTime endTime = LocalTime.now();
        return String.valueOf(idx + ": " + Duration.between(startTime, endTime).toMillis());
    }
}
