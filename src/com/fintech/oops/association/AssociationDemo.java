package com.fintech.oops.association;

import java.util.ArrayList;
import java.util.List;

/**
 * CONCEPT: Association, Aggregation and Composition (HAS-A relationships)
 *
 * Association : Customer uses an Advisor (both exist independently)
 * Aggregation : Bank HAS Customers (customers can exist without the bank object)
 * Composition : Account OWNS its TransactionHistory (history dies with the account)
 */
class Advisor {
    String name;
    Advisor(String name) { this.name = name; }
}

class Customer {
    String name;
    Advisor advisor;   // Association

    Customer(String name) { this.name = name; }

    void meetAdvisor(Advisor advisor) {
        this.advisor = advisor;
        System.out.println(name + " is meeting advisor " + advisor.name);
    }
}

// Composition: the Account creates and owns its history
class Account {
    private final String accountNumber;
    private final List<String> transactionHistory = new ArrayList<>();  // created inside

    Account(String accountNumber) { this.accountNumber = accountNumber; }

    void addTransaction(String details) {
        transactionHistory.add(details);
    }

    void printStatement() {
        System.out.println("Statement for " + accountNumber + ":");
        for (String t : transactionHistory) {
            System.out.println("  - " + t);
        }
    }
}

// Aggregation: the Bank holds customers that are created outside of it
class Bank {
    private final String bankName;
    private final List<Customer> customers = new ArrayList<>();

    Bank(String bankName) { this.bankName = bankName; }

    void addCustomer(Customer customer) {
        customers.add(customer);
    }

    void listCustomers() {
        System.out.println(bankName + " customers:");
        for (Customer c : customers) {
            System.out.println("  - " + c.name);
        }
    }
}

public class AssociationDemo {
    public static void main(String[] args) {
        // Association
        Customer asha = new Customer("Asha");
        Advisor advisor = new Advisor("Mr. Menon");
        asha.meetAdvisor(advisor);

        // Aggregation
        Customer ravi = new Customer("Ravi");
        Bank bank = new Bank("Global Fin Bank");
        bank.addCustomer(asha);
        bank.addCustomer(ravi);
        bank.listCustomers();

        // Composition
        Account account = new Account("ACC5001");
        account.addTransaction("Salary credited: +50000");
        account.addTransaction("Rent paid: -15000");
        account.addTransaction("UPI to Ravi: -2000");
        account.printStatement();
    }
}
