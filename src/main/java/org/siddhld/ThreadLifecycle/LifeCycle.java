package org.siddhld.ThreadLifecycle;

public class LifeCycle extends Thread {

    public void demonstration() throws InterruptedException{

//     There are FIVE states in Thread LifeCycle

////       NEW -> In this state a new Thread is Created but not yet Started.

////       RUNNABLE -> After the start() method called, the thread becomes runnable
////                   means it is ready to run and waiting for CPU time.

////       RUNNING -> The thread is now in Running state means it is executing.

////       BLOCKED/WAITING -> In this state a Thread is waiting for a resource or
//                             waiting for another thread to perform action.

////       TERMINATED -> In this state the Thread's execution is finished.



        //// PRACTICAL EXAMPLE

        // NEW State
        Thread th = new Thread(() -> System.out.println("Hello"));

        // RUNNABLE state
        th.start(); // Waiting for CPU time

        // RUNNING state
        System.out.println("Hello"); // After getting CPU time it starts the execution.

        // BLOCKED/WAITING state
        th.wait();
        Thread.sleep(100);

        // TERMINATED state
        // Finished execution

    }

    @Override
    public void run(){
        System.out.println("RUNNING");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException{

        // First GO through the demonstration()

        // Realtime Example
        Thread th = new LifeCycle();
        System.out.println(th.getState());

        th.start();
        System.out.println(th.getState());

        Thread.sleep(100);
        System.out.println(th.getState());

        th.join(); // Main Thread will wait until, th thread execution completes
        System.out.println(th.getState());
    }
}