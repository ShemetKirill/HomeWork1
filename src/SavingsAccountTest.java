import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class SavingsAccountTest {
    @Test
    void positiveWithdrawTest1() {
        BankAccount savingsAccount = new SavingsAccount("1", BigDecimal.valueOf(5000), "Kirill");
        savingsAccount.withdraw(BigDecimal.valueOf(1000));
        assertEquals(BigDecimal.valueOf(4000), savingsAccount.getBalance());

    }

    @Test
    void invalidWithdrawTest2() {
        BankAccount savingsAccount = new SavingsAccount("1",BigDecimal.valueOf(500) , "Kirill");
        savingsAccount.withdraw(BigDecimal.valueOf(5000));
        assertEquals(BigDecimal.valueOf(500), savingsAccount.getBalance());
    }

    @Test
    void deposit() {
        BankAccount savingsAccount = new SavingsAccount("1", BigDecimal.valueOf(500), "Kirill");
        savingsAccount.deposit(BigDecimal.valueOf(1000));
        assertEquals(BigDecimal.valueOf(1500), savingsAccount.getBalance());
    }

    @Test
    void applyInterest() {
        SavingsAccount savingsAccount = new SavingsAccount("1", new BigDecimal("500"), "Kirill");
        savingsAccount.applyInterest();
        assertEquals(new BigDecimal("505.00"), savingsAccount.getBalance());
    }

}