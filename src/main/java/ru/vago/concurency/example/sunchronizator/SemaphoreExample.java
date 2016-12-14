package ru.vago.concurency.example.sunchronizator;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreExample
{
    private static Semaphore SEMAPHORE = new Semaphore(3);

    public static void main(String[] args)
    {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(new Worker(SEMAPHORE, "worker 1", 2000));
        executorService.submit(new Worker(SEMAPHORE, "worker 2", 10000));
        executorService.submit(new Worker(SEMAPHORE, "worker 3", 2000));
        executorService.submit(new Worker(SEMAPHORE, "worker 4", 2000));
        executorService.submit(new Worker(SEMAPHORE, "worker 5", 2000));
        executorService.submit(new Worker(SEMAPHORE, "worker 6", 2000));
        executorService.submit(new Worker(SEMAPHORE, "worker 7", 2000));
        executorService.submit(new Worker(SEMAPHORE, "worker 8", 2000));
        executorService.submit(new Worker(SEMAPHORE, "worker 9", 2000));
        executorService.submit(new Worker(SEMAPHORE, "worker 10", 2000));
        executorService.shutdown();
    }

    private static class Worker implements Runnable
    {
        private final Semaphore semaphore;
        private final String nameWorker;
        private final int timeout;

        public Worker(Semaphore semaphore, String nameWorker, int timeout)
        {
            this.semaphore = semaphore;
            this.nameWorker = nameWorker;
            this.timeout = timeout;
        }

        @Override
        public void run()
        {
            try
            {
                semaphore.acquire();
                System.out.println(String.format("Worker %s : start work", nameWorker));
                Thread.sleep(timeout);
                System.out.println(String.format("Worker %s : recreation", nameWorker));

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        }
    }
}
