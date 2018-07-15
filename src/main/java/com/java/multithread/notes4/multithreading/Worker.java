package com.java.multithread.notes4.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
//Without Synchronized
public class Worker {
    Random random = new Random();

    public List<Integer> getList1() {
        return list1;
    }

    public void setList1(List<Integer> list1) {
        this.list1 = list1;
    }

    public List<Integer> getList2() {
        return list2;
    }

    public void setList2(List<Integer> list2) {
        this.list2 = list2;
    }

    private List<Integer> list1 = new ArrayList<Integer>();
    private List<Integer> list2 = new ArrayList<Integer>();

    public void stageOne()
    {
        try
        {
            Thread.sleep(1);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        list1.add(random.nextInt(100));
    }
    public void stageTwo()
    {
        try
        {
            Thread.sleep(1);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        list2.add(random.nextInt(100));
    }
    public void process()
    {
        for(int i=0;i<1000;i++) {
            stageOne();
            stageTwo();
        }

    }
    public  static void main(String args[])
    {
        System.out.println("Starting.....");
        long start = System.currentTimeMillis();
        final Worker worker = new Worker();
        Thread t1 = new Thread(new Runnable() {
            public void run() {


                worker.process();
            }
        });
        t1.start();
        Thread t2 = new Thread(new Runnable() {
            public void run() {


                worker.process();
            }
        });
        t2.start();
        try {
            t1.join();
            t2.join();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }


        long end = System.currentTimeMillis();
        System.out.println("total time = " +(end-start));

        System.out.println("List1 size ="+worker.getList1().size() + " List2 size="+worker.getList2().size());
    }
}
