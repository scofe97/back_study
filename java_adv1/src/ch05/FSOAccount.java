package ch05;

public class FSOAccount {
    private double balance;

    public FSOAccount(double openingBalance) {
        balance = openingBalance;
    }

    public synchronized boolean withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public synchronized void deposit(int amount) {
        balance += amount;
    }

    public synchronized double getBalance() {
        return balance;
    }

    public synchronized boolean transferTo(FSOAccount other, int amount) {
        try{
            Thread.sleep(10);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        if (balance >= amount) {
            balance -= amount;
            other.deposit(amount); // 다른 계좌로 송금
            return true;
        }
        return false;
    }
}
