package org.siddhld.Lock;

public class LockExample {
    public static void main(String[] args) {
    }
}

// Race Condition -> When multiple threads are accessing a single Resource is known as Race Condition.
// Synchronized -> We use it so that only a single thread can access a resource at a Time. Internally it uses "lock"
//                 and it "lock" the thread so that only that thread can access it and after the execution complete it
//                 "unlock" the thread.

// ** Using "Synchronized" the "lock" and "Unlock" happens automatically.
// ** We can also use "lock" and "Unlock" Explicitly using Lock interface form "java.util.concurrent.locks.Lock" package.


// ReentrantLock class is used for managing thread synchronization in Java. It provides flexibility and control
// compared to the built-in synchronized keyword.
//// It provides methods like tryLock() and lockInterruptibly() that allow for more flexible locking strategies.
