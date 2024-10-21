package org.siddhld.Synchronization;

public class MyThread extends Thread{

    public Counter counter;

    MyThread(Counter counter){
        this.counter = counter;
    }

    @Override
    public void run(){
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}
