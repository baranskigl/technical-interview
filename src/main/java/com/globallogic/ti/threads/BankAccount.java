package com.globallogic.ti.threads;

public class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    // Synchronized method to ensure thread safety when depositing money
    public void deposit(double amount) {
        balance += amount;
    }

    // Synchronized method to ensure thread safety when withdrawing money
    public boolean withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds for withdrawal of " + amount);
            return false; // withdrawal failed due to insufficient funds
        }
        balance -= amount;
        return true;
    }

    public double getBalance() {
        return balance;
    }
}