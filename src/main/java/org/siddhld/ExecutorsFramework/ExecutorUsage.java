package org.siddhld.ExecutorsFramework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorUsage {

    public int factorial(int num) {
        int fact = 1;

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
            Thread.currentThread().interrupt();
        }

        for (int i = 1; i <= num; i++) {
            fact *= i;
        }
        return fact;
    }

    public static void main(String[] args) {
        ExecutorUsage eu = new ExecutorUsage();

        ExecutorService ec = Executors.newFixedThreadPool(10);


        long startTime = System.currentTimeMillis();
        System.out.println(startTime); // Time from "1 Jan 1970" to Now in Millisecond

        for (int i = 1; i <= 5; i++) {
            int finalI = i;
            ec.submit(() -> {
                int result = eu.factorial(finalI);
                System.out.println(result);
                return result;
            });
        }

        ec.shutdown(); // It Stops accepting new tasks, Allows previously submitted tasks to complete, After All tasks completes then executor terminated.

        try {
//            ec.awaitTermination(10, TimeUnit.SECONDS);
            while(!ec.awaitTermination(100, TimeUnit.MILLISECONDS)){ // If All Tasks are completed within "100" millisecond then it will return True.
                // Wait till all Task's executions are completed.
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Time Taken: " + (System.currentTimeMillis() - startTime));
    }
}

/*
What Executors Does:
The Executors class provides several static factory methods that return different types of ExecutorService implementations. These methods abstract away the details of thread pool creation and configuration.

Here are the most commonly used factory methods:

newFixedThreadPool(int nThreads): Creates a thread pool with a fixed number of threads. If all threads are busy, new tasks are queued until a thread becomes available.   
Use case: Suitable for applications where you need to limit the number of concurrent tasks to a known value, preventing resource exhaustion.   

newCachedThreadPool(): Creates a thread pool that creates new threads as needed, but reuses previously created threads when they become available. Threads that have been idle for a certain period are terminated.   
Use case: Suitable for applications with many short-lived tasks. It avoids the overhead of creating new threads for each task while still limiting the number of active threads.   

newSingleThreadExecutor(): Creates a thread pool with only one thread. Tasks are executed sequentially in the order they are submitted.   
Use case: Suitable for tasks that need to be executed sequentially or when you want to ensure that only one task is running at any given time.   
 
newScheduledThreadPool(int corePoolSize): Creates a thread pool that can schedule tasks to run after a delay or periodically.   
Use case: Suitable for scheduling tasks like timers, periodic updates, or delayed execution.   
*/
