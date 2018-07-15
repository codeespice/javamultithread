package com.java.multithread.notes2.join;

public class JoinApp {
    private int count=0;
    public static void main(String args[])
    {
        JoinApp app = new JoinApp();
        app.doWork();
    }
    public void doWork()
    {
        Thread  t1= new Thread(new Runnable() {
            public void run() {
                for(int i=0;i<10000;i++)
                {
                 count++;

                }
            }
        });
        Thread  t2= new Thread(new Runnable() {
            public void run() {
                for(int i=0;i<10000;i++)
                {
                    count++;

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

        System.out.println("count is " + count); //because count is not syncrhonized you will see different values for count everytime you run
    }
}
