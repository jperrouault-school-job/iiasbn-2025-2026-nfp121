public class AtomicPointApplication {
    public static void main(String[] args) throws InterruptedException {
        AtomicPoint p = new AtomicPoint();

        Runnable task = () -> {
            for (int i = 0; i < 10_000; i++) {
                p.increment(1, 1);
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        // On attend la fin des threads
        t1.join();
        t2.join();

        System.out.println(p);
    }
}
