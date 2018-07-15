package com.java.multithread.notes1.basic;

public class App {
    public static void main(String args[]) {
        System.out.println("Oam Vigneswara");
        Procesor p = new Procesor();
        p.start();
        Thread  t= new Thread(new Runnable() {
            public void run() {
                for(int i=0;i<20;i++)
                {
                    System.out.println(Thread.currentThread().getName()+" hello");
                    try {
                        Thread.sleep(1000);
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }

                }
            }
        });
        t.start();


    }
}
