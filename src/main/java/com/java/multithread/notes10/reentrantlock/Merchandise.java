package com.java.multithread.notes10.reentrantlock;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Merchandise {

    public LinkedList<Integer> itemList = new LinkedList<Integer>();
    public Lock lock = new ReentrantLock();
    public Condition cond = lock.newCondition();
    private int count=0;
    public int FINAL_LIMIT =10;

    public void increment()
    {
        for(int i=0;i<10000;i++)
        {
            count++;
        }
    }
    public void firstThread()
    {
        lock.lock();//same like synchronization
        try {
            cond.await();//same like wait
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            increment();
        }
        finally {
            lock.unlock();//same like synchronization
        }
    }
    public void secondThread() {

        try {
            Thread.sleep(1000);
            lock.lock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Enter Input");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        System.out.println("Obtained user Input");
        cond.signalAll(); //same like notify
        try {
            increment();
        }
        finally {
            lock.unlock();
        }
    }
    public void finished()
    {
        System.out.println("Count is "+count);
    }
}
