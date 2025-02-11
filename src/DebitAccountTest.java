import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class DebitAccountTest {

    @Test
    void withdrawTest1() {
        BankAccount debitAccount = new DebitAccount("1", new BigDecimal("5000"), "Kirill");
        debitAccount.withdraw(BigDecimal.valueOf(1000));
        assertEquals(BigDecimal.valueOf(4000), debitAccount.getBalance());
    }

    @Test
    void withdrawTest2() {
        BankAccount debitAccount = new DebitAccount("1", new BigDecimal("500"), "Kirill");
        debitAccount.withdraw(BigDecimal.valueOf(5000));
        assertEquals(BigDecimal.valueOf(500), debitAccount.getBalance());
    }

    @Test
    void deposit() {
        BankAccount debitAccount = new DebitAccount("1", BigDecimal.valueOf(500), "Kirill");
        debitAccount.deposit(BigDecimal.valueOf(1000));
        assertEquals(BigDecimal.valueOf(1500), debitAccount.getBalance());
    }
}