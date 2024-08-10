package org.example.thread.ex5;

class MyThread extends Thread{
    boolean yieldflag;
    @Override
    public void run() {
        while(true){
            if(yieldflag){
                Thread.yield();
            }else{
                System.out.println(getName() + " start");
                for (long i = 0; i < 1000000000L; i++) {}
            }
        }
    }
}
public class YieldRunnableState {
    public static void main(String[] args) throws InterruptedException {
        MyThread thread1 = new MyThread();
        thread1.setName("thread1");
        thread1.yieldflag = false;
        thread1.setDaemon(true); // due to while loop
        thread1.start();

        MyThread thread2 = new MyThread();
        thread2.setName("thread2");
        thread2.yieldflag = true;
        thread2.setDaemon(true); // due to while loop
        thread2.start();

        for (int i = 0; i < 6; i++) {
            Thread.sleep(1000);
            thread1.yieldflag=!thread1.yieldflag;
            thread2.yieldflag=!thread2.yieldflag;
        }

    }
}
