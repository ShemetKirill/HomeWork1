public class CreditAccount extends BankAccount implements ITransactionFee, TransactionValidator {

    public static  final double CREDIT_LIMIT=-5000;
    public static final double PERCENT_COMISSION=0.01;
    public static final double LIMIT_TRANSACTION=5000;

    public CreditAccount(String accountNumber, double balance, String accountHolder) {
        super(accountNumber, balance, accountHolder);
    }

    @Override
    public void withdraw(double ammount) {
        if(isValidate(ammount)){
            if(isChekedBalance(balance)&&(balance-ammount>CREDIT_LIMIT)){
                balance= (balance-ammount);
                System.out.printf("коммисия составила = %.2f \n", applyFee(ammount));
            }
            else {
                System.out.println("Недостаточно средств на балансе");
            }

        }
        else{
            System.out.printf("Невозможно выполнить транкзакцию, допустимая сумма = %.2f \n", LIMIT_TRANSACTION);
        }
    }

    @Override
    public boolean isChekedBalance(double balanse) {
        return balanse>CREDIT_LIMIT;
    }

    @Override
    public double applyFee(double ammount) {
        return  ammount*PERCENT_COMISSION;
    }

    @Override
    public boolean isValidate(double ammount) {
        return ammount<=LIMIT_TRANSACTION;
    }
}
