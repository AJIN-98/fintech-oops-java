package com.fintech.oops.constructors;

/**
 * CONCEPT: Constructors
 * Special methods that run when an object is created.
 * Shows: default, parameterized, constructor chaining (this), copy constructor.
 */
class CreditCard {
    private String cardNumber;
    private String holderName;
    private double creditLimit;

    // 1. Default constructor
    CreditCard() {
        this("0000-0000-0000-0000", "Unknown", 10000);
        System.out.println("Default constructor used (basic card issued)");
    }

    // 2. Parameterized constructor
    CreditCard(String cardNumber, String holderName, double creditLimit) {
        this.cardNumber = cardNumber;
        this.holderName = holderName;
        this.creditLimit = creditLimit;
    }

    // 3. Copy constructor: creates a replacement card with the same details
    CreditCard(CreditCard other) {
        this(other.cardNumber, other.holderName, other.creditLimit);
        System.out.println("Copy constructor used (replacement card issued)");
    }

    void showCard() {
        System.out.println("Card: " + cardNumber + " | Holder: " + holderName + " | Limit: " + creditLimit);
    }
}

public class ConstructorsDemo {
    public static void main(String[] args) {
        CreditCard basic = new CreditCard();
        basic.showCard();

        CreditCard gold = new CreditCard("4111-1111-1111-1111", "Asha", 150000);
        gold.showCard();

        CreditCard replacement = new CreditCard(gold);
        replacement.showCard();
    }
}
