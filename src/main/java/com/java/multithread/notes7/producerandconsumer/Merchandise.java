package com.java.multithread.notes7.producerandconsumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Merchandise {

    public BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(10);

    public void produce()
    {
        Random random = new Random();
        while(true)
        {
            try {
                blockingQueue.put(random.nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void consume()
    {
        Random random = new Random();
        while(true)
        {
            try {
                Thread.sleep(100);
                if(random.nextInt(10)==0) {
                   int num=  blockingQueue.take();
                   System.out.println("Take Value "+num + " queue size is "+blockingQueue.size());
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
