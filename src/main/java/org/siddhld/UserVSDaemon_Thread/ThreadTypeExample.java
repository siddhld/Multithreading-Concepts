package org.siddhld.UserVSDaemon_Thread;

public class ThreadTypeExample {

    public static void main(String[] args) {
        Thread userThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("User Thread: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread daemonThread = new Thread(() -> {
            while (true) { // Running Infinite
                System.out.println("Daemon Thread is running");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        daemonThread.setDaemon(true); // Set as daemon thread

        userThread.start();
        daemonThread.start();

        System.out.println("Main thread is finishing");

//       In the Output you will see that when the User Thread Execution completed then the Daemon Thread
//       Execution is also completed Even the Daemon Thread is using Infinite While Loop.

    }
}

////// User Thread Vs Daemon Thread

// Daemon Thread are Background thread, that runs in background like GC (Garbage Collector), Main Thread
// JVM doesn't wait for Daemon Thread, means it will terminate the execution when the User Thread execution is completed.
// It is used for performing Background task.
// It has LOW Priority


// User Thread are default Thread, It means JVM will wait for User Thread to complete its Execution
// It is used to execute the main logic of you application.
// It has HIGH Priority