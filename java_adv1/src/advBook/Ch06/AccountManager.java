package advBook.Ch06;

import advBook.Ch06.TransferTask;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class AccountManager {
    private final ConcurrentHashMap<Integer, Account> accounts = new ConcurrentHashMap<>();
    private volatile boolean shutdown = false;

    private final BlockingQueue<TransferTask> pending = new LinkedBlockingQueue<>();
    private final BlockingQueue<TransferTask> forDeposit = new LinkedBlockingQueue<>();
    private final BlockingQueue<TransferTask> failed = new LinkedBlockingQueue<>();

    private Thread withdrawals;
    private Thread deposits;

    public void init() {

        // 입금 스레드
        Runnable withdraw = () -> {
            boolean interrupted = false;

            while (!interrupted || !pending.isEmpty()) {
                try {
                    var task = pending.poll(5, TimeUnit.SECONDS);

                    if(task == null) {
                        continue;
                    }

                    var sender = task.sender();
                    if (sender.withdraw(task.amount())) {
                        forDeposit.add(task);
                    } else {
                        failed.add(task);
                    }
                } catch (InterruptedException e) {
                    interrupted = true;
                }
            }
            deposits.interrupt();
        };

        // 출금 스레드
        Runnable deposit = () -> {
            boolean interrupted = false;
            while (!interrupted || !forDeposit.isEmpty()) {
                try {
                    var task = forDeposit.take();
                    var receiver = task.receiver();
                    receiver.deposit(task.amount());
                } catch (InterruptedException e) {
                    interrupted = true;
                }
            }
        };

        init(withdraw, deposit);
    }

    void init(Runnable withdraw, Runnable deposit) {
        withdrawals = new Thread(withdraw);
        deposits = new Thread(deposit);
        withdrawals.start();
        deposits.start();
    }

    public Account createAccount(int balance) {
        var out = new Account(balance);
        accounts.put(out.getAccountId(), out);
        return out;
    }

    public boolean submit(TransferTask transfer) {
        // shutdown 시작된 후에는 작업을 더 이상 받아들이지 않습니다.
        // 이 문제를 적절히 처리하지 않으면 트랜잭션이 누락될 수 있습니다.
        if (shutdown) {
            return false;
        }
        return pending.add(transfer);
    }

    public void await() throws InterruptedException {
        withdrawals.join();
        deposits.join();
    }

    public void shutdown() {
        // shutdown을 true로 설정하지만 스레드를 즉시 중단하거나 큐를 비우지는 않습니다.
        shutdown = true;
    }
}