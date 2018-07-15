package com.java.multithread.notes5.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.TimeUnit.DAYS;

public class ThreaPoolApp {
    public static void main(String args[])
    {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for(int i=0;i<10;i++)
        {
            executorService.submit(new Processor(i));
        }
        executorService.shutdown();
        System.out.println("All threads are submitted");
        try {
            executorService.awaitTermination(1, DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Shutting Down all the threads");
    }
}
