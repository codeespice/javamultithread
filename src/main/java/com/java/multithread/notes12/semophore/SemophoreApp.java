package com.java.multithread.notes12.semophore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SemophoreApp {
    public static void main(String args[])
    {
        ExecutorService executorService =Executors.newCachedThreadPool();
        for(int i=0;i<200;i++)
        {
            executorService.submit(new Runnable() {
                public void run() {
                Connection.getConnection().connect();
                }
            });
        }
        try {
            executorService.shutdown();
            executorService.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
