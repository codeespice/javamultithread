package com.java.multithread.notes5.threadpool;

public class Processor implements Runnable {
    private int id;
    Processor(int id)
    {
        this.id=id;
    }
    public void run() {
        System.out.println("Starting Thread ...."+id);
        try{
            Thread.sleep(5000);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        System.out.println("completed the task.."+id);
    }
}
