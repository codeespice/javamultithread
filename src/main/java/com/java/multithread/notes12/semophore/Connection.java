package com.java.multithread.notes12.semophore;

import java.util.concurrent.Semaphore;

public class Connection {

    public int connections =0;
    public static Connection instance = new Connection();
    private Semaphore semaphore = new Semaphore(10);

    public static Connection getConnection()
    {
        return instance;
    }
    public void connect()
    {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (this)
        {
            connections++;
            System.out.println("Number of Conenctions"+connections);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (this) {
            connections--;
        }
        semaphore.release();

    }
}
