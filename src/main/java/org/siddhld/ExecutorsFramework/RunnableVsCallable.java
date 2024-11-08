package org.siddhld.ExecutorsFramework;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RunnableVsCallable {

    public void runnable_Callable(){
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // This implicitly converts to Callable
        Future<String> future1 = executor.submit(() -> {
            return "someValue";  // Return value makes it a Callable
        });


        // This implicitly converts to Runnable
        Future<?> future2 = executor.submit(() -> {
            System.out.println("value");  // No return value, so it's a Runnable
        });
    }

        public static void main(String[] args) {
            ExecutorService executor = Executors.newFixedThreadPool(2);

            // 1. Runnable (no return value)
            executor.submit(() -> {
                System.out.println("Runnable task");
            });

            // 2. Callable (with return value)
            Future<String> future1 = executor.submit(() -> {
                return "Callable task";  // Returns value, so it's Callable
            });

            // 3. Runnable with explicit result
            Future<String> future2 = executor.submit(
                    () -> System.out.println("Task"),  // Runnable
                    "Result"                           // Explicit result
            );

            // 4. Explicitly using Callable
            Callable<String> callable = () -> "Explicit Callable";
            Future<String> future3 = executor.submit(callable);

            executor.shutdown();
        }
}

// The above examples demonstrate how implicitly submit() internally selects "Runnable" or "Callable".



////** Remember:
//        Return value → Callable
//        No return value → Runnable
//        Both can be passed to submit()
//        Callable gives you Future<T>
//        Runnable gives you Future<?>

//- Use Future<T> when you know the exact return type
//- Use Future<?> when:
    // Using Runnable (no return value)
    // Don't care about return type
    // Type is unknown