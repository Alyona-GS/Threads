import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SimpleConditionExample {

    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private boolean ready = false;

    public static void main(String[] args) {
        SimpleConditionExample example = new SimpleConditionExample();

        // Поток, который ждет условия
        Thread waitingThread = new Thread(() -> {
            example.waitForCondition();
            System.out.println("Condition met, proceeding...");
        });

        // Поток, который изменяет условие
        Thread signalingThread = new Thread(() -> {
            example.signalCondition();
        });

        waitingThread.start();
        signalingThread.start();
    }

    public void waitForCondition() {
        lock.lock();
        try {
            while (!ready) {
                System.out.println("Waiting for condition...");
                condition.await(); // Ожидание, пока условие станет истинным
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void signalCondition() {
        lock.lock();
        try {
            ready = true;
            condition.signal(); // Уведомление, что условие выполнено
            System.out.println("Condition signaled.");
        } finally {
            lock.unlock();
        }
    }
}