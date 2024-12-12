package com.globallogic.ti.threads;
import java.util.concurrent.*;

public class Bank {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.0); // Initial balance of $1000
        ExecutorService executor = Executors.newFixedThreadPool(10); // Thread pool of 10 threads

        // Create and execute transactions (both deposits and withdrawals)
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                executor.submit(new Transaction(account, 100, true));  // Deposit 100
            } else {
                executor.submit(new Transaction(account, 50, false));  // Withdraw 50
            }
        }

        // Shut down the executor service once all tasks are submitted
        executor.shutdown();
        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        // Output final account balance after all transactions
        System.out.println("Final balance: " + account.getBalance());
    }
}