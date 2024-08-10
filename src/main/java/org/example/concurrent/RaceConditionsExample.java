package org.example.concurrent;

class Increment{
    private int count = 0;

    void increment(){
        count += 1;
    }

    int getCount(){
        return this.count;
    }

}

/**
 * Race Conditions
 * Sometimes, the result is less than 1000
 * Two threads are reading the count variable before any of them can update the value.
 * In order to avoid race conditions, we need to synchronize tasks.
 */
public class RaceConditionsExample {
    public static void main(String[] args) {
        Increment ic = new Increment();
        for (int i = 0; i < 1000; i++) {
            Thread thread = new Thread(ic::increment);
            thread.start();
        }
        System.out.println(ic.getCount());
    }
}
