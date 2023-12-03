package edu.hw8.Task2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class FixedThreadPool implements ThreadPool {
    private final int threadsCount;
    private final BlockingQueue<Runnable> queue;
    private final Thread[] threads;

    public FixedThreadPool(int threadsCount) {
        if (threadsCount < 1) {
            throw new IllegalArgumentException("Count of threads is too small!");
        }

        this.threadsCount = threadsCount;
        queue = new LinkedBlockingQueue<>();
        threads = new Thread[threadsCount];
    }

    public static FixedThreadPool create(int threadsCount) {
        return new FixedThreadPool(threadsCount);
    }

    @Override
    public void start() {
        for (int i = 0; i < threadsCount; i++) {
            threads[i] = new Thread(() -> {
                while (true) {
                    try {
                        queue.take().run();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
            });
            threads[i].start();
        }
    }

    @Override
    public void execute(Runnable runnable) {
        try {
            queue.put(runnable);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void close() {
        for (Thread thread : threads) {
            thread.interrupt();
        }
    }
}
