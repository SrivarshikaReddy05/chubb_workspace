
package com.app.order;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Queue<Order> orderQueue = new ConcurrentLinkedQueue<>();
        Inventory inventory = new Inventory();

       
        inventory.addProduct("Laptop", 20);
        inventory.addProduct("Phone", 30);
        inventory.addProduct("Headphones", 15);

       
        for (int i = 0; i < 30; i++) {
            String product = switch (i % 3) {
                case 0 -> "Laptop";
                case 1 -> "Phone";
                default -> "Headphones";
            };
            orderQueue.add(new Order(product, (i % 5) + 1, 1000.0 + i * 10));
        }

     
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executor.submit(new OrderProcessor(orderQueue, inventory));
        }

        
        Thread.sleep(5000);
        executor.shutdownNow();

        inventory.showInventory();
    }
}
