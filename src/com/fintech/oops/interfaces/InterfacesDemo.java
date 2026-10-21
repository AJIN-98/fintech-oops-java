package com.fintech.oops.interfaces;

/**
 * CONCEPT: Interface (a contract / 100% abstraction)
 * A class promises to implement all methods of an interface.
 * A class can implement MANY interfaces (Java's way of multiple inheritance).
 */
interface PaymentGateway {
    void pay(double amount);                  // abstract method

    default void printReceipt(double amount) { // default method (shared behaviour)
        System.out.println("Receipt: payment of " + amount + " successful");
    }
}

interface Refundable {
    void refund(double amount);
}

// Implements two interfaces
class CardGateway implements PaymentGateway, Refundable {
    @Override
    public void pay(double amount) {
        System.out.println("Card gateway: charging " + amount);
    }

    @Override
    public void refund(double amount) {
        System.out.println("Card gateway: refunding " + amount + " to the card");
    }
}

// Implements only one interface
class UpiGateway implements PaymentGateway {
    @Override
    public void pay(double amount) {
        System.out.println("UPI gateway: collecting " + amount + " via UPI ID");
    }
}

public class InterfacesDemo {
    public static void main(String[] args) {
        PaymentGateway card = new CardGateway();
        PaymentGateway upi = new UpiGateway();

        card.pay(2000);
        card.printReceipt(2000);

        upi.pay(750);
        upi.printReceipt(750);

        // Check whether a gateway supports refund
        if (card instanceof Refundable) {
            ((Refundable) card).refund(500);
        }
        if (!(upi instanceof Refundable)) {
            System.out.println("UPI gateway does not support refund in this demo");
        }
    }
}
