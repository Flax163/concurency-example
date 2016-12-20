package ru.vago.concurency.example;

public class DeadlockExample
{
    public static void main(String[] args)
    {
        ThreadForDeadlock thread1 = new ThreadForDeadlock();
        ThreadForDeadlock thread2 = new ThreadForDeadlock();
        thread1.beforeThread = thread2;
        thread2.beforeThread = thread1;
        thread1.start();
        thread2.start();
    }

    public static class ThreadForDeadlock extends Thread
    {
        public Thread beforeThread;

        @Override
        public void run()
        {
            try
            {
                System.out.println("Start Thread");
                this.beforeThread.join(10000);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            finally
            {
                System.out.println("End Thread");
            }
        }
    }
}
