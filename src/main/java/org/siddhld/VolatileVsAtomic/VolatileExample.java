package org.siddhld.VolatileVsAtomic;

class Worker implements Runnable{
    private volatile boolean running = true; // Volatile ensures visibility.
    public void run(){
        while (running){
            System.out.println("Working...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Worker thread interrupted.");
            }
        }
        System.out.println("Stopped");
    }

    public void stop(){
        running = false; // This will be immediately visible to other threads.
    }
}

public class VolatileExample {
    public static void main(String[] args) throws InterruptedException {
        Worker worker = new Worker();
        Thread t = new Thread(worker);
        t.start();

        Thread.sleep(5000); // Let the worker thread run for a while
        worker.stop();     // Signal the worker thread to stop
    }
}

//    Volatile is a keyword in Java used to ensure that any change made to that variable are immediately visible to all threads.
//-   Whenever a thread reads a volatile variable, it fetches the latest value from main memory.


//    NOTE:
//    It cannot prevent multiple threads from interfering with each other during these steps, leading to race conditions.
//    It ensures that the variable is not cached locally in threads but is always fetched from the main memory, so other threads can see the updated value right away.

////**    When to Use volatile?
//        Use volatile for simple read/write operations where:
//        Multiple threads access a shared variable.
//        When You don't need to perform compound operations (like x++ or x = x + 1).
//        When You want to ensure that every thread sees the latest value of the variable.
