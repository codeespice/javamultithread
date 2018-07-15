package com.java.multithread.notes9.lowlevelsynchronization;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Merchandise {

    public LinkedList<Integer> itemList = new LinkedList<Integer>();
    public Object lock = new Object();
    public int FINAL_LIMIT =10;

    public void produce()
    {
        int value=0;
        while(true) {
            synchronized (lock) {
                while(itemList.size()==FINAL_LIMIT)
                {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                itemList.add(value++);
                lock.notify();
            }
        }
    }
    public void consume() {
        while (true) {
            synchronized (lock) {
                    while(itemList.size()==0)
                    {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("ItemList size :"+itemList.size());
                    int value = itemList.removeFirst();

                    System.out.print("value is "+value);
                    lock.notify();



            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
