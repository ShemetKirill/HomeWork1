import java.math.BigDecimal;

public abstract class BankAccount {
    protected String accountNumber;
    protected BigDecimal balance;
    protected String accountHolder;

    public String getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public BankAccount(String accountNumber, BigDecimal balance, String accountHolder) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountHolder = accountHolder;
    }

    public abstract void withdraw(BigDecimal ammount);

    public void deposit(BigDecimal ammount) {
        balance = balance.add(ammount);
        System.out.printf("Пополнение на сумму: %.2f прошло успешно\n", ammount);
    }

    public abstract boolean isValidBalance(BigDecimal balanse);
}
