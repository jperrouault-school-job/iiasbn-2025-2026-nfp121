package images;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class ImageApplication {
    private static final int PRODUCERS = 2;
    private static final int CONSUMERS = 15;

    public static void main(String[] args) throws Exception {
        BlockingQueue<Image> queue = new ArrayBlockingQueue<>(20);
        BlockingQueue<Image> result = new LinkedBlockingQueue<>();
        ExecutorService consumerPool = Executors.newFixedThreadPool(CONSUMERS);
        ExecutorService producerPool = Executors.newFixedThreadPool(PRODUCERS);

        for (int i = 0; i < CONSUMERS; i++) {
            consumerPool.submit(new Consumer(queue, result));
        }

        for (int i = 0; i < PRODUCERS; i++) {
            producerPool.submit(new Producer(queue));
        }
    }
}
