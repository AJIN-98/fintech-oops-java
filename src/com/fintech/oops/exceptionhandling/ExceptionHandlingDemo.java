package com.fintech.oops.exceptionhandling;

/**
 * CONCEPT: Exception Handling with Custom Exceptions
 * Banking rules are enforced by throwing meaningful errors.
 */

// Custom checked exception
class InsufficientBalanceException extends Exception {
    InsufficientBalanceException(String message) {
        super(message);
    }
}

// Custom unchecked exception
class InvalidAmountException extends RuntimeException {
    InvalidAmountException(String message) {
        super(message);
    }
}

class Account {
    private double balance;

    Account(double balance) { this.balance = balance; }

    void withdraw(double amount) throws InsufficientBalanceException {
        if (amount <= 0) {
            throw new InvalidAmountException("Amount must be greater than zero");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException(
                    "Need " + (amount - balance) + " more to complete this withdrawal");
        }
        balance -= amount;
        System.out.println("Withdrawal successful. Balance: " + balance);
    }
}

public class ExceptionHandlingDemo {
    public static void main(String[] args) {
        Account account = new Account(5000);

        try {
            account.withdraw(2000);     // OK
            account.withdraw(-100);     // InvalidAmountException
        } catch (InsufficientBalanceException e) {
            System.out.println("Declined: " + e.getMessage());
        } catch (InvalidAmountException e) {
            System.out.println("Invalid request: " + e.getMessage());
        } finally {
            System.out.println("Transaction attempt logged (finally always runs)");
        }

        try {
            account.withdraw(10000);    // InsufficientBalanceException
        } catch (InsufficientBalanceException e) {
            System.out.println("Declined: " + e.getMessage());
        }
    }
}
