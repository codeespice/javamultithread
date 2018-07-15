package com.java.multithread.notes10.reentrantlock;

public class ReenitrantLockApp {
    public static void main(String args[])
    {
        final Merchandise merchandise = new Merchandise();
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                merchandise.secondThread();

            }
        });
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                merchandise.firstThread();

            }
        });
        t1.start();
        t2.start();


        try {
            t2.join();
            t1.join();
            merchandise.finished();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
