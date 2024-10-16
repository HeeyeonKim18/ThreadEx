package org.example.javaconcurrency.waitandnotify;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo extends Thread {

    Queue<String> buffer = new LinkedList<String>();

    public void save(String data){
        buffer.add(data);
        notify();
    }

    public String take() throws InterruptedException {
        while (buffer.isEmpty()) {
            wait();
        }
        return buffer.remove();
    }

}
