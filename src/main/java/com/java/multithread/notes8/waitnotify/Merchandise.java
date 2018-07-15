package com.java.multithread.notes8.waitnotify;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Merchandise {

    public BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(10);

    public void produce()
    {
        synchronized (this){
            System.out.println("Producer is Waiting");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Producer is resumed");
        }
    }
    public void consume()
    {
        Scanner scanner = new Scanner(System.in);
        synchronized (this){
            System.out.println("Consumer Waiting for user Input");
            try {
                scanner.nextLine();
                System.out.println("Consumer return Key is Pressed");
                notify();
                Thread.sleep(5000);
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    }
}
