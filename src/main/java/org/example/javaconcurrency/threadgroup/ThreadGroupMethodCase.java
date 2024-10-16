package org.example.javaconcurrency.threadgroup;

public class ThreadGroupMethodCase {
    public static void main(String[] args) throws InterruptedException {
        ThreadGroup subgroup1 = new ThreadGroup("subgroup1");
        Thread t1 = new Thread(subgroup1, "t1 in subgroup1");
        Thread t2 = new Thread(subgroup1, "t2 in subgroup1");
        Thread t3 = new Thread(subgroup1, "t3 in subgroup1");
        t1.start();
        Thread.sleep(50);
        t2.start();
        int activeCount = subgroup1.activeCount();
        System.out.println("Active thread in " + subgroup1.getName() + "thread group: " + activeCount);

        ThreadGroup subgroup2 = new ThreadGroup("subgroup2");
        Thread t4 = new Thread(subgroup2, "t4 in subgroup2");

        ThreadGroup currentThreadGroup = Thread.currentThread().getThreadGroup();
        int activeGroupCount = currentThreadGroup.activeGroupCount();
        System.out.println("Active thread group in " + currentThreadGroup.getName() + "thread group: " + activeGroupCount);

        System.out.println("Prints information about currentThreadGroup to the standard output:");
        currentThreadGroup.list();
    }
}
