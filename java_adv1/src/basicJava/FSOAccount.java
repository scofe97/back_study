package basicJava;

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

        FSOAccount first = this;
        FSOAccount second = other;

        // 계좌의 해시코드를 비교해서 일관된 잠금 순서를 유지
        if (System.identityHashCode(this) > System.identityHashCode(other)) {
            first = other;
            second = this;
        }

        synchronized (first) {
            synchronized (second) {
                if (balance >= amount) {
                    balance -= amount;
                    other.deposit(amount);
                    return true;
                }
                return false;
            }
        }
    }
}
