package org.example.javaconcurrency.threadpriority;

// If the priority of a thread is different from that of its thread group?
// the thread's priority will be invalidated and replaced the maximum priority of the thread group
public class ThreadGroupOrder {
    public static void main(String[] args) {
        ThreadGroup myThreadGroup = new ThreadGroup("myThreadGroup");
        myThreadGroup.setMaxPriority(6);
        Thread myThread = new Thread(myThreadGroup, "myThread");
        myThread.setPriority(8);
        System.out.println("myThreadGroup = " + myThreadGroup.getMaxPriority());
        System.out.println("myThread = " + myThread.getPriority());
    }
}
