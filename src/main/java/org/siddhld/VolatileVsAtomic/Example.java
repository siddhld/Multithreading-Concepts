package org.siddhld.VolatileVsAtomic;

public class Example {
    public static void main(String[] args) {
        // For Simple Read/Write operation use Volatile (eg. flag).
        // For Read/Modify/Write operation use Atomic class (eg, counter)
    }
////** THREAD SAFE (It means multiple threads can use single variable without causing inconsistency)
//    Both volatile and atomic classes (e.g., AtomicInteger) are used to make variables thread-safe,
//    but they achieve this in different ways and are suitable for different use cases.
}


//**      Comparison: volatile vs. Atomic
//        Features	    |volatile	                    |Atomic Classes (AtomicInteger, AtomicReference, etc.)
//        Visibility	|Yes	                        |Yes
//        Atomicity	    |No	                            |Yes
//        Use Case	    |Simple read/write operations   |Complex operations like counters or conditional updates
//        Performance	|Very lightweight	            |Slightly heavier due to atomic guarantees
//        Example	    |Flags, status variables	    |Counters, accumulators, shared resources