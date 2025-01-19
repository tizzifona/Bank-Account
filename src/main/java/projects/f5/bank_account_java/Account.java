package projects.f5.bank_account_java;

public class Account {
    protected float balance;
    protected float annualRate;
    protected int deposits = 0;
    protected int withdrawals = 0;
    protected float monthlyFee = 0.0f;

    public Account(float initialBalance, float annualRate) {
        this.balance = initialBalance;
        this.annualRate = annualRate;
    }

    public void deposit(float amount) {
        if (amount > 0) {
            balance += amount;
            deposits++;
        }
    }

    public void withdraw(float amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            withdrawals++;
        }
    }

    public void calculateMonthlyInterest() {
        float monthlyInterestRate = annualRate / 12 / 100;
        balance += balance * monthlyInterestRate;
    }

    public void generateMonthlyStatement() {
        balance -= monthlyFee;
        calculateMonthlyInterest();
        monthlyFee = 0;
    }

    public String print() {
        return String.format("Balance: %.2f, Monthly Fee: %.2f, Deposits: %d, Withdrawals: %d",
                balance, monthlyFee, deposits, withdrawals);
    }
}
