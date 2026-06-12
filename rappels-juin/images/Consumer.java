package images;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    private final BlockingQueue<Image> queue;
    private final BlockingQueue<Image> result;

    public Consumer(BlockingQueue<Image> queue, BlockingQueue<Image> result) {
        this.queue = queue;
        this.result = result;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Image image = this.queue.take();

                System.out.println("Traitement de l'image " + image.getId() + " en cours ...");

                this.process(image);
                this.result.add(image);
            }

            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }

        System.out.printf("Consumer arrêté car erreur !");
    }

    private void process(Image image) {
        try {
            Thread.sleep(10_000 + (long) (Math.random() * 5_000));

            System.out.println("Traitement de l'image " + image.getId() + " terminé !");
        }

        catch (InterruptedException e) {
            System.out.println("Erreur pendant le traitement de l'image " + image.getId() + " !");
        }
    }
}
