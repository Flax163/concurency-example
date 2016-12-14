package ru.vago.concurency.service;

public class IncrementalServiceBad implements IncrementService
{
    private static volatile int number;

    public void increment()
    {
        number++;
    }

    public int getNumber()
    {
        return number;
    }
}
