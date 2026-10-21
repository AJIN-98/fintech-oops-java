package com.fintech.oops.enums;

/**
 * CONCEPT: Enum (a fixed set of constant values, which can also hold data and methods)
 */
enum TransactionType {
    DEPOSIT("Money added to account"),
    WITHDRAWAL("Money taken from account"),
    TRANSFER("Money sent to another account"),
    BILL_PAYMENT("Utility or bill payment");

    private final String description;

    TransactionType(String description) {
        this.description = description;
    }

    String getDescription() {
        return description;
    }
}

enum AccountStatus {
    ACTIVE, FROZEN, CLOSED
}

class Transaction {
    private final TransactionType type;
    private final double amount;

    Transaction(TransactionType type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    void print() {
        System.out.println(type + " of " + amount + " -> " + type.getDescription());
    }
}

public class EnumsDemo {
    public static void main(String[] args) {
        new Transaction(TransactionType.DEPOSIT, 5000).print();
        new Transaction(TransactionType.TRANSFER, 1200).print();
        new Transaction(TransactionType.BILL_PAYMENT, 899).print();

        AccountStatus status = AccountStatus.FROZEN;
        switch (status) {
            case ACTIVE -> System.out.println("Account is active: all operations allowed");
            case FROZEN -> System.out.println("Account is frozen: only deposits allowed");
            case CLOSED -> System.out.println("Account is closed: no operations allowed");
        }

        System.out.println("All transaction types:");
        for (TransactionType t : TransactionType.values()) {
            System.out.println("  - " + t);
        }
    }
}
