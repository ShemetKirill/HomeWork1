import java.math.BigDecimal;

public class CreditAccount extends BankAccount implements ITransactionFee, TransactionValidator {
    public static final BigDecimal CREDIT_LIMIT = new BigDecimal("-5000");
    public static final BigDecimal PERCENT_COMISSION = BigDecimal.valueOf(0.01);
    public static final BigDecimal LIMIT_TRANSACTION = new BigDecimal("5000");

    public CreditAccount(String accountNumber, BigDecimal balance, String accountHolder) {
        super(accountNumber, balance, accountHolder);
    }

    @Override
    public void withdraw(BigDecimal ammount) {
        String errorMessage = getErrorMessage(ammount);
        if (errorMessage == null) {
            balance = balance.subtract(ammount);
            System.out.printf("Комиссия составила = %.2f \n", applyFee(ammount));
        } else {
            System.out.println(errorMessage);
        }
    }

    @Override
    public boolean isValidBalance(BigDecimal balanse) {
        return balanse.compareTo(CREDIT_LIMIT) > 0;
    }

    @Override
    public BigDecimal applyFee(BigDecimal ammount) {
        return ammount.multiply(PERCENT_COMISSION);
    }

    @Override
    public boolean isValid(BigDecimal ammount) {
        return ammount.compareTo(LIMIT_TRANSACTION) <= 0;
    }

    private String getErrorMessage(BigDecimal ammount) {
        if (!isValid(ammount)) {
            return String.format("Невозможно выполнить транзакцию, допустимая сумма = %.2f \n", LIMIT_TRANSACTION);
        } else if (!isValidBalance(balance)) {
            return "Недостаточно средств на балансе";
        } else if (balance.subtract(ammount).compareTo(CREDIT_LIMIT) <= 0) {
            return "Недостаточно средств после учета кредитного лимита";
        }
        return null;
    }
}
