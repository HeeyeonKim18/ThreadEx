package org.example.thread.ex5;

class DataBox{
    int data;
    synchronized void inputData(int data){
        this.data = data;
        System.out.println("input data: " + data);
    }

    synchronized void outputData(){
        System.out.println("output data: " + data);
    }
}
public class Waiting_WaitNotify_1 {
    public static void main(String[] args) {
        DataBox2 dataBox2 = new DataBox2();

        Thread t1 = new Thread(()->{
            for (int i = 0; i < 9; i++) {
                dataBox2.inputData(i);
            }
        });

        Thread t2 = new Thread(()->{
            for (int i = 0; i < 9; i++) {
                dataBox2.outputData();
            }
        });

        t1.start();
        t2.start();
    }
}
