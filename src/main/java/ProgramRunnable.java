public class ProgramRunnable {
    public static void main(String... args) {
        new Thread(new NumberPrinter(1), "OddThread").start();
        new Thread(new NumberPrinter(2), "EvenThread").start();
    }
}

    class NumberPrinter implements Runnable {
        private final int start;

        public NumberPrinter(int start) {
            this.start = start;
        }

        @Override
        public void run() {
            for (int i = start; i <= 10; i += 2) {
                System.out.println(i + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
