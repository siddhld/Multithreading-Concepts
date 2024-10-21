package org.siddhld.Synchronization;

public class Counter {
    private int count = 0;

    public synchronized void increment(){

        count++;

//        synchronized(this) {
//            count++;
//        }
    }

    public int getCounter(){
        return count;
    }
}

// We have used synchronised keyword in increment() method so that only one thread can access at a time.
// If we don't use synchronised then we will see inconsistent count result, because If two Threads access the
// increment() in the same time then there might be a scenario where the increment happens only single time,
// Because both the Thread accessing the increment() method same time and at that time, suppose the "count"
// value will be "100" so both thread will increment one, and the final value becomes "101" instead of "102".
// That's why we see inconsistent result.
