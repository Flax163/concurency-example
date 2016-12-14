package ru.vago.concurency.task;

public class PrintTextWithSleepTask implements Runnable
{
    private final String text;

    public PrintTextWithSleepTask(final String text)
    {
        this.text = text;
    }

    public void run()
    {
        try
        {
            Thread.sleep(2000);
            System.out.println(text);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
