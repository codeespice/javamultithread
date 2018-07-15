package com.java.multithread.notes7.producerandconsumer;

public class ProducerAndConsumer {
    public static void main(String args[])
    {
       final Merchandise merchandise = new Merchandise();
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                merchandise.produce();

            }
        });
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                merchandise.consume();

            }
        });
        t1.start();
        t2.start();


        try {
            t2.join();
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
