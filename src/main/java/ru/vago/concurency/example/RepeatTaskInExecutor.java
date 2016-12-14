package ru.vago.concurency.example;

import ru.vago.concurency.task.IncrementTask;
import ru.vago.concurency.task.PrintTextWithSleepTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class RepeatTaskInExecutor
{
    public static void main(String[] args)
    {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);

        executorService.scheduleWithFixedDelay(new PrintTextWithSleepTask("task1"), 2, 2, TimeUnit.SECONDS);
        executorService.scheduleWithFixedDelay(new PrintTextWithSleepTask("task2"), 2, 2, TimeUnit.SECONDS);

        //executorService.shutdown();
    }
}
