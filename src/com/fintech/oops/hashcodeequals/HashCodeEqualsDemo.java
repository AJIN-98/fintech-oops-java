package com.fintech.oops.hashcodeequals;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * CONCEPT: equals() and hashCode()
 * By default Java compares objects by memory address (identity).
 * Override equals() to compare by business meaning (e.g. same transaction id),
 * and ALWAYS override hashCode() with it so HashSet / HashMap work correctly.
 *
 * Rule: if a.equals(b) is true, then a.hashCode() must equal b.hashCode().
 */

// Without equals/hashCode: two objects with the same data are "different"
class PlainTransaction {
    String transactionId;
    double amount;

    PlainTransaction(String transactionId, double amount) {
        this.transactionId = transactionId;
        this.amount = amount;
    }
}

// With equals/hashCode: the transactionId decides identity
class Transaction {
    private final String transactionId;   // unique business key
    private final double amount;

    Transaction(String transactionId, double amount) {
        this.transactionId = transactionId;
        this.amount = amount;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;                          // same object
        if (obj == null || getClass() != obj.getClass()) return false;
        Transaction other = (Transaction) obj;
        return transactionId.equals(other.transactionId);      // same id = same transaction
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId);                    // uses the same field as equals()
    }

    @Override
    public String toString() {
        return "Transaction[" + transactionId + ", " + amount + "]";
    }
}

public class HashCodeEqualsDemo {
    public static void main(String[] args) {
        System.out.println("--- Without equals/hashCode ---");
        PlainTransaction p1 = new PlainTransaction("TXN1001", 500);
        PlainTransaction p2 = new PlainTransaction("TXN1001", 500);
        System.out.println("p1.equals(p2)? " + p1.equals(p2));   // false (different objects)

        Set<PlainTransaction> plainSet = new HashSet<>();
        plainSet.add(p1);
        plainSet.add(p2);
        System.out.println("Plain set size (duplicate NOT detected): " + plainSet.size());  // 2

        System.out.println("\n--- With equals/hashCode ---");
        Transaction t1 = new Transaction("TXN2001", 1500);
        Transaction t2 = new Transaction("TXN2001", 1500);   // retry of the same payment
        Transaction t3 = new Transaction("TXN2002", 800);
        System.out.println("t1.equals(t2)? " + t1.equals(t2));                   // true
        System.out.println("t1.equals(t3)? " + t1.equals(t3));                   // false
        System.out.println("Same hashCode for t1 and t2? " + (t1.hashCode() == t2.hashCode()));

        Set<Transaction> txnSet = new HashSet<>();
        txnSet.add(t1);
        txnSet.add(t2);   // duplicate: ignored
        txnSet.add(t3);
        System.out.println("Transaction set size (duplicate detected): " + txnSet.size());  // 2

        System.out.println("\n--- Using it as a HashMap key ---");
        Map<Transaction, String> status = new HashMap<>();
        status.put(t1, "SUCCESS");
        // A brand new object with the same id still finds the entry
        System.out.println("Status of TXN2001: " + status.get(new Transaction("TXN2001", 0)));
    }
}
