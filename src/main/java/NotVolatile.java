class Worker {
    private boolean running = true;

    public void stop() {
        System.out.println("Попытка остановить поток...");
        running = false;
    }

    public void doWork() {
        while (running) {
            System.out.println("Работаю...");
            for (int i = 0; i < 1_000_000; i++) {
                Math.sqrt(i);
            }
        }
        System.out.println("Поток завершил работу!");
    }
}

public class NotVolatile {
    public static void main(String[] args) throws InterruptedException {
        Worker worker = new Worker();
        Thread thread = new Thread(worker::doWork);
        thread.start();

        Thread.sleep(2000);
        worker.stop();
        thread.join();

    }
}
