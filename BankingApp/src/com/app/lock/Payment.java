package com.app.lock;

public class Payment {
    private boolean isPaid;

    public synchronized void pay(String user) {
        System.out.println(user + " is processing payment...");
        try {
            Thread.sleep(100); // simulate payment delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        isPaid = true;
        System.out.println(user + " completed payment successfully.");
    }
}
