package org.siddhld.Synchronization;

public class SynchronizationExample {
    public static void main(String[] args) {
        Counter counter = new Counter();

        MyThread t1 = new MyThread(counter);
        MyThread t2 = new MyThread(counter);

        t1.setDaemon(true);
        t2.setDaemon(true);

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(counter.getCounter());
    }
}

//// Two ways to use Synchronized:
// Synchronized Keyword -> Used in Methods
// Synchronized Block   -> Used in specific code inside method.

//// Go through "Counter" class for better understanding.