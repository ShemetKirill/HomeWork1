public class DebitAccount extends BankAccount implements TransactionValidator{

    public static final double LIMIT_TRANSACTION=10000;

    public DebitAccount(String accountNumber, double balance, String accountHolder) {
        super(accountNumber, balance, accountHolder);
    }

    @Override
    public void withdraw(double ammount) {
        if(isValidate(ammount)){
            if(isChekedBalance(balance)&&balance>ammount) {
                balance-=ammount;
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
        return balanse>0;
    }

    @Override
    public boolean isValidate(double ammount) {
        return ammount<=LIMIT_TRANSACTION;
    }
}
