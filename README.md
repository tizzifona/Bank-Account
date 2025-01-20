# Bank Account

## ✅Overview

This project models a bank account that allows basic operations such as deposits, withdrawals, and monthly interest calculations. The bank account has the following attributes:
Balance: type float, represents the current account balance.
Number of deposits: type int, initialized to zero.
Number of withdrawals: type int, initialized to zero.
Annual interest rate: type float, represents the annual interest percentage.
Monthly fee: type float, initialized to zero.

## ✅Classes

1. Account
Base class that manages general bank account operations.

Methods:
- Account(float initialBalance, float annualRate): Constructor that initializes the balance and annual interest rate
- void deposit(float amount): Deposits an amount into the account.
- void withdraw(float amount): Withdraws an amount if the balance is sufficient.
- void calculateMonthlyInterest(): Calculates monthly interest and updates the balance.
- void generateMonthlyStatement(): Applies the monthly fee and calculates interest.
- String print(): Returns the current values of the attributes.

2. SavingsAccount
Class that inherits from Account and adds active/inactive account functionality.

Additional attribute:
- boolean isActive: Indicates whether the account is active (balance >= $10000).
  
Overridden methods:
- void deposit(float amount): Allows deposits only if the account is active.
- void withdraw(float amount): Allows withdrawals only if the account is active.
- void generateMonthlyStatement(): Applies an additional fee if there are more than 4 withdrawals.
- String print(): Returns the account status along with inherited attributes.

3. CurrentAccount
Class that inherits from Account and allows overdrafts.

Additional attribute:
- float overdraft: Represents the current overdraft of the account.

Overridden methods:
- void withdraw(float amount): Allows withdrawals even if the balance is insufficient.
- void deposit(float amount): Reduces the overdraft if it exists.
- String print(): Returns the balance, fee, and current overdraft.

## ✅Contacts

<a href='https://www.linkedin.com/in/nadiia-alaieva/'><img src="https://i.postimg.cc/3RLmssnH/linkedin-3.png" alt="linkedin icon" width="30" height="30"></a>

