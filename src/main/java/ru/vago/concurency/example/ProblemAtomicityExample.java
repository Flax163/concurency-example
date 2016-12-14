package ru.vago.concurency.example;

import ru.vago.concurency.service.IncrementService;
import ru.vago.concurency.service.IncrementServiceLock;
import ru.vago.concurency.service.IncrementalServiceAtomic;
import ru.vago.concurency.service.IncrementalServiceBad;
import ru.vago.concurency.task.IncrementTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProblemAtomicityExample
{
    public static void main(String[] args)
    {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // проблема атомарности
        //final IncrementService incrementService = new IncrementalServiceBad();

        // пример с атомиками
        //final IncrementService incrementService = new IncrementalServiceAtomic();

        // пример с локом
        final IncrementServiceLock incrementService = new IncrementServiceLock();
        executor.execute(new IncrementTask(incrementService));
        executor.execute(new IncrementTask(incrementService));

        executor.shutdown();
    }
}
