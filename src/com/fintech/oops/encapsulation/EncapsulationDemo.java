package com.fintech.oops.encapsulation;

/**
 * CONCEPT: Encapsulation (data hiding)
 * Fields are private. They can only be changed through safe, validated methods.
 */
class SecureAccount {
    private final String accountNumber;
    private double balance;      // hidden from outside
    private String pin;          // hidden from outside

    SecureAccount(String accountNumber, double openingBalance, String pin) {
        this.accountNumber = accountNumber;
        this.balance = openingBalance;
        this.pin = pin;
    }

    // Getter: read-only access
    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    // Controlled modification with validation
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount!");
            return;
        }
        balance += amount;
        System.out.println("Deposited " + amount + ". New balance: " + balance);
    }

    public void withdraw(double amount, String enteredPin) {
        if (!pin.equals(enteredPin)) {
            System.out.println("Wrong PIN! Withdrawal denied.");
        } else if (amount > balance) {
            System.out.println("Insufficient funds!");
        } else {
            balance -= amount;
            System.out.println("Withdrew " + amount + ". New balance: " + balance);
        }
    }
}

public class EncapsulationDemo {
    public static void main(String[] args) {
        SecureAccount acc = new SecureAccount("ACC2001", 10000, "1234");

        // acc.balance = 99999;   // NOT allowed: balance is private
        acc.deposit(-500);              // rejected by validation
        acc.deposit(2500);              // allowed
        acc.withdraw(1000, "0000");     // wrong pin
        acc.withdraw(1000, "1234");     // correct pin
        acc.withdraw(50000, "1234");    // not enough money

        System.out.println("Final balance: " + acc.getBalance());
    }
}
