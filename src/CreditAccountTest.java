import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreditAccountTest {

    @Test
    void withdrawTest1() {
        BankAccount creditAccount = new CreditAccount("1", 0, "Kirill");
        creditAccount.withdraw(1000);
        assertEquals(-1000, creditAccount.getBalance());
    }
    @Test
    void withdrawTest2() {
        BankAccount creditAccount = new CreditAccount("1", -5000, "Kirill");
        creditAccount.withdraw(1000);
        assertEquals(-5000, creditAccount.getBalance());
    }
    @Test
    void deposit(){
        BankAccount creditAccount = new CreditAccount("1", 500, "Kirill");
        creditAccount.deposit(1000);
        assertEquals(1500, creditAccount.getBalance());
    }

}