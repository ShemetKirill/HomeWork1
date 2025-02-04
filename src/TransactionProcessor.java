import java.util.List;
import java.util.Scanner;

public class TransactionProcessor {
    public void processTransaction(List<BankAccount> accounts, double ammount){
//        Scanner in = new Scanner(System.in);
        for(BankAccount account: accounts){
//            ammount=in.nextInt();
            account.withdraw(ammount);
            System.out.println(account.getBalance());
        }
    }
}
