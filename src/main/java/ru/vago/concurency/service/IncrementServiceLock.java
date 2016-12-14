package ru.vago.concurency.service;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class IncrementServiceLock implements IncrementService
{
    private static volatile int number;
    private final Lock lock = new ReentrantLock();

    public void increment()
    {
        lock.lock();
        try {
            number++;
        }
        finally {
            lock.unlock();
        }
    }

    public int getNumber()
    {
        return number;
    }
}
