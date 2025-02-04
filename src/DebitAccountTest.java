import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class DebitAccountTest {

    @org.junit.jupiter.api.Test
    void withdrawTest1() {
        BankAccount debitAccount = new DebitAccount("1", 5000, "Kirill");
        debitAccount.withdraw(1000);
        assertEquals(4000, debitAccount.getBalance());

    }
    @Test
    void withdrawTest2() {
        BankAccount debitAccount = new DebitAccount("1", 500, "Kirill");
        debitAccount.withdraw(5000);
        assertEquals(500, debitAccount.getBalance());
    }
    @Test
    void deposit(){
        BankAccount debitAccount = new DebitAccount("1", 500, "Kirill");
        debitAccount.deposit(1000);
        assertEquals(1500, debitAccount.getBalance());
    }


}