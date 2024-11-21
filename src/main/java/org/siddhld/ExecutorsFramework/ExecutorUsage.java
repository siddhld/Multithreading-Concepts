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

