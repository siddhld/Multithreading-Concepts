package org.siddhld.WaitANDNotify;

class PizzaShop {
    private boolean pizzaReady = false;
    private String pizza;

    public synchronized String servePizza() {  // Only one thread can enter at a time
        while (!pizzaReady) {
            try {
                System.out.println(Thread.currentThread().getName() +
                        ": Waiting for pizza");
                wait();  // Release lock and wait
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // Only one thread can execute this at a time
        pizzaReady = false;
        System.out.println(Thread.currentThread().getName()+": Taking pizza");
        return "Served " + pizza;
    }

    public synchronized void bakePizza(String type) {
        pizza = type;
        pizzaReady = true;
        notifyAll();  // Notify all waiting threads
    }
}

public class WaitNotifyExample {
    public static void main(String[] args) {
        PizzaShop shop = new PizzaShop();

        // Create multiple waiter threads
        Thread waiter1 = new Thread(() -> {
            String result = shop.servePizza();
            System.out.println("Waiter 1: " + result);
        }, "Waiter-1");

        Thread waiter2 = new Thread(() -> {
            String result = shop.servePizza();  // or servePizzaGood()
            System.out.println("Waiter 2: " + result);
        }, "Waiter-2");

        // Start waiters
        waiter1.start();
        waiter2.start();

        // Sleep briefly to let waiters start waiting
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Chef makes one pizza
        new Thread(() -> {
            shop.bakePizza("Pepperoni");
        }, "Chef").start();
    }
}

// VISUAL FLOW
//    Initial State:
//        Waiter-1: Waiting (released lock)
//        Waiter-2: Waiting (released lock)
//
//        After notifyAll():
//        1. All waiters wake up
//        2. They compete for lock (because method is synchronized) means whichever thread accessed servePizza() method first will access it after waking up first and so on.
//
//        First Winner (let's say Waiter-1):
//        - Gets lock
//        - Sees pizzaReady = true
//        - Takes pizza
//        - Sets pizzaReady = false
//        - Exits method
//        - Releases lock
//
//        Second Entry (let's say Waiter-2):
//        - Gets lock
//        - Sees pizzaReady = false (because Waiter-1 changed it)
//        - Goes back to waiting
//        - Releases lock


////    THE KEY POINTS ARE:
//   synchronized means only one thread can execute the method at a time
//   notifyAll() wakes up all waiting threads
//   Woken threads must compete for the lock
//   Only one thread can have the lock at any time