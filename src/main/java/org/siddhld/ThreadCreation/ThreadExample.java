package org.siddhld.ThreadCreation;

//Creating Thread by extending Thread class
class Traffic extends Thread{

    int counter = 0;

    @Override
    public void run(){
        for (int i = 0; i < 10000; i++) {
            System.out.println("Counter 1: " + counter++ + " " + Thread.currentThread().getName());
        }
    }

}


// Creating Thread by extending Runnable interface
class Train implements Runnable{

    int counter = 0;

    @Override
    public void run(){
        for (int i = 0; i < 10000; i++) {
            System.out.println("counter 2: " + counter++ + " " + Thread.currentThread().getName());
        }
    }

}

public class ThreadExample {
    public static void main(String[] args) {
        // Thread0 is assigned to do the below work
        // Using Thread class
        Thread th = new Traffic();
        th.start();

        // Thread1 is assigned to do the below work
        // Using Runnable class
        Thread th2 = new Thread(new Train());
        th2.start();


        // Main Thread is assigned to do the below work
        for (int i = 0; i < 10000; i++) {
            System.out.println(Thread.currentThread().getName());
        }

    }
}