package com.avinash.sprint3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Account {
    private final int id;
    private int balance;
    private final Lock lock = new ReentrantLock();

    public Account(int id, int initialBalance) {
        this.id = id;
        this.balance = initialBalance;
    }

    public int getId() {
        return id;
    }

    public Lock getLock() {
        return lock;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }
}

class Bank {
    public static void transfer(Account from, Account to, int amount) {
        // Lock both accounts in consistent order to prevent deadlock
        Account first = from.getId() < to.getId() ? from : to;
        Account second = from.getId() < to.getId() ? to : from;

        first.getLock().lock();
        second.getLock().lock();

        try {
            if (from.getBalance() >= amount) {
                from.withdraw(amount);
                to.deposit(amount);
                System.out.println("Transferred ₹" + amount + " from Account " + from.getId() + " to Account " + to.getId());
            } else {
                System.out.println("Insufficient balance in Account " + from.getId());
            }
        } finally {
            second.getLock().unlock();
            first.getLock().unlock();
        }
    }
}

public class MoneyTransferSimulation {
    public static void main(String[] args) {
        Account acc1 = new Account(1, 1000);
        Account acc2 = new Account(2, 1000);
        Account acc3 = new Account(3, 1000);

        Runnable t1 = () -> Bank.transfer(acc1, acc2, 300);
        Runnable t2 = () -> Bank.transfer(acc2, acc3, 500);
        Runnable t3 = () -> Bank.transfer(acc3, acc1, 700);

        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t2);
        Thread thread3 = new Thread(t3);

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Final balances
        System.out.println("\nFinal Balances:");
        System.out.println("Account 1: ₹" + acc1.getBalance());
        System.out.println("Account 2: ₹" + acc2.getBalance());
        System.out.println("Account 3: ₹" + acc3.getBalance());
    }
}

