
package com.app.order;

import java.util.concurrent.ConcurrentHashMap;

public class Inventory {
    private final ConcurrentHashMap<String, Integer> stock = new ConcurrentHashMap<>();

    public void addProduct(String product, int quantity) {
        stock.put(product, stock.getOrDefault(product, 0) + quantity);
    }

    public synchronized boolean reduceStock(String product, int quantity) {
        int available = stock.getOrDefault(product, 0);
        if (available >= quantity) {
            stock.put(product, available - quantity);
            return true;
        }
        return false;
    }

    public void showInventory() {
        System.out.println("Current Inventory: " + stock);
    }
}
