package org.example.concurrency;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinExample extends RecursiveTask<Long> {
    private static final int THRESHOLD = 1000;
    private final int[] array;
    private final int start;
    private final int end;

    public ForkJoinExample(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if (end - start <= THRESHOLD) {
            return computeDirectly();
        } else {
            int mid = start + (end - start) / 2;
            ForkJoinExample leftTask = new ForkJoinExample(array, start, mid);
            ForkJoinExample rightTask = new ForkJoinExample(array, mid + 1, end);

            leftTask.fork();
            rightTask.fork();

            return leftTask.join() + rightTask.join();
        }
    }

    private Long computeDirectly() {
        long sum = 0;
        for (int i = start; i <= end; i++) {
            sum += array[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] array = new int[10000]; // Initialize the array

        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        ForkJoinExample task = new ForkJoinExample(array, 0, array.length - 1);

        long sum = forkJoinPool.invoke(task);
        System.out.println("Sum: " + sum);
    }
}