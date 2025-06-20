//не работает, хотя везде пишут
public class ProgramLambda {
    public static void main(String[] args) {
        Thread thr1 = new Thread(() -> {
            for (int i = 2; i <= 10; i+=2) {
                System.out.println(i);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread thr2 = new Thread(() -> {
            for (int p = 1; p <= 9; p+=2) {
                System.out.println(p);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thr1.start();
        thr2.start();
    }
}
