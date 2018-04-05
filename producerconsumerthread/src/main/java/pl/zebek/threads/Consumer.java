package pl.zebek.threads;

import java.util.Deque;

/**
 * Created by Bogumil Zebek on 05.04.18.
 */
public class Consumer implements Runnable {

    private final Deque<String> queue;

    public Consumer(Deque<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println(String.format("Consume: %s", consume()));
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String consume() throws InterruptedException {
        synchronized (queue) {
            if (queue.isEmpty()) {
                System.out.println(
                        String.format("Queue is empty. %s will wait for new payload.", Thread.currentThread().getName())
                );

                queue.wait();
            }
        }

        synchronized (queue) {
            queue.notifyAll();
            return queue.removeFirst();
        }
    }
}
