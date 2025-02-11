import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CreditAccountTest {

    @Test
    void withdrawTest1() {
        BankAccount creditAccount = new CreditAccount("1", new BigDecimal("0"), "Kirill");
        creditAccount.withdraw(new BigDecimal("1000"));
        assertEquals(new BigDecimal("-1000"), creditAccount.getBalance());
    }

    @Test
    void withdrawTest2() {
        BankAccount creditAccount = new CreditAccount("1", BigDecimal.valueOf(-5000), "Kirill");
        creditAccount.withdraw(BigDecimal.valueOf(1000));
        assertEquals(BigDecimal.valueOf(-5000), creditAccount.getBalance());
    }

    @Test
    void deposit() {
        BankAccount creditAccount = new CreditAccount("1", BigDecimal.valueOf(500), "Kirill");
        creditAccount.deposit(BigDecimal.valueOf(1000));
        assertEquals(BigDecimal.valueOf(1500), creditAccount.getBalance());
    }

}