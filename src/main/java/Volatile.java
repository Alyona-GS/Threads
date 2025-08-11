class Worker2 {
    private boolean running = true;

    public void stop() {
        System.out.println("Попытка остановить поток...");
        running = false;
    }

    public void doWork() {
        while (running) {
            System.out.println("Работаю...");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println("Поток прерван");
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Поток завершил работу!");
    }
}

public class Volatile {
    public static void main(String[] args) throws InterruptedException {
        Worker worker = new Worker();
        Thread thread = new Thread(worker::doWork);
        thread.start();

        Thread.sleep(2000);
        worker.stop();
        thread.join();
    }
}