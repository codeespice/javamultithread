package com.java.multithread.notes11.deadlock;

public class DeadLockLockApp {
    public static void main(String args[])
    {
        final AccountManager accountManager = new AccountManager();
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                accountManager.firstThread();

            }
        });
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                accountManager .secondThread();

            }
        });
        t1.start();
        t2.start();


        try {
            t2.join();
            t1.join();
            accountManager.finished();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
