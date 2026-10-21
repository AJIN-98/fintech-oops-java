package com.fintech.oops.inheritance;

/**
 * CONCEPT: Inheritance (IS-A relationship)
 * A child class reuses code of a parent class using "extends".
 * Shows: single, hierarchical and multilevel inheritance, plus super keyword.
 */
class Account {
    protected String accountNumber;
    protected double balance;

    Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println(accountNumber + ": deposited " + amount + ", balance = " + balance);
    }

    void showDetails() {
        System.out.println("Account " + accountNumber + " | Balance " + balance);
    }
}

// Child 1 (single inheritance)
class SavingsAccount extends Account {
    protected double interestRate;

    SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);       // call parent constructor
        this.interestRate = interestRate;
    }

    void addInterest() {
        double interest = balance * interestRate / 100;
        balance += interest;
        System.out.println(accountNumber + ": interest " + interest + " added, balance = " + balance);
    }
}

// Child 2 (hierarchical inheritance: same parent, different child)
class CurrentAccount extends Account {
    private double overdraftLimit;

    CurrentAccount(String accountNumber, double balance, double overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    void withdraw(double amount) {
        if (amount <= balance + overdraftLimit) {
            balance -= amount;
            System.out.println(accountNumber + ": withdrew " + amount + ", balance = " + balance);
        } else {
            System.out.println(accountNumber + ": overdraft limit exceeded");
        }
    }
}

// Grandchild (multilevel inheritance: Account -> SavingsAccount -> PremiumSavingsAccount)
class PremiumSavingsAccount extends SavingsAccount {
    PremiumSavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance, 6.5);   // better interest rate
    }

    @Override
    void showDetails() {
        super.showDetails();                  // reuse parent's version
        System.out.println("Premium benefits: free ATM, priority support");
    }
}

public class InheritanceDemo {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount("SAV3001", 20000, 4);
        savings.deposit(5000);       // inherited from Account
        savings.addInterest();       // its own method

        CurrentAccount current = new CurrentAccount("CUR3002", 3000, 5000);
        current.withdraw(6000);      // uses overdraft
        current.withdraw(10000);     // too much

        PremiumSavingsAccount premium = new PremiumSavingsAccount("PRM3003", 100000);
        premium.addInterest();
        premium.showDetails();
    }
}
