package org.siddhld.WaitANDNotify;

public class Example {
}

//// wait():
//        - Must be called from synchronized context
//        - Releases the lock
//        - Thread goes into waiting state
//        - Waits until notify()/notifyAll() is called
//        - After waking up, must re-acquire lock before continuing

//// notify():
//        - Must be called from synchronized context
//        - Wakes up only one waiting thread (randomly chosen)
//        - Does not release lock immediately
//        - Lock is released when synchronized block/method ends
//        - If no threads are waiting, notify() has no effect

//// notifyAll():
//        - Must be called from synchronized context
//        - Wakes up all waiting threads
//        - Threads compete for lock when available
//        - Only one thread can proceed at a time
//        - If no threads are waiting, notifyAll() has no effect


//////    REMEMBER:
//    Always use these methods in synchronized context
//    Always use wait() in a while loop
//    Check if notification is needed before calling notify/notifyAll
//    Handle InterruptedException properly
//    Release locks in finally blocks when using explicit locks