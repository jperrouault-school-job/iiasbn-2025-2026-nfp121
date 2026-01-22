public class Application {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(1_000);
            }

            catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName());
        });

        Thread t2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        });

        t1.start();
        t2.start();

        System.out.println(Thread.currentThread().getName());
    }
}
