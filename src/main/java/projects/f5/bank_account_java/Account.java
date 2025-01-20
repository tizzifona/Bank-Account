package projects.f5.bank_account_java;

public class Account {
    protected float balance;
    protected int depositsCount;
    protected int withdrawalsCount;
    protected float annualRate;
    protected float monthlyCommission;

    public Account(float balance, float annualRate) {
        this.balance = balance;
        this.annualRate = annualRate;
        this.depositsCount = 0;
        this.withdrawalsCount = 0;
        this.monthlyCommission = 0;
    }

    public void deposit(float amount) {
        balance += amount;
        depositsCount++;
    }

    public void withdraw(float amount) {
        if (amount <= balance) {
            balance -= amount;
            withdrawalsCount++;
        }
    }

    public void calculateMonthlyInterest() {
        float monthlyRate = annualRate / 12;
        float monthlyInterest = balance * monthlyRate;
        balance += monthlyInterest;
    }

    public void monthlyStatement() {
        balance -= monthlyCommission;
        calculateMonthlyInterest();
    }

    public String print() {
        return "Balance: " + balance +
               "\nDeposits Count: " + depositsCount +
               "\nWithdrawals Count: " + withdrawalsCount +
               "\nAnnual Rate: " + annualRate +
               "\nMonthly Commission: " + monthlyCommission;
    }
}