
package com.app.order;

import java.util.Queue;

public class OrderProcessor implements Runnable {
    private final Queue<Order> orderQueue;
    private final Inventory inventory;

    public OrderProcessor(Queue<Order> orderQueue, Inventory inventory) {
        this.orderQueue = orderQueue;
        this.inventory = inventory;
    }

    private void processOrder(Order order) {
        System.out.println(Thread.currentThread().getName() + " processing " + order);
        boolean success = inventory.reduceStock(order.getProductName(), order.getQuantity());

        if (success) {
            System.out.println("Order " + order.getOrderId() + " processed successfully!");
        } else {
            System.out.println("Order " + order.getOrderId() + " failed - Not enough stock for " + order.getProductName());
        }
    }

    @Override
    public void run() {
        while (true) {
            Order order = orderQueue.poll();
            if (order != null) {
                processOrder(order);
            } else {
                try {
                    Thread.sleep(100); 
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
    }
}
