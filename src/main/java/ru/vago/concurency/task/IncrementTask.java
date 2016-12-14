package ru.vago.concurency.task;

import ru.vago.concurency.service.IncrementService;

public class IncrementTask implements Runnable
{
    private final IncrementService incrementService;

    public IncrementTask(IncrementService incrementService)
    {
        this.incrementService = incrementService;
    }


    @Override
    public void run()
    {
        for (int i = 0; i < 100000000; i++)
        {
            incrementService.increment();
        }
        System.out.println(incrementService.getNumber());
    }
}
