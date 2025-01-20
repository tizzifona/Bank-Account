package projects.f5.bank_account_java;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    private SavingsAccount savings;
    private CurrentAccount current;

    @BeforeEach
    void setUp() {
        savings = new SavingsAccount(20000, 0.12f);
        current = new CurrentAccount(10000, 0.12f);
    }

    @Test
    void testSavingsAccountInitialBalance() {
        assertEquals(20000, savings.getBalance(), "Initial balance should be 20000");
    }

    @Test
    void testSavingsAccountWithdraw() {
        savings.withdraw(5000);
        assertEquals(15000, savings.getBalance(), "Balance after withdrawal of 5000 should be 15000");
    }

    @Test
    void testSavingsAccountDeposit() {
        savings.deposit(2000);
        assertEquals(22000, savings.getBalance(), "Balance after deposit of 2000 should be 22000");
    }

    @Test
    void testSavingsAccountWithdrawMultiple() {
        savings.withdraw(5000);
        savings.withdraw(1000);
        savings.withdraw(2000);
        assertEquals(12000, savings.getBalance(), "Balance after multiple withdrawals should be 12000");
    }

    @Test
    void testCurrentAccountInitialBalance() {
        assertEquals(10000, current.getBalance(), "Initial balance should be 10000");
    }

}
