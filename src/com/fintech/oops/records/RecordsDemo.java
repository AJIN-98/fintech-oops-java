package com.fintech.oops.records;

import java.util.HashSet;
import java.util.Set;

/**
 * CONCEPT: Record (Java 16+)
 * A short way to create an immutable data class.
 * Java automatically generates: constructor, getters (named like the field),
 * equals(), hashCode() and toString().
 */

// One line replaces ~30 lines of a normal class
record Money(double amount, String currency) { }

// Record with validation (compact constructor) and extra methods
record Payment(String paymentId, Money money, String payer, String payee) {

    // Compact constructor: runs before fields are assigned
    Payment {
        if (money.amount() <= 0) {
            throw new IllegalArgumentException("Payment amount must be positive");
        }
    }

    // Extra behaviour is allowed
    boolean isHighValue() {
        return money.amount() >= 100000;
    }

    // Static factory method
    static Payment upi(String id, double amount, String payer, String payee) {
        return new Payment(id, new Money(amount, "INR"), payer, payee);
    }
}

public class RecordsDemo {
    public static void main(String[] args) {
        Payment p1 = Payment.upi("PAY1001", 2500, "Asha", "Ravi");

        // Auto-generated toString()
        System.out.println(p1);

        // Auto-generated accessors (no "get" prefix)
        System.out.println("Payer: " + p1.payer() + ", Amount: " + p1.money().amount()
                + " " + p1.money().currency());

        // Auto-generated equals() compares ALL fields
        Payment same = Payment.upi("PAY1001", 2500, "Asha", "Ravi");
        Payment different = Payment.upi("PAY1002", 2500, "Asha", "Ravi");
        System.out.println("p1.equals(same)? " + p1.equals(same));             // true
        System.out.println("p1.equals(different)? " + p1.equals(different));   // false

        // Auto-generated hashCode() lets records work in a HashSet
        Set<Payment> set = new HashSet<>();
        set.add(p1);
        set.add(same);
        System.out.println("Set size (duplicate ignored): " + set.size());     // 1

        // Custom method
        Payment big = Payment.upi("PAY1003", 250000, "Corp Ltd", "Vendor");
        System.out.println("Is PAY1003 high value? " + big.isHighValue());

        // Records are immutable: there are no setters
        // p1.payer = "Someone";   // ERROR: fields are final

        // Validation in action
        try {
            Payment.upi("PAY1004", -50, "Asha", "Ravi");
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }
    }
}
