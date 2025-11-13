package com.app.lock;


public class Hotel {
    public static void main(String[] args) {
        Rooms sharedRoom = new Rooms("101");
        Payment sharedPayment = new Payment();

        System.out.println("---- Deadlock Simulation ----");
        Thread user1 = new Thread(new Book(sharedRoom, sharedPayment, "User-1", true));
        Thread user2 = new Thread(new Book(sharedRoom, sharedPayment, "User-2", true));

        user1.start();
        user2.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n---- Deadlock-Free Simulation ----");
        Thread user3 = new Thread(new Book(sharedRoom, sharedPayment, "User-3", false));
        Thread user4 = new Thread(new Book(sharedRoom, sharedPayment, "User-4", false));

        user3.start();
        user4.start();
    }
}
