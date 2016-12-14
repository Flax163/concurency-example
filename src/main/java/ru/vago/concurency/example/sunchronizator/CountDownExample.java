package ru.vago.concurency.example.sunchronizator;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownExample
{
    public static final CountDownLatch COUNT_DOWN_LATCH = new CountDownLatch(4);
    public static volatile String firstHorse;

    public static void main(String[] args) throws InterruptedException
    {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(new Horse(COUNT_DOWN_LATCH, "Horse 1", 2000));
        executorService.submit(new Horse(COUNT_DOWN_LATCH, "Horse 2", 2000));
        executorService.submit(new Horse(COUNT_DOWN_LATCH, "Horse 3", 4000));
        COUNT_DOWN_LATCH.await();
        System.out.println(String.format("Все лощади прибежали №1 %s", firstHorse));
        executorService.shutdown();
    }

    public static class Horse implements Runnable
    {
        private final CountDownLatch countDownLatch;
        private final String nameHorse;
        private final int sleep;

        public Horse(CountDownLatch countDownLatch, String nameHorse, int sleep)
        {
            this.countDownLatch = countDownLatch;
            this.nameHorse = nameHorse;
            this.sleep = sleep;
        }

        @Override
        public void run()
        {
            try
            {
                countDownLatch.countDown();
                while (countDownLatch.getCount() < 1)
                {
                    Thread.sleep(200);
                }
                System.out.println(String.format("Лошадь %s побежала: ", nameHorse));
                Thread.sleep(sleep);
                if (firstHorse == null)
                {
                    firstHorse = nameHorse;
                    countDownLatch.countDown();
                }
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
