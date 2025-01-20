package projects.f5.bank_account_java;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {
    private Account account;

    @BeforeEach
    void setUp() {
        account = new Account(1000.0f, 0.05f);
    }

    @Test
    void testInitialBalance() {
        assertEquals(1000.0f, account.balance);
    }

    @Test
    void testDeposit() {
        account.deposit(500.0f);
        assertEquals(1500.0f, account.balance);
        assertEquals(1, account.depositsCount);
    }

    @Test
    void testWithdrawSuccess() {
        account.withdraw(200.0f);
        assertEquals(800.0f, account.balance);
        assertEquals(1, account.withdrawalsCount);
    }

    @Test
    void testWithdrawFail() {
        account.withdraw(1200.0f);
        assertEquals(1000.0f, account.balance);
        assertEquals(0, account.withdrawalsCount);
    }

    @Test
    void testCalculateMonthlyInterest() {
        account.calculateMonthlyInterest();
        float expectedBalance = 1000.0f + (1000.0f * (0.05f / 12));
        assertEquals(expectedBalance, account.balance, 0.01f);
    }

    @Test
    void testMonthlyStatement() {
        account.monthlyCommission = 50.0f;
        account.monthlyStatement();
        float expectedBalance = (1000.0f - 50.0f) + ((1000.0f - 50.0f) * (0.05f / 12));
        assertEquals(expectedBalance, account.balance, 0.01f);
    }

    @Test
    void testPrint() {
        String expectedOutput = "Balance: 1000.0\n" +
                "Deposits Count: 0\n" +
                "Withdrawals Count: 0\n" +
                "Annual Rate: 0.05\n" +
                "Monthly Commission: 0.0";
        assertEquals(expectedOutput, account.print());
    }
}
