package ru.vago.concurency.service;

import java.util.concurrent.atomic.AtomicInteger;

public class IncrementalServiceAtomic implements IncrementService
{
    private AtomicInteger atomicInteger = new AtomicInteger();

    public void increment()
    {
        atomicInteger.addAndGet(1);
    }

    public int getNumber()
    {
        return atomicInteger.get();
    }
}
