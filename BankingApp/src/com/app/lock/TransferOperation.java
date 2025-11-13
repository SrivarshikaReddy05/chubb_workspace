package com.app.lock;


public class TransferOperation implements Runnable {

    private Account account;
    private String user;
    private int amount;

    public TransferOperation(Account account, String user, int amount) {
        this.account = account;
        this.user = user;
        this.amount = amount;
    }

    @Override
    public void run() {
        account.withdraw(user, amount);
    }
}

