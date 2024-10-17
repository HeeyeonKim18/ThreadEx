package org.example.javaconcurrency.threadpriority;

// Not recommend to set the priority of threads
// Since the real order of execution is determined by the operating system's thread scheduling algorithm
public class Demo {
    public static void main(String[] args) {
        Thread a = new Thread();
        System.out.println("a.getPriority() = " + a.getPriority());
        Thread b = new Thread();
        b.setPriority(9);
        System.out.println("b.getPriority() = " + b.getPriority());
    }
}
