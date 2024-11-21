package org.siddhld.VolatileVsAtomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExample {
    private AtomicInteger count = new AtomicInteger();
    public void increment() {
////**        What Happens Here:
//        incrementAndGet() ensures the operation is completed as a single step.
//        Thread 1 increments from 1 to 2 before Thread 2 starts.
//        No race conditions!
        count.incrementAndGet(); // ATOMIC OPERATION
    }

    public int getCount() {
        return count.get();
    }

    public static void main(String[] args) {
        AtomicExample ae = new AtomicExample();

        ExecutorService ec = Executors.newFixedThreadPool(10);

        for(int i = 1; i<=10; i++){
            ec.submit(() -> {
                ae.increment();
            });
        }
        System.out.println(ae.getCount());
    }
}


//  Atomicity means that a task is treated as a single, indivisible unit of work. If a task is atomic,
//  it either completes fully or doesn't happen at all, and no other thread can see the task in an incomplete state.
//
//  Think of it as a "do it all at once" rule.



//-**        Key Points:

////**        Atomicity Guarantees:
//        No interruptions while performing the operation.
//        All changes are applied completely or not at all.
//        Other threads can't see intermediate states.

////**        Where It Is Useful:
//        Incrementing counters (count++).
//        Updating shared variables.
//        Performing database transactions.

////**        How to Achieve Atomicity:
//        Use classes like AtomicInteger, AtomicBoolean, or AtomicReference.
//        Use synchronized blocks or locks.