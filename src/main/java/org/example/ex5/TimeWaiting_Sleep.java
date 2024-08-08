package org.example.ex5;

class NewThread extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(" -- sleep() 진행 중 interrupt 발생");
            for (long i = 0; i < 1000000000L; i++) {

            }
        }
    }
}

class NewThread1 extends Thread {
    @Override
    public void run() {
        for (long i = 0; i < 10000000000L; i++) {}
    }
}
class NewThread2 extends Thread {

    NewThread1 newThread;

    public NewThread2(NewThread1 newThread) {
        this.newThread = newThread;
    }

    @Override
    public void run() {
        try {
            newThread.join(3000);
        } catch (InterruptedException e) {
            System.out.println(" -- join() 진행 중 interrupt 발생");
            for (long i = 0; i < 1000000000L; i++) {

            }
        }
    }
}

public class TimeWaiting_Sleep {

    public static void main(String[] args) throws InterruptedException {
        NewThread1 thread1 = new NewThread1();
        NewThread2 thread2 = new NewThread2(thread1);
        thread1.start();
        thread2.start();

        Thread.sleep(100); // 스레드 시작 준비 시간
        System.out.println("thread1 state = " + thread1.getState()); // RUNNABLE
        System.out.println("thread2 state = " + thread2.getState()); // TIMED_WAITING

        thread2.interrupt();
        System.out.println("thread1 state = " + thread1.getState()); // RUNNABLE
        System.out.println("thread2 state = " + thread2.getState()); // RUNNABLE

//        NewThread thread = new NewThread();
//        thread.start();
//
//        Thread.sleep(100); // 스레드 시작 준비 시간
//        System.out.println("NewThread state = " + thread.getState()); // TIMED_WAITING
//
//        thread.interrupt();
//        Thread.sleep(100); // 스레드 시작 준비 시간
//        System.out.println("NewThread state = " + thread.getState()); // RUNNABLE
    }

}
