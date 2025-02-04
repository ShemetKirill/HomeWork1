public class SavingsAccount extends BankAccount implements IInterestBearing{

    public static final double PERCENT_INTEREST=0.12;
    public SavingsAccount(String accountNumber, double balance, String accountHolder) {
        super(accountNumber, balance, accountHolder);
    }

    @Override
    public void withdraw(double ammount) {
        if(isChekedBalance(balance)&&balance>=ammount) {
            balance-=ammount;
        }
        else {
            System.out.println("Недостаточно средств на балансе");
        }
    }

    @Override
    public void deposit(double ammount) {
        super.deposit(ammount);
    }

    @Override
    public boolean isChekedBalance(double balanse) {
        return balanse>0;
    }

    @Override
    public void applyInterest() {
        balance+=(balance*PERCENT_INTEREST)/12;
    }
}
