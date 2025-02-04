import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SavingsAccountTest {
    @Test
    void withdrawTest1() {
        BankAccount savingsAccount = new SavingsAccount("1", 5000, "Kirill");
        savingsAccount.withdraw(1000);
        assertEquals(4000, savingsAccount.getBalance());

    }
    @Test
    void withdrawTest2() {
        BankAccount savingsAccount = new SavingsAccount("1", 500, "Kirill");
        savingsAccount.withdraw(5000);
        assertEquals(500, savingsAccount.getBalance());
    }
    @Test
    void deposit() {
        BankAccount savingsAccount = new SavingsAccount("1", 500, "Kirill");
        savingsAccount.deposit(1000);
        assertEquals(1500, savingsAccount.getBalance());
    }

    @Test
    void applyInterest() {
        BankAccount savingsAccount = new SavingsAccount("1", 500, "Kirill");
        ((IInterestBearing)savingsAccount).applyInterest();
        assertEquals(505, savingsAccount.getBalance());
    }
}