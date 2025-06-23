package com.nisum.Question4;

public class BankSimulator {
    public static void main(String[] args) {
        BankAccount[] accounts = new BankAccount[3];
        accounts[0] = new BankAccount(1, 1000);
        accounts[1] = new BankAccount(2, 1000);
        accounts[2] = new BankAccount(3, 1000);

        TransferTask t1 = new TransferTask(accounts);
        TransferTask t2 = new TransferTask(accounts);
        TransferTask t3 = new TransferTask(accounts);

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Print final balances
        System.out.println("\n🏁 Final Balances:");
        for (BankAccount account : accounts) {
            System.out.printf("Account %d: ₹%d%n", account.getId(), account.getBalance());
        }
    }
}

