package org.example.javaconcurrency.threadgroup;

public class ConstructDemo {
    public static void main(String[] args) {
        ThreadGroup subThreadGroup1 = new ThreadGroup("subThreadGroup1");
        ThreadGroup subThreadGroup2 = new ThreadGroup(subThreadGroup1,"subThreadGroup2");
        System.out.println("subThreadGroup1 parent name is : " + subThreadGroup1.getParent().getName());
        System.out.println("subThreadGroup2 parent name is : " + subThreadGroup2.getParent().getName());
    }
}
