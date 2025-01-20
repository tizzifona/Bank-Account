package projects.f5.bank_account_java;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SavingsAccountTest {
    private SavingsAccount account;

    @BeforeEach
    void setUp() {
        account = new SavingsAccount(15000, 5.0f);
    }

    @Test
    void testInitialAccountStatusActive() {
        assertTrue(account.print().contains("Account Status: Active"));
    }

    @Test
    void testInitialAccountStatusInactive() {
        SavingsAccount inactiveAccount = new SavingsAccount(5000, 5.0f);
        assertTrue(inactiveAccount.print().contains("Account Status: Inactive"));
    }

    @Test
    void testDepositWhenActive() {
        account.deposit(5000);
        assertTrue(account.print().contains("Balance: 20000.0"));
    }

    @Test
    void testDepositWhenInactive() {
        SavingsAccount inactiveAccount = new SavingsAccount(5000, 5.0f);
        inactiveAccount.deposit(5000);
        assertTrue(inactiveAccount.print().contains("Balance: 5000.0"));
    }

    @Test
    void testWithdrawWhenActive() {
        account.withdraw(5000);
        assertTrue(account.print().contains("Balance: 10000.0"));
    }

    @Test
    void testWithdrawWhenInactive() {
        SavingsAccount inactiveAccount = new SavingsAccount(5000, 5.0f);
        inactiveAccount.withdraw(1000);
        assertTrue(inactiveAccount.print().contains("Balance: 5000.0"));
    }

    @Test
    void testWithdrawMoreThanBalance() {
        account.withdraw(20000);
        assertTrue(account.print().contains("Balance: 15000.0"));
    }

    @Test
    void testMonthlyStatementWithNoExtraWithdrawals() {
        account.monthlyStatement();
        assertTrue(account.print().contains("Monthly Commission: 0.0"));
    }

    @Test
    void testMonthlyStatementWithExtraWithdrawals() {
        for (int i = 0; i < 6; i++) {
            account.withdraw(1000);
        }
        account.monthlyStatement();
        assertTrue(account.print().contains("Monthly Commission: 2000.0"));
    }

}
