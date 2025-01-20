package projects.f5.bank_account_java;

public class CurrentAccount extends Account {
    private float overdraft;

    public CurrentAccount(float balance, float annualRate) {
        super(balance, annualRate);
        this.overdraft = 0;
    }

    @Override
    public void withdraw(float amount) {
        if (amount <= balance) {
            super.withdraw(amount);
        } else {
            overdraft = amount - balance;
            balance = 0;
            withdrawalsCount++;
        }
    }

    @Override
    public void deposit(float amount) {
        if (overdraft > 0) {
            if (amount <= overdraft) {
                overdraft -= amount;
            } else {
                float remainingAmount = amount - overdraft;
                overdraft = 0;
                super.deposit(remainingAmount);
            }
        } else {
            super.deposit(amount);
        }
    }

    public String print() {
        return "Balance: " + balance +
               "\nMonthly Commission: " + monthlyCommission +
               "\nTotal Transactions: " + (depositsCount + withdrawalsCount) +
               "\nAnnual Rate: " + annualRate +
               "\nOverdraft: " + overdraft;
    }
}