package edu.hw7.Task4;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ManyThreadsCalculator {
    private final static double SQUARE_SIDE_LENGTH = 1;
    private final static double CIRCLE_CENTER = SQUARE_SIDE_LENGTH / 2;
    private final static double CIRCLE_RADIUS = SQUARE_SIDE_LENGTH / 2;
    private final static int FACTOR_OF_THE_PI_FORMULA = 4;

    private ManyThreadsCalculator() { }

    public static double calculate(int pointsCount, int threadsCount) {
        SecureRandom random = new SecureRandom();
        AtomicInteger totalCount = new AtomicInteger(0);
        AtomicInteger circleCount = new AtomicInteger(0);
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < threadsCount; i++) {
            Thread thread = new Thread(() -> {
                double x;
                double y;
                while (totalCount.get() < pointsCount) {
                    x = random.nextDouble(0, SQUARE_SIDE_LENGTH);
                    y = random.nextDouble(0, SQUARE_SIDE_LENGTH);
                    if (isInCircle(x, y)) {
                        circleCount.incrementAndGet();
                    }
                    totalCount.incrementAndGet();
                }
            });
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
        return FACTOR_OF_THE_PI_FORMULA * ((double) circleCount.get() / (double) totalCount.get());
    }

    private static boolean isInCircle(double x, double y) {
        return Math.pow(CIRCLE_CENTER - x, 2) + Math.pow(CIRCLE_CENTER - y, 2) <= CIRCLE_RADIUS * CIRCLE_RADIUS;
    }
}
