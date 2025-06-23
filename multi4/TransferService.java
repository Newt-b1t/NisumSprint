package com.nisum.Question4;

import java.util.Random;
import java.util.concurrent.locks.Lock;

public class TransferService {

    public static void transferMoney(BankAccount from, BankAccount to, int amount) {
        // Always lock accounts in order of ID to avoid deadlock
        BankAccount first = from.getId() < to.getId() ? from : to;
        BankAccount second = from.getId() < to.getId() ? to : from;

        Lock lock1 = first.getLock();
        Lock lock2 = second.getLock();

        boolean success = false;

        while (!success) {
            boolean gotFirstLock = lock1.tryLock();
            boolean gotSecondLock = lock2.tryLock();

            if (gotFirstLock && gotSecondLock) {
                try {
                    if (from.getBalance() >= amount) {
                        from.withdraw(amount);
                        to.deposit(amount);
                        System.out.printf("✅ Transferred %d from Account %d to Account %d%n", amount, from.getId(), to.getId());
                    } else {
                        System.out.printf("❌ Insufficient funds in Account %d to transfer %d%n", from.getId(), amount);
                    }
                    success = true;
                } finally {
                    lock2.unlock();
                    lock1.unlock();
                }
            } else {
                // Retry again
                if (gotFirstLock) lock1.unlock();
                if (gotSecondLock) lock2.unlock();

                try {
                    Thread.sleep(new Random().nextInt(10)); // backoff
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}

