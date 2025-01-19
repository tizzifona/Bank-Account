package projects.f5.bank_account_java;

class CurrentAccount extends Account {
    private float overdraft = 0.0f;

    public CurrentAccount(float initialBalance, float annualRate) {
        super(initialBalance, annualRate);
    }

    @Override
    public void withdraw(float amount) {
        if (amount > 0) {
            if (amount <= balance) {
                super.withdraw(amount);
            } else {
                overdraft += (amount - balance);
                balance = 0;
                withdrawals++;
            }
        }
    }

    @Override
    public void deposit(float amount) {
        if (amount > 0) {
            if (overdraft > 0) {
                if (amount >= overdraft) {
                    amount -= overdraft;
                    overdraft = 0;
                } else {
                    overdraft -= amount;
                    amount = 0;
                }
            }
            super.deposit(amount);
        }
    }

    @Override
    public String print() {
        return String.format("%s, Overdraft: %.2f", super.print(), overdraft);
    }
}
