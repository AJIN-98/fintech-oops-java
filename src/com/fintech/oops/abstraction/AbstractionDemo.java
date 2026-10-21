package com.fintech.oops.abstraction;

/**
 * CONCEPT: Abstraction (hide the "how", show the "what")
 * An abstract class cannot be instantiated. It forces child classes
 * to implement the abstract methods, and can also share common code.
 */
abstract class Loan {
    protected double principal;
    protected int years;

    Loan(double principal, int years) {
        this.principal = principal;
        this.years = years;
    }

    // Abstract method: every loan type calculates interest differently
    abstract double getInterestRate();

    // Concrete method: common for all loans
    double calculateTotalInterest() {
        return principal * getInterestRate() * years / 100;
    }

    void printSummary() {
        double interest = calculateTotalInterest();
        double monthlyEmi = (principal + interest) / (years * 12);
        System.out.println(getClass().getSimpleName() + " -> Principal: " + principal
                + ", Rate: " + getInterestRate() + "%, Interest: " + interest
                + ", Monthly EMI: " + Math.round(monthlyEmi));
    }
}

class HomeLoan extends Loan {
    HomeLoan(double principal, int years) { super(principal, years); }

    @Override
    double getInterestRate() { return 8.5; }
}

class PersonalLoan extends Loan {
    PersonalLoan(double principal, int years) { super(principal, years); }

    @Override
    double getInterestRate() { return 12.0; }
}

public class AbstractionDemo {
    public static void main(String[] args) {
        // Loan loan = new Loan(1000, 1);  // ERROR: cannot create object of abstract class
        Loan home = new HomeLoan(5000000, 20);
        Loan personal = new PersonalLoan(300000, 3);

        home.printSummary();
        personal.printSummary();
    }
}
