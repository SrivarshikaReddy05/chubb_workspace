package com.app.lock;

public class Bank {

    public static void main(String[] args) {
        Account sharedAccount = new Account(10000000);

        // Two users trying to withdraw at the same time
        Thread user1 = new Thread(new TransferOperation(sharedAccount, "User-A", 70000));
        Thread user2 = new Thread(new TransferOperation(sharedAccount, "User-B", 70000));

        user1.start();
        user2.start();
    }
}
