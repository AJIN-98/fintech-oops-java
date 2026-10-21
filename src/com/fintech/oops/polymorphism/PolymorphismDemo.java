package com.fintech.oops.polymorphism;

/**
 * CONCEPT: Polymorphism (one name, many forms)
 * 1) Compile-time: Method Overloading (same name, different parameters)
 * 2) Runtime: Method Overriding (child changes parent's behaviour)
 */

// ---------- 1) Overloading ----------
class PaymentService {
    void pay(double amount) {
        System.out.println("Paid " + amount + " INR (default wallet)");
    }

    void pay(double amount, String currency) {
        System.out.println("Paid " + amount + " " + currency);
    }

    void pay(String fromAccount, String toAccount, double amount) {
        System.out.println("Transferred " + amount + " from " + fromAccount + " to " + toAccount);
    }
}

// ---------- 2) Overriding ----------
class Payment {
    void process(double amount) {
        System.out.println("Processing generic payment of " + amount);
    }
}

class UpiPayment extends Payment {
    @Override
    void process(double amount) {
        System.out.println("UPI payment of " + amount + " completed instantly");
    }
}

class CardPayment extends Payment {
    @Override
    void process(double amount) {
        double fee = amount * 0.02;   // 2% card fee
        System.out.println("Card payment of " + amount + " done, gateway fee = " + fee);
    }
}

class NetBankingPayment extends Payment {
    @Override
    void process(double amount) {
        System.out.println("Net banking payment of " + amount + " done after OTP verification");
    }
}

public class PolymorphismDemo {
    public static void main(String[] args) {
        System.out.println("--- Method Overloading ---");
        PaymentService service = new PaymentService();
        service.pay(500);
        service.pay(100, "USD");
        service.pay("ACC1", "ACC2", 2500);

        System.out.println("\n--- Method Overriding (runtime polymorphism) ---");
        // Parent reference, child objects
        Payment[] payments = { new UpiPayment(), new CardPayment(), new NetBankingPayment() };
        for (Payment p : payments) {
            p.process(1000);   // the correct child method is chosen at runtime
        }
    }
}
