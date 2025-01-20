package projects.f5.bank_account_java;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CurrentAccountTest {

    private CurrentAccount account;

    @BeforeEach
    void setUp() {
        account = new CurrentAccount(100f, 5f);
    }

    @Test
    void testDeposit() {
        account.deposit(50f);

        assertEquals(150f, account.getBalance(), "Balance should be 150 after deposit");
        account.withdraw(120f);
        account.deposit(80f);
        assertEquals(110f, account.getBalance(), "Balance should be 110 after deposit to cover overdraft");
    }

    @Test
    void testPrint() {
        String expectedOutput = "Balance: 100.0\nMonthly Commission: 0.0\nTotal Transactions: 0\nAnnual Rate: 5.0\nOverdraft: 0.0";
        assertEquals(expectedOutput, account.print(), "Print output should match the expected format");
    }

    @Test
    void testWithdraw() {
        account.withdraw(50f);
        assertEquals(50f, account.getBalance(), "Balance should be 50 after withdrawal of 50");

        account.withdraw(100f);
        assertEquals(0f, account.getBalance(), "Balance should be 0 after withdrawal of 100");
        assertEquals(50f, account.getOverdraft(), "Overdraft should be 50 after withdrawal of 100");
    }

}
