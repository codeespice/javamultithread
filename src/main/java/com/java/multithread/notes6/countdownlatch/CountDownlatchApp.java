package com.java.multithread.notes6.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CountDownlatchApp {

    public static void main(String args[])
    {
        CountDownLatch countDownLatch = new CountDownLatch(3);


           Thread t1 = new Thread(new Processor(1,countDownLatch));
            Thread t2 = new Thread(new Processor(2,countDownLatch));
            Thread t3 = new Thread(new Processor(3,countDownLatch));
            t1.start();
            t2.start();
            t3.start();

        System.out.println("All threads are submitted");
        try {

            countDownLatch.await();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Shutting Down all the threads");
    }
}
