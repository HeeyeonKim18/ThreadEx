package org.example.javaconcurrency.threadgroup;

public class Structure {
    public static void main(String[] args) {
        ThreadGroup mainThreadGroup = Thread.currentThread().getThreadGroup();
        ThreadGroup systemThreadGroup = mainThreadGroup.getParent();

        System.out.println("The name of the parent thread group is :" + systemThreadGroup.getName());
        System.out.println("The name of the thread group where the current thread is located is: " + mainThreadGroup.getName());
    }
}
