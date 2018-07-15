package notes14.interrupt;

import java.util.Random;
import java.util.concurrent.*;

public class InterruptApp {
    public static void main(String[] args)
    {
        System.out.println("Starting...");
        ExecutorService executorService = Executors.newCachedThreadPool();
       Future fu = executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                Random random = new Random();
                for(int i=0;i<1E8;i++)
                {
                    if(Thread.currentThread().isInterrupted())
                    {
                        System.out.println("Gracefully Terminated");
                        break;
                    }
                    Math.sin(random.nextDouble());
                }
                return null;
            }
        });
        executorService.shutdown();
        fu.cancel(true);//force interrupt
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            executorService.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Ending...");
    }
}
