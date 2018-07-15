package com.java.multithread.notes11.deadlock;

public class Account {
    private int balance=10000;

    public void deposit(int amount)
    {
        balance += amount;
    }
    public void withDraw(int amount)
    {
        balance -= amount;
    }
    public int getBalance()
    {
        return balance;
    }
    public static void transfer(Account account1,Account account2,int amount)
    {
        if((account1.getBalance()-amount>=0)) {//transfer only if enough balance is there
        account1.withDraw(amount);
        account2.deposit(amount);
    }
    }
}
