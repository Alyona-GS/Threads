public class RaceConditionExample implements Runnable{

    private volatile static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        RaceConditionExample task = new RaceConditionExample();
        // Создаем два потока, которые будут инкрементировать счетчик
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        // Запускаем потоки
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();


        // Печатаем значение счетчика
        System.out.println("Final counter value: " + counter);
    }
        synchronized public void increment() {
                counter++;
            }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            //Thread.sleep(200);
            // Инкрементируем счетчик
            increment();
        }
    }
}