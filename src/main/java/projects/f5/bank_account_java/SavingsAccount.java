package projects.f5.bank_account_java;

public class SavingsAccount extends Account {
    private boolean isActive;

    public SavingsAccount(float balance, float annualRate) {
        super(balance, annualRate);
        this.isActive = balance >= 10000;
    }

    @Override
    public void deposit(float amount) {
        if (isActive) {
            super.deposit(amount);
        }
    }

    @Override
    public void withdraw(float amount) {
        if (isActive && amount <= balance) {
            super.withdraw(amount);
        }
    }

    @Override
    public void monthlyStatement() {
        if (withdrawalsCount > 4) {
            monthlyCommission = (withdrawalsCount - 4) * 1000;
        }
        super.monthlyStatement();
        isActive = balance >= 10000;
    }

    public String print() {
        return "Balance: " + balance +
                "\nMonthly Commission: " + monthlyCommission +
                "\nTotal Transactions: " + (depositsCount + withdrawalsCount) +
                "\nAnnual Rate: " + annualRate +
                "\nAccount Status: " + (isActive ? "Active" : "Inactive");
    }
}