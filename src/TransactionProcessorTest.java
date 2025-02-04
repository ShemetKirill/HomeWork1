import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TransactionProcessorTest {

    private List<BankAccount> accounts= new ArrayList<>();;
    private TransactionProcessor processor;
    @BeforeEach
    void setUp() {

        BankAccount debitAcc= new DebitAccount("1", 10000, "S");
        BankAccount creditAcc = new CreditAccount("2", 2000, "K");
        BankAccount savingAcc = new SavingsAccount("3", 8000, "F");
        accounts.add(debitAcc);
        accounts.add(creditAcc);
        accounts.add(savingAcc);
        processor = new TransactionProcessor();

    }
    @Test
    void processTransactionTest1() {
        processor.processTransaction(accounts,200);
        assertEquals(9800,accounts.get(0).getBalance());
        assertEquals(300,accounts.get(1).getBalance());
        assertEquals(1800,accounts.get(2).getBalance());
    }
    @Test
    void processTransactionTest2() {
        processor.processTransaction(accounts,5500);
        assertEquals(4500,accounts.get(0).getBalance());
        assertEquals(2000,accounts.get(1).getBalance());
        assertEquals(2500,accounts.get(2).getBalance());
    }
    @Test
    void processTransactionTest3() {
        processor.processTransaction(accounts,10000);
        assertEquals(10000,accounts.get(0).getBalance());
        assertEquals(2000,accounts.get(1).getBalance());
        assertEquals(8000,accounts.get(2).getBalance());
    }




}