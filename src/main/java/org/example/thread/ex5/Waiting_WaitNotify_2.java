package org.example.thread.ex5;

class DataBox2 {
    boolean isEmpty = true;
    int data;

    synchronized void inputData(int data) {
        if(!isEmpty) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.data = data;
        isEmpty = false;
        System.out.println("input data: " + data);
        notify();
    }

    synchronized void outputData() {
        if(isEmpty) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        isEmpty = true;
        System.out.println("output data: " + data);
        notify();
    }
}

public class Waiting_WaitNotify_2 {
    public static void main(String[] args) {
        DataBox2 dataBox2 = new DataBox2();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 9; i++) {
                dataBox2.inputData(i);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 9; i++) {
                dataBox2.outputData();
            }
        });

        t1.start();
        t2.start();
    }
}
