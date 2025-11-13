package com.app.lock;

public class Book implements Runnable {

    private Rooms room;
    private Payment payment;
    private String user;
    private boolean simulateDeadlock;

    public Book(Rooms room, Payment payment, String user, boolean simulateDeadlock) {
        this.room = room;
        this.payment = payment;
        this.user = user;
        this.simulateDeadlock = simulateDeadlock;
    }

    @Override
    public void run() {
        if (simulateDeadlock) {
            // ❌ Deadlock Scenario: inconsistent lock order
            synchronized (room) {
                System.out.println(user + " locked Room first");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (payment) {
                    System.out.println(user + " locked Payment and is booking...");
                    room.book(user);
                    payment.pay(user);
                }
            }
        } else {
            // ✅ Deadlock-free: consistent lock order (Payment → Room)
            synchronized (payment) {
                System.out.println(user + " locked Payment first");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (room) {
                    System.out.println(user + " locked Room and is booking...");
                    room.book(user);
                    payment.pay(user);
                }
            }
        }
    }
}
