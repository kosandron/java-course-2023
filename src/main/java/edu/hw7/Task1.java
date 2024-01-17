package edu.hw7;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class Task1 {

    private Task1() {
    }

    public static int increaseCounter(int threadsCount) {
        AtomicInteger counter = new AtomicInteger(0);
        List<Thread> threads = new ArrayList<>(threadsCount);

        for (int i = 0; i < threadsCount; i++) {
            Thread thread = new Thread(counter::incrementAndGet);
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        return counter.get();
    }
}
