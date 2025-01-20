package projects.f5.bank_account_java;

public class App {
    public static void main(String[] args) {

        System.out.println("SAVINGS ACCOUNT TEST");
        SavingsAccount savings = new SavingsAccount(20000, 0.12f);
        System.out.println("\nInitial state:");
        System.out.println(savings.print());

        savings.withdraw(5000);
        savings.deposit(2000);
        savings.withdraw(1000);
        savings.withdraw(2000);
        savings.withdraw(3000);
        savings.withdraw(1000);

        System.out.println("\nAfter transactions:");
        System.out.println(savings.print());

        savings.monthlyStatement();
        System.out.println("\nAfter monthly statement:");
        System.out.println(savings.print());

        System.out.println("\nCURRENT ACCOUNT TEST");
        CurrentAccount current = new CurrentAccount(10000, 0.12f);
        System.out.println("\nInitial state:");
        System.out.println(current.print());

        current.withdraw(15000);
        current.deposit(3000);
        current.withdraw(2000);

        System.out.println("\nAfter transactions:");
        System.out.println(current.print());

        current.monthlyStatement();
        System.out.println("\nAfter monthly statement:");
        System.out.println(current.print());
    }
}
