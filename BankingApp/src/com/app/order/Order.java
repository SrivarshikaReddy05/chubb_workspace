
package com.app.order;

import java.util.UUID;

public class Order {
    private String orderId;
    private String productName;
    private int quantity;
    private double amount;

    public Order(String productName, int quantity, double amount) {
        this.orderId = UUID.randomUUID().toString();
        this.productName = productName;
        this.quantity = quantity;
        this.amount = amount;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", amount=" + amount +
                '}';
    }
}
