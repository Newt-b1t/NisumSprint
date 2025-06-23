package com.nisum.Question4;

import java.util.Random;

public class TransferTask extends Thread {
    private final BankAccount[] accounts;
    private final Random random = new Random();

    public TransferTask(BankAccount[] accounts) {
        this.accounts = accounts;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            int fromIndex = random.nextInt(accounts.length);
            int toIndex = random.nextInt(accounts.length);
            while (toIndex == fromIndex) {
                toIndex = random.nextInt(accounts.length);
            }

            int amount = random.nextInt(100);
            TransferService.transferMoney(accounts[fromIndex], accounts[toIndex], amount);
        }
    }
}

