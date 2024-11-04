package org.siddhld.WaitANDNotify;

class PizzaShop {
    private boolean pizzaReady = false;
    private String pizza;

    // BAD Implementation (with if)
    public synchronized String servePizzaBad() {
        if (!pizzaReady) {  // Using if - problematic!
            try {
                System.out.println(Thread.currentThread().getName() +
                        ": Waiting for pizza");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        pizzaReady = false;
        return "Served " + pizza;
    }

    // GOOD Implementation (with while)
    public synchronized String servePizzaGood() {
        while (!pizzaReady) {  // Using while - safe!
            try {
                System.out.println(Thread.currentThread().getName() +
                        ": Waiting for pizza");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        pizzaReady = false;
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
            String result = shop.servePizzaGood();  // or servePizzaGood()
//            String result = shop.servePizzaBad();  // or servePizzaGood()
            System.out.println("Waiter 1: " + result);
        }, "Waiter-1");

        Thread waiter2 = new Thread(() -> {
            String result = shop.servePizzaGood();  // or servePizzaGood()
//            String result = shop.servePizzaBad();  // or servePizzaGood()
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