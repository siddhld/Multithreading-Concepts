package org.siddhld.Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Bank {
    private int balance = 100;

    Lock lock = new ReentrantLock();

    public void withdraw(int amount) {

        lock.lock();
        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                if (amount <= balance) {
                    System.out.println(Thread.currentThread().getName() + " Successfully withdraw " + amount);
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } finally {
                        lock.unlock();
                    }
                    balance -= amount;
                    System.out.println(Thread.currentThread().getName() + " Available balance " + balance);
                } else {
                    System.out.println(Thread.currentThread().getName() + " Failed to withdraw " + amount);
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " Failed to withdraw, Another thread is using the Resource" + amount);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
        System.out.println(Thread.currentThread().getName());
    }

}

public class ExplicitLock {
    public static void main(String[] args) {
        Bank sbi = new Bank();

        // This creates an anonymous inner class that implements the Runnable interface.
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                sbi.withdraw(50);
            }
        };

        Thread t1 = new Thread(runnable, "kamlu");
        Thread t2 = new Thread(runnable, "faizu");

        t1.start();
        t2.start();
    }
}

// tryLock() -> It means "Turant check kro agar lock nai hai to "true" return kro warna "false"".
// tryLock(1000, TimeUnit.MILLISECOND) -> It means "Try kro diye gye samay tak fir niklo".
// lock() -> It means "Try karte raho jab tak lock free(Unlock) na ho jaye".
// unlock() -> It means "Yeh "unlock" kar deta hai taki dusra thread uss resource ko use kar paye".