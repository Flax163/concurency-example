package ru.vago.concurency.example;

import ru.vago.concurency.task.PrintTextWithSleepTask;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class SingleExecutorExample
{
    public static void main(String[] args)
    {
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(new PrintTextWithSleepTask("Task 1"));
        executor.execute(new PrintTextWithSleepTask("Task 2"));
        executor.execute(new PrintTextWithSleepTask("Task 3"));
    }
}
