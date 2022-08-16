import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private double balance=0;
    private String accountNumber;

    private Lock lock;

    public BankAccount(String accountNumber, double balance) {
        if (balance>0) this.balance = balance;
        this.accountNumber = accountNumber;
        this.lock=new ReentrantLock();
    }

    public void deposit(double amount){
        boolean status = false;
        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)){
                try {
                    System.out.println("Trying to deposit $"+amount+" to account "+getAccountNumber());
                    if (amount>0) {
                        balance+=amount;
                        status = true;
                        System.out.println("$"+amount+" was deposited to account "+getAccountNumber());
                        System.out.println("The deposit in account "+getAccountNumber()+" was achieved now has $"+getBalance());
                    }
                }finally {
                    lock.unlock();
                }
            }else {
                System.out.println("Could not get the lock");
            }
        }catch(InterruptedException e){
        }
        System.out.println("Transaction Status = "+status);
    }
    public void withdraw(double amount){
        boolean status = false;
        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)){
                try {
                    System.out.println("Trying to withdraw $"+amount+" to account "+getAccountNumber());
                    if (amount>0) {
                        balance-=amount;
                        status = true;
                        System.out.println("$"+amount+" was withdrawn to account "+getAccountNumber());
                        System.out.println("The deposit in account "+getAccountNumber()+" was achieved now has $"+getBalance());
                    }
                }finally {
                    lock.unlock();
                }
            }else {
                System.out.println("Could not get the lock");
            }
        }catch(InterruptedException e){
        }
        System.out.println("Transaction Status = "+status);
    }

    public double getBalance() {
        return balance;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public void printAccountNumber() {
        System.out.println("Account number = "+accountNumber);
    }
}
