import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class TransactionProcessor {
    public void processTransaction(List<BankAccount> accounts, BigDecimal ammount) {
        for (BankAccount account : accounts) {
            account.withdraw(ammount);
            System.out.println(account.getBalance());
        }
    }
}
