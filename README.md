# Fintech OOPs Concepts in Java

Simple, beginner-friendly Java examples of every core OOP concept using banking / fintech terms.
Each concept lives in its own package and has its own `main()` so it can be run independently.

| Package | Concept | Fintech example |
|---|---|---|
| `classesobjects` | Class & Object | BankAccount |
| `encapsulation` | Data hiding, getters, validation | SecureAccount with PIN |
| `constructors` | Default, parameterized, copy, chaining | CreditCard |
| `inheritance` | Single, hierarchical, multilevel, `super` | Savings / Current / Premium accounts |
| `polymorphism` | Overloading & overriding | PaymentService, UPI / Card / NetBanking |
| `abstraction` | Abstract classes | Loan -> HomeLoan, PersonalLoan |
| `interfaces` | Interfaces, default methods, multiple implementation | PaymentGateway, Refundable |
| `association` | Association, aggregation, composition | Customer, Bank, Account statement |
| `staticfinal` | `static`, `final`, `this` | Wallet |
| `enums` | Enums with data | TransactionType, AccountStatus |
| `exceptionhandling` | Custom exceptions | InsufficientBalanceException |

## Requirements
JDK 17 or later (`javac -version` to check).

## How to run
Linux / macOS:
```
./run.sh                    # list demos
./run.sh encapsulation      # run one demo
./run.sh all                # run all demos
```
Windows:
```
run.bat encapsulation
```
Manual:
```
javac -d out $(find src -name "*.java")
java -cp out com.fintech.oops.polymorphism.PolymorphismDemo
```
Works in IntelliJ / Eclipse too: open the folder, mark `src` as Sources Root, and run any `*Demo` class.
