package com.java.multithread.notes13.future;

import java.util.concurrent.*;

public class FutureApp {

    public static void main(String args[])
    {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Integer> future = executorService.submit(new Callable<Integer>() {

            public Integer call() throws Exception {
                return 20;
            }
        });

        try {
            executorService.shutdown();
            System.out.println("future Value:::"+future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
