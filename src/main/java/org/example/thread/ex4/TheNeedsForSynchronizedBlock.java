package org.example.thread.ex4;

// shared instance
class MyData1{
    int data = 3;

    public void plusData(){
        synchronized (this) {
            int myData = data;
            try {Thread.sleep(2000);} catch (InterruptedException e) {}
            data = myData + 1;
        }
    }
}

// thread using the shared instance
class PlusThread1 extends Thread{
    MyData1 data = new MyData1();

    public PlusThread1(MyData1 data){
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
public class TheNeedsForSynchronizedBlock {
    public static void main(String[] args) throws InterruptedException {
        // create the shared instance
        MyData1 data = new MyData1();

        Thread thread1 = new PlusThread1(data);
        thread1.setName("thread1");
        thread1.start();

        Thread.sleep(1000);

        Thread thread2 = new PlusThread1(data);
        thread2.setName("thread2");
        thread2.start();
    }
}
