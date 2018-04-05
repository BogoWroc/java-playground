package pl.zebek.threads;

import java.util.Deque;

/**
 * Created by Bogumil Zebek on 05.04.18.
 */
public class Producer implements Runnable {

    private final Deque<String> queue;
    private final int size;

    public Producer(Deque<String> queue, int size) {
        this.queue = queue;
        this.size = size;
    }

    @Override
    public void run() {
        for (int i = 0; i < 7; i++) {
            try {
                produce(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void produce(final int number) throws InterruptedException {
        synchronized (queue) {
            if (queue.size() == size) {
                System.out.println(
                        String.format("Queue is full %s is waiting , size: %d",
                                Thread.currentThread().getName(), queue.size())
                );

                queue.wait();
            }
        }

        synchronized (queue) {
            String message = String.format("Message %d", number);
            System.out.println("Produce: " + message);
            queue.add(message);
            queue.notifyAll();
        }
    }
}
