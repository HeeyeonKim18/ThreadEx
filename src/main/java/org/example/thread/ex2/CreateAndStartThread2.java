package org.example.thread.ex2;

class SMIFileThread2 extends Thread{
    @Override
    public void run() {
        // subtitle number 하나 ~ 다섯
        String[] strArr = {"하나", "둘", "셋", "넷", "다섯"};
        try {Thread.sleep(10);} catch (InterruptedException e) {}
        for (int i = 0; i < strArr.length; i++) {
            System.out.println("(Subtitle Num) " + strArr[i]);
            try {Thread.sleep(200);} catch (InterruptedException e) {}
        }

    }
}

class VideoThread extends Thread{
    @Override
    public void run() {
        // video frame 1 ~ 5
        int[] intArr = {1,2,3,4,5};

        for(int i = 0; i < intArr.length; i++){
            System.out.print("(Video) " + intArr[i] + " - ");
            try {Thread.sleep(200);} catch (InterruptedException e) {}
        }
    }
}
public class CreateAndStartThread2 {
    public static void main(String[] args) throws InterruptedException {
        // instance SMIFileThread
        SMIFileThread2 thread = new SMIFileThread2();
        thread.start();

        // instance VideoThread
        VideoThread videoThread = new VideoThread();
        videoThread.start();



    }
}
