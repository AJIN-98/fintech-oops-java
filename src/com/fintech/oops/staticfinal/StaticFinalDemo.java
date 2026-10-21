package com.fintech.oops.staticfinal;

/**
 * CONCEPT: static, final and this keywords
 * static : belongs to the class, shared by all objects
 * final  : value / method / class cannot be changed
 * this   : refers to the current object
 */
class Wallet {
    // static: shared counter across all wallets
    private static int totalWallets = 0;

    // static + final: a constant
    static final double MIN_BALANCE = 100.0;

    // final: set once, never changed
    private final int walletId;
    private double balance;

    Wallet(double balance) {
        totalWallets++;
        this.walletId = totalWallets;   // 'this' = the object being created
        this.balance = balance;
    }

    // static method: can be called without creating an object
    static int getTotalWallets() {
        return totalWallets;
    }

    void spend(double amount) {
        if (balance - amount < MIN_BALANCE) {
            System.out.println("Wallet " + walletId + ": must keep minimum balance of " + MIN_BALANCE);
        } else {
            balance -= amount;
            System.out.println("Wallet " + walletId + ": spent " + amount + ", balance = " + balance);
        }
    }
}

public class StaticFinalDemo {
    public static void main(String[] args) {
        Wallet w1 = new Wallet(1000);
        Wallet w2 = new Wallet(500);
        Wallet w3 = new Wallet(250);

        w1.spend(300);
        w2.spend(450);    // would drop below minimum
        w3.spend(100);

        // Accessed using class name, not an object
        System.out.println("Total wallets created: " + Wallet.getTotalWallets());
        System.out.println("Minimum balance rule: " + Wallet.MIN_BALANCE);
    }
}
