package org.example;

class SMIFileThread extends Thread{
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
public class CreateAndStartThread1 {
    public static void main(String[] args) throws InterruptedException {
        // instance SMIFileThread
        SMIFileThread thread = new SMIFileThread();
        thread.start();

        // video frame 1 ~ 5
        int[] intArr = {1,2,3,4,5};

        for(int i = 0; i < intArr.length; i++){
            System.out.print("(Video) " + intArr[i] + " - ");
            Thread.sleep(200);
        }

    }
}
