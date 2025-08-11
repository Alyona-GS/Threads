public class ThreadLocals {
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            threadLocal.set("Data stream 1");
            System.out.println(Thread.currentThread().getName() + ": " + threadLocal.get());
        });

        Thread thread2 = new Thread(() -> {
            threadLocal.set("Data stream 2");
            System.out.println(Thread.currentThread().getName() + ": " + threadLocal.get());
        });

        thread1.start();
        thread2.start();
    }
}
