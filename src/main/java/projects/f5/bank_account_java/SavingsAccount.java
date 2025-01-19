package projects.f5.bank_account_java;

class SavingsAccount extends Account {
    private boolean isActive;

    public SavingsAccount(float initialBalance, float annualRate) {
        super(initialBalance, annualRate);
        updateAccountStatus();
    }

    private void updateAccountStatus() {
        isActive = balance >= 10000;
    }

    @Override
    public void deposit(float amount) {
        if (isActive) {
            super.deposit(amount);
        }
        updateAccountStatus();
    }

    @Override
    public void withdraw(float amount) {
        if (isActive) {
            super.withdraw(amount);
        }
        updateAccountStatus();
    }

    @Override
    public void generateMonthlyStatement() {
        if (withdrawals > 4) {
            monthlyFee += (withdrawals - 4) * 1000;
        }
        super.generateMonthlyStatement();
        updateAccountStatus();
    }

    @Override
    public String print() {
        return String.format("%s, Active: %b", super.print(), isActive);
    }
}
