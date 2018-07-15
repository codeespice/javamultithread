package com.java.multithread.notes2.join;

public class JoinAppSynchronized {
    private int count=0;
    public static void main(String args[])
    {
        JoinAppSynchronized app = new JoinAppSynchronized();
        app.doWork();
    }
    //Synchronized count always make sure one thread updates count
   public synchronized void increment()
   {
       count++;
   }
    public void doWork()
    {
        Thread  t1= new Thread(new Runnable() {
            public void run() {
                for(int i=0;i<10000;i++)
                {
                    increment();

                }
            }
        });
        Thread  t2= new Thread(new Runnable() {
            public void run() {
                for(int i=0;i<10000;i++)
                {
                    increment();

                }
            }
        });
        t1.start();
        t2.start();
        try
        {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("count is " + count);
    }
}
