package com.java.multithread.notes6.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Processor implements Runnable {
    private int id;
    private CountDownLatch countDownLatch;
    Processor(int id,CountDownLatch countDownLatch)
    {
        this.id=id;
        this.countDownLatch=countDownLatch;
    }
    public void run() {
        System.out.println("Starting Thread ...."+id);
        try{
            Thread.sleep(5000);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        countDownLatch.countDown();
        System.out.println("completed the task.."+id);
    }
}
