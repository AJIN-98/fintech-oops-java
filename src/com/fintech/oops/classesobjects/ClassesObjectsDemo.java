package com.fintech.oops.classesobjects;

/**
 * CONCEPT: Class and Object
 * A class is a blueprint (BankAccount). An object is a real instance of it.
 */
class BankAccount {
    // Fields (state)
    String accountNumber;
    String holderName;
    double balance;

    // Methods (behaviour)
    void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Credited " + amount + " to " + accountNumber);
    }

    void withdraw(double amount) {
        balance = balance - amount;
        System.out.println("Debited " + amount + " from " + accountNumber);
    }

    void showBalance() {
        System.out.println(holderName + " (" + accountNumber + ") balance: " + balance);
    }
}

public class ClassesObjectsDemo {
    public static void main(String[] args) {
        // Two different objects created from the same class
        BankAccount acc1 = new BankAccount();
        acc1.accountNumber = "ACC1001";
        acc1.holderName = "Asha";
        acc1.balance = 5000;

        BankAccount acc2 = new BankAccount();
        acc2.accountNumber = "ACC1002";
        acc2.holderName = "Ravi";
        acc2.balance = 12000;

        acc1.deposit(1500);
        acc2.withdraw(2000);

        acc1.showBalance();
        acc2.showBalance();
    }
}
