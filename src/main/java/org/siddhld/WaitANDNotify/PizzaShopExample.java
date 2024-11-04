package org.siddhld.WaitANDNotify;

public class PizzaShopExample {

    private boolean pizzaReady = false;
    private String pizza;

    // Chef's method to prepare pizza
    public synchronized void preparePizza(String pizzaType) {
        System.out.println("Chef: Started making " + pizzaType + " pizza");

        try {
            Thread.sleep(2000); // Time to prepare pizza
            this.pizza = pizzaType;
            this.pizzaReady = true;

            System.out.println("Chef: Pizza is ready!");
            notify(); // Notify waiter that pizza is ready

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Waiter's method to serve pizza
    public synchronized String servePizza(){
        System.out.println("Waiter: Checking if pizza is ready");

        if (!pizzaReady) {
            try {
                System.out.println("Waiter: Pizza not ready, waiting...");
                wait(); // Wait for chef to prepare pizza
                System.out.println("Waiter: Notified that pizza is ready!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        pizzaReady = false;
        return pizza;
    }


    public static void main(String[] args) {

        PizzaShopExample pz = new PizzaShopExample();

        // Waiter Thread
        Thread waiter = new Thread(() -> {
            String pizza = pz.servePizza();
            System.out.println("Waiter: Served " + pizza + " pizza");
        }, "Waiter");

        // Chef Thread
        Thread chef = new Thread(() -> {
            pz.preparePizza("Pepperoni");
        }, "Chef");

        // Start threads
        waiter.start();
        chef.start();
    }
}
