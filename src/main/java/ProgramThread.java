class NumberPrinter extends Thread {
    private final int start;

    public NumberPrinter(int start) {
        this.start = start;
    }

    @Override
    public void run() {
        for (int i = start; i <= 20; i += 2) {
            System.out.println(i + " from " + Thread.currentThread().getName());
            try {
                Thread.sleep(100); // Задержка для наглядности
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ProgramThread {
    public static void main(String... args) {
        Thread oddPrinter = new NumberPrinter(1); // Поток для вывода нечетных чисел
        Thread evenPrinter = new NumberPrinter(2); // Поток для вывода четных чисел

        oddPrinter.start();
        evenPrinter.start();

        System.out.println("Главный поток завершён...");
    }
}