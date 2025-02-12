import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TransactionProcessorTest {
    private List<BankAccount> accounts = new ArrayList<>();
    private TransactionProcessor processor;

    @BeforeEach
    void setUp() {
        BankAccount debitAcc = new DebitAccount("1", BigDecimal.valueOf(10000), "S");
        BankAccount creditAcc = new CreditAccount("2", BigDecimal.valueOf(2000), "K");
        BankAccount savingAcc = new SavingsAccount("3", BigDecimal.valueOf(8000), "F");
        accounts.add(debitAcc);
        accounts.add(creditAcc);
        accounts.add(savingAcc);
        processor = new TransactionProcessor();
    }

    @Test
    void processTransactionTest1() {
        processor.processTransaction(accounts, BigDecimal.valueOf(200));
        assertEquals(BigDecimal.valueOf(9800), accounts.get(0).getBalance());
        assertEquals(BigDecimal.valueOf(1800), accounts.get(1).getBalance());
        assertEquals(BigDecimal.valueOf(7800), accounts.get(2).getBalance());
    }
}