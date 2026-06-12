package images;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    private final BlockingQueue<Image> queue;

    public Producer(BlockingQueue<Image> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
         try {
            for (int i = 0; i < 10; i++) {
                Image image = new Image();

                Thread.sleep(1_000 + (long) (Math.random() * 1_000));

                System.out.println("Image " + image.getId() + " produite !");

                this.queue.add(image);
            }
        }

        catch (InterruptedException e) { }
    }
}
