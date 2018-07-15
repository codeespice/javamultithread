package com.java.multithread.notes1.basic;

public class Procesor extends Thread {

    public void run()
    {
        for(int i=0;i<20;i++)
        {
            System.out.println(this.currentThread().getName()+" hello");
            try {
                Thread.sleep(1000);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }

        }
    }


}
