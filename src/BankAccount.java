public  abstract class BankAccount {
    String accountNumber;
    double balance;
    String accountHolder;

    public String getAccountNumber(){
        return accountNumber;
    }
    public double getBalance() {
        return balance;
    }


    public String getAccountHolder() {
        return accountHolder;
    }

    public BankAccount( String accountNumber, double balance, String accountHolder){
        this.accountNumber=accountNumber;
        this.balance=balance;
        this.accountHolder=accountHolder;
    }

    public abstract void withdraw(double ammount);

    public void deposit (double ammount){
        balance+=ammount;
        System.out.printf("Пополнение на сумму: %.2f прошло успешно\n",ammount);
    }

    public abstract boolean isChekedBalance( double balanse);
}
