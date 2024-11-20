package org.siddhld.ExecutorsFramework;

public class ExecutorExample {
    //** Executors Framework contains three main Interfaces
//    - Executor
//    - ExecutorService
//    - ScheduledExecutorService
}

// Executors Framework introduced in Java 5 to simplify the development of concurrent applications.

////** Benefits of using Executors Framework.
//- No need of manual Thread Management.
//- SCALABILITY becomes easier because Executors Framework managing the Threads.
//- THREAD REUSE becomes efficient because no need to create and Destroy Threads by ourselves.


//** What is Thread Pool
//A Thread Pool is a collection of pre-initialized, reusable threads that can perform tasks as they arrive,
//instead of creating and destroying threads for each task.

//** Benefits:
//        Better resource management
//        Improved performance
//        Reuse of threads
//        Control over maximum threads



//        #### ExecutorService Methods
//
//        | Method                   | What It Does (Simplified)                                                                     |
//        |-------------------------------|--------------------------------------------------------------------------------------------------|
//        | `submit(Callable<T>)`    | Starts a task that can return a result, like solving a math problem.                              |
//        | `submit(Runnable)`       | Starts a task that doesn’t return anything, like printing a message.                              |
//        | `invokeAll(Collection)`  | Runs a bunch of tasks and waits for all of them to finish.                                        |
//        | `invokeAny(Collection)`  | Runs a bunch of tasks but only waits for the first one to finish and returns its result.          |
//        | `shutdown()`             | Tells the executor to stop accepting new tasks but finish running current ones.                   |
//        | `shutdownNow()`          | Tries to stop all tasks right away, even the ones already running.                                |
//        | `isShutdown()`           | Checks if the executor is closed for new tasks.                                                   |
//        | `isTerminated()`         | Checks if all tasks have finished after shutting down.                                            |
//        | `awaitTermination(timeout, TimeUnit)` | Waits for tasks to finish for a specific amount of time.                             |
