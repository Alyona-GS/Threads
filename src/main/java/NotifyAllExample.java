public class NotifyAllExample {

    private static final Object lock = new Object();

    public static void main(String[] args) {
        Runnable waitingTask = () -> {
            synchronized (lock) {
                try {
                    System.out.println(Thread.currentThread().getName() + " is waiting...");
                    lock.wait(); // Поток ждет уведомления
                    System.out.println(Thread.currentThread().getName() + " is notified!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread waitingThread1 = new Thread(waitingTask);
        Thread waitingThread2 = new Thread(waitingTask);

        waitingThread1.start();
        waitingThread2.start();

        try {
            Thread.sleep(1000); // Даем время для запуска ожидания
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (lock) {
            lock.notifyAll(); // Уведомляем все потоки
        }
    }
}