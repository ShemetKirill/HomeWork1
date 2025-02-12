import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CreditAccountTest {

    @Test
    void positiveWithdrawTest() {
        BankAccount creditAccount = new CreditAccount("1", new BigDecimal("0"), "Kirill");
        creditAccount.withdraw(new BigDecimal("1000"));
        assertEquals(new BigDecimal("-1000"), creditAccount.getBalance());
    }

    @Test
    void invalidWithdrawTest() {
        BankAccount creditAccount = new CreditAccount("1", BigDecimal.valueOf(-5000), "Kirill");
        creditAccount.withdraw(BigDecimal.valueOf(1000));
        assertEquals(BigDecimal.valueOf(-5000), creditAccount.getBalance());
    }
    @Test
    void overLimitWithdrawTest() {
        BankAccount creditAccount = new CreditAccount("1", new BigDecimal("50070"), "Kirill");
        creditAccount.withdraw(BigDecimal.valueOf(12000));
        assertEquals(BigDecimal.valueOf(50070), creditAccount.getBalance());
    }

    @Test
    void deposit() {
        BankAccount creditAccount = new CreditAccount("1", BigDecimal.valueOf(500), "Kirill");
        creditAccount.deposit(BigDecimal.valueOf(1000));
        assertEquals(BigDecimal.valueOf(1500), creditAccount.getBalance());
    }
    @Test
    public void testApplyFee() {
        CreditAccount creditAccount = new CreditAccount("2", new BigDecimal("1000"), "Kirill");
        BigDecimal amount = new BigDecimal("1000");
        BigDecimal expectedFee = amount.multiply(CreditAccount.PERCENT_COMISSION).setScale(2, BigDecimal.ROUND_HALF_UP);
        assertEquals(expectedFee, creditAccount.applyFee(amount));
    }
}