package pl.zebek.threads;

import java.util.Deque;
import java.util.LinkedList;


public class App {
    public static void main(String[] args) {
        Deque<String> queue = new LinkedList<>();
        Thread producerThread = new Thread(new Producer(queue, 2), "Producer");
        Thread consumerThread = new Thread(new Consumer(queue), "Consumer");

        producerThread.start();
        consumerThread.start();
    }
}
