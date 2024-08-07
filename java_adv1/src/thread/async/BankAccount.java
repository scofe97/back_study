package thread.async;

public interface BankAccount {
    boolean withdraw(int amount);

    int getBalance();
}
