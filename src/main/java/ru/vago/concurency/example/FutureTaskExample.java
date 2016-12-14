package ru.vago.concurency.example;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FutureTaskExample
{
    public static void main(String[] args) throws ExecutionException, InterruptedException
    {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        List<Future<Integer>> tasks = new ArrayList<>();
        tasks.add(executorService.submit(new IncrementFuture(1000)));
        tasks.add(executorService.submit(new IncrementFuture(1000)));
        tasks.add(executorService.submit(new IncrementFuture(1000)));
        tasks.add(executorService.submit(new IncrementFuture(1000)));
        int sum = 0;
        for (Future<Integer> task : tasks)
        {
            sum += task.get();
        }
        System.out.println(sum);
    }

    public static class IncrementFuture implements Callable<Integer>
    {
        private int sleep;

        public IncrementFuture(int sleep)
        {
            this.sleep = sleep;
        }

        @Override
        public Integer call() throws Exception
        {
            System.out.println("run task");
            Thread.sleep(sleep);
            return 1;
        }
    }
}
