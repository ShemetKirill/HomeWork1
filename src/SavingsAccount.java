import java.math.BigDecimal;

public class SavingsAccount extends BankAccount implements IInterestBearing {
    public static final BigDecimal PERCENT_INTEREST = BigDecimal.valueOf(0.12);

    public SavingsAccount(String accountNumber, BigDecimal balance, String accountHolder) {
        super(accountNumber, balance, accountHolder);
    }

    @Override
    public void withdraw(BigDecimal ammount) {
        if (isValidBalance(balance) && (balance.compareTo(ammount) >= 0)) {
            balance = balance.subtract(ammount);
        } else {
            System.out.println("Недостаточно средств на балансе");
        }
    }

    @Override
    public void deposit(BigDecimal ammount) {
        super.deposit(ammount);
    }

    @Override
    public boolean isValidBalance(BigDecimal balanse) {
        return balanse.compareTo(BigDecimal.ZERO) > 0;
    }

    @Override
    public void applyInterest() {
        BigDecimal interest = balance.multiply(PERCENT_INTEREST).divide(BigDecimal.valueOf(12));
        balance = balance.add(interest);
    }
}
