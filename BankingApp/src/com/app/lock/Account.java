package com.app.lock;

public class Account {
    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public synchronized void withdraw(String user, int amount) {
        System.out.println(user + " trying to withdraw " + amount);

        if (balance >= amount) {
            System.out.println(user + " proceeding with withdrawal...");
            try {
                Thread.sleep(100); // simulate processing time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            balance -= amount;
            System.out.println(user + " completed withdrawal.\n Remaining balance: " + balance);
        } else {
            System.out.println(user + " — Insufficient funds.\n Balance: " + balance);
        }
    }
}
