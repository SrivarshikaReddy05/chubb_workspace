package com.app.lock;

class Acnt {
    private int balance;

    public Acnt(int balance) {
        this.balance = balance;
    }

    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            System.out.println(Thread.currentThread().getName() + " is withdrawing " + amount);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {}
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " completed withdrawal. Remaining balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " tried to withdraw " + amount + " but insufficient balance.");
        }
    }

    public int getBalance() {
        return balance;
    }
}

class FundTransferTask implements Runnable {
    private final Acnt account;
    private final int amount;

    public FundTransferTask(Acnt account, int amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        account.withdraw(amount);
    }
}

public class FundTransfer {
    public static void main(String[] args) throws InterruptedException {
        Acnt acc = new Acnt(1000);

        Thread t1 = new Thread(new FundTransferTask(acc, 700), "User-1");
        Thread t2 = new Thread(new FundTransferTask(acc, 700), "User-2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final balance: " + acc.getBalance());
    }
}
