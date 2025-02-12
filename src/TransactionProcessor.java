import java.math.BigDecimal;
import java.util.List;

public class TransactionProcessor {
    public void processTransaction(List<BankAccount> accounts, BigDecimal ammount) {
        for (BankAccount account : accounts) {
            account.withdraw(ammount);
            System.out.println(account.getBalance());
        }
    }
}
