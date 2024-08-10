package thread.async;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

public class BankAccountV4 implements BankAccount {

    private int balance;

    private final Lock lock = new ReentrantLock();

    public BankAccountV4(int balance) {
        this.balance = balance;
    }

    @Override
    public boolean withdraw(int amount) {
        log("거래 시작: " + getClass().getSimpleName());
        // 잔고가 출금액 보다 적으면, 진행하면 안됨

        lock.lock(); // ReentratLock 사용
        try{
            // === 임계 영역 시작 ===
            log("[검증 시작] 출금액: " + amount + ", 잔액: " + balance);
            if (balance < amount) {
                log("[검증 실패] 출금액: " + amount + ", 잔액: " + balance);
                return false;
            }

            // 잔고가 출금액 보다 많으면, 진행
            log("[검증 완료] 출금액: " + amount + ", 잔액: " + balance);
            sleep(1000); // 출금시간
            balance -= amount;
            log("[출금 완료] 출금액: " + amount + ", 잔액: " + balance);
            // === 임계 영역 종료 ===
        } finally {
            lock.unlock();
        }

        log("거래 종료");

        return true;
    }

    @Override
    public synchronized int getBalance() {
        return balance;
    }
}
