import java.math.BigDecimal;

public class DebitAccount extends BankAccount implements TransactionValidator {

    public static final BigDecimal LIMIT_TRANSACTION =  new BigDecimal("10000");

    public DebitAccount(String accountNumber, BigDecimal balance, String accountHolder) {
        super(accountNumber, balance, accountHolder);
    }

    @Override
    public void withdraw(BigDecimal ammount) {
        if (isValid(ammount)) {
            if (isValidBalance(balance) && ((balance.subtract(ammount)).compareTo(BigDecimal.ZERO) >=0 )) {
                balance=balance.subtract(ammount);
            } else {
                System.out.println("Недостаточно средств на балансе");
            }
        } else {
            System.out.printf("Невозможно выполнить транкзакцию, допустимая сумма = %.2f \n", LIMIT_TRANSACTION);
        }
    }

    @Override
    public boolean isValidBalance(BigDecimal balanse) {
        return (balanse.compareTo(BigDecimal.ZERO))>0;
    }

    @Override
    public boolean isValid(BigDecimal ammount) {
        return ammount.compareTo(LIMIT_TRANSACTION) < 0;
    }
}
