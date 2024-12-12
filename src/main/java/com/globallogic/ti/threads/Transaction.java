package com.globallogic.ti.threads;

public class Transaction implements Runnable {
    private BankAccount account;
    private double amount;
    private boolean isDeposit;

    public Transaction(BankAccount account, double amount, boolean isDeposit) {
        this.account = account;
        this.amount = amount;
        this.isDeposit = isDeposit;
    }

    @Override
    public void run() {
        if (isDeposit) {
            account.deposit(amount);
            System.out.println(Thread.currentThread().getName() + " deposited " + amount);
        } else {
            if (account.withdraw(amount)) {
                System.out.println(Thread.currentThread().getName() + " withdrew " + amount);
            }
        }
    }
}