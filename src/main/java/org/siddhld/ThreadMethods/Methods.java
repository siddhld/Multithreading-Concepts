package org.siddhld.ThreadMethods;

public class Methods extends Thread {
    Methods(){}
    Methods(String name){
        super(name); // Setting Thread name by assigning using Super
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                System.out.println(Thread.currentThread().getName() + " Counter: "+i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread th1 = new Methods("Low-Priority");
        Thread th2 = new Methods("Norm-Priority");
        Thread th3 = new Methods("High-Priority");

        th1.setPriority(Thread.MIN_PRIORITY);
        th2.setPriority(Thread.NORM_PRIORITY);
        th3.setPriority(Thread.MAX_PRIORITY);

        th1.start();
        th2.start();
        th3.start();
    }
}

//// Methods

/// run() -> We write the code inside run() method that we want to execute concurrently.
/// start() -> To start a Thread.
/// Sleep(1000) -> To Pause the execution of the Thread for a given time.
/// join() -> Main Thread will wait until, th.join() thread execution completes.
/// setName() -> Used to set Thread name.
/// setPriority() -> Set Priority of the Thread. (The Priority will be decided based on the code complexity, cores etc)
/// getPriority() -> To get the Priority of the Thread.
/// th1.interrupt() -> It is used to stop a thread. When it's in a blocked state (e.g., waiting, sleeping).
/// Thread.yeild() -> It gives chance to other thread.
/// th1.setDaemon(true); -> It is used to make a User Thread into Daemon Thread.



