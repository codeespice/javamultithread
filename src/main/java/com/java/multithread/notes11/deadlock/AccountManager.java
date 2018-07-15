package com.java.multithread.notes11.deadlock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AccountManager {
    private Account account1 = new Account();
    private Account account2 = new Account();
    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    public void acquireLocks(Lock lock1,Lock lock2) {
        while (true){
            boolean gotFirstLock = false;
             boolean gotSecondLock = false;
        try {
            gotFirstLock = lock1.tryLock();
            gotSecondLock = lock2.tryLock();
        }
        finally {
        if(gotFirstLock && gotSecondLock)
        {
            return ;
        }
        if(gotFirstLock){
           lock1.unlock();

        }
            if(gotSecondLock){
                lock2.unlock();
            }
        }
    }







    }
    /*public void firstThread()
    {

        Random random = new Random();

        for(int i=0;i<10000;i++)
        {
            lock1.lock();
            lock2.lock();
            try{
            Account.transfer(account1,account2,random.nextInt(100));}
            finally {
                lock1.unlock();
                lock2.unlock();

            }
        }


    }
    public void secondThread() {

        Random random = new Random();

        for(int i=0;i<10000;i++)
        {
            lock1.lock();
            lock2.lock();
            try{
                Account.transfer(account2,account1,random.nextInt(100));}
            finally {
                lock1.unlock();
                lock2.unlock();

            }
        }
    }*/
    public void firstThread()
    {

        Random random = new Random();

        for(int i=0;i<10000;i++)
        {
            acquireLocks(lock1,lock2);
            try{
            Account.transfer(account1,account2,random.nextInt(100));}
            finally {
                lock1.unlock();
                lock2.unlock();

            }
        }


    }
    public void secondThread() {

        Random random = new Random();

        for(int i=0;i<10000;i++)
        {
            acquireLocks(lock2,lock1);
            try{
                Account.transfer(account2,account1,random.nextInt(100));}
            finally {
                lock1.unlock();
                lock2.unlock();

            }
        }
    }
    public void finished()
    {
        System.out.println("Account1 Balance  "+account1.getBalance());
        System.out.println("Account2 Balance  "+account2.getBalance());
        System.out.println("Total Balance  "+(account1.getBalance()+account2.getBalance()));
    }
}
