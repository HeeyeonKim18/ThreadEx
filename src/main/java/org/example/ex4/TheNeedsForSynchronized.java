package org.example.ex4;

// shared instance
class MyData{
    int data = 3;

    public synchronized void plusData(){
        int myData = data;
        try {Thread.sleep(2000);} catch (InterruptedException e) {}
        data = myData + 1;
    }
}

// thread using the shared instance
class PlusThread extends Thread{
    MyData data = new MyData();

    public PlusThread(MyData data){
        this.data = data;
    }
    @Override
    public void run() {
        data.plusData();
        System.out.println(getName() + " result: " + data.data);
    }
}

/**
 * with Synchronized
 * result = 5
 *
 * without Synchronized
 * result = 4
 */
public class TheNeedsForSynchronized {
    public static void main(String[] args) throws InterruptedException {
        // create the shared instance
        MyData data = new MyData();

        Thread thread1 = new PlusThread(data);
        thread1.setName("thread1");
        thread1.start();

        Thread.sleep(1000);

        Thread thread2 = new PlusThread(data);
        thread2.setName("thread2");
        thread2.start();
    }
}
