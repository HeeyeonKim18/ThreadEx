package org.example;

public class TheNeedForThread {
    public static void main(String[] args) throws InterruptedException {
        // video frame 1 ~ 5
        int[] intArr = {1,2,3,4,5};

        // subtitle number 하나 ~ 다섯
        String[] strArr = {"하나", "둘", "셋", "넷", "다섯"};

        for(int i = 0; i < intArr.length; i++){
            System.out.println("(Video) " + intArr[i]);
            Thread.sleep(200);
        }

        for (int i = 0; i < strArr.length; i++) {
            System.out.println("(Subtitle Num) " + strArr[i]);
            Thread.sleep(200);
        }
    }
}
