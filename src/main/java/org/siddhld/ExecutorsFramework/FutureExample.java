package org.siddhld.ExecutorsFramework;

import java.util.concurrent.*;

public class FutureExample {
    public static void Example() throws ExecutionException, InterruptedException {
        ExecutorService ec = Executors.newSingleThreadExecutor();

        Future<Integer> future = ec.submit(() -> {
            int sum = 0;
            for (int i = 0; i < 5; i++) {
                System.out.println("Waiting...");
                Thread.sleep(500);
                sum += i;
            }
            return sum;
        });// return 10

        System.out.println(future.get()); // It will wait until the computation completes, and then retrieves its result.

        if(future.isDone()) System.out.println("Task Completed");

        ec.shutdown();
    }

    public static void main(String[] args) {
        try {
            FutureExample.Example();
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

////** Future:
//        Future represents the result of an asynchronous computation. When you submit a task to an ExecutorService,
//        it immediately returns a Future<> object, which acts as a placeholder for the result of the computation that will complete in the future.

////** How does it work?
//// Task Submission:
//        When a task is submitted to an ExecutorService (e.g., a thread pool), the Future<> object is returned immediately, even though the task may not have completed yet.
//// Task Processing:
//        The task runs in a separate thread.
//// Result Retrieval:
//        You can use the Future<> object to:
//        Check if the task is complete.
//        Wait for the task to complete.
//        Retrieve the result of the task.
//        Cancel the task if needed.



//### Commonly Used Methods of `Future<>` (Simplified)

//        #### Future Methods
//
//        | Method                   | What It Does (Simplified)                                                                    |
//        |------------------------------|--------------------------------------------------------------------------------------------------|
//        | `get()`                      | Waits for the task to finish and gives you the result when it's ready.                           |
//        | `get(timeout, TimeUnit)`     | Waits for the task to finish for a limited time. If it takes too long, it throws an error.       |
//        | `isDone()`                   | Checks if the task is finished.                                                                  |
//        | `isCancelled()`              | Checks if the task was stopped before it finished.                                               |
//        | `cancel(boolean mayInterruptIfRunning)` | Tries to stop the task. If `true`, it will interrupt the task if it’s still running.      |

