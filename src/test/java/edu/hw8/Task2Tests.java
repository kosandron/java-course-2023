package edu.hw8;

import edu.hw8.Task2.FixedThreadPool;
import edu.hw8.Task2.ThreadPool;
import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Tests {
    @Test
    @DisplayName("Fibonacci calculate test")
    public void fibonacciCalculatorTest() {
        int threadPoolThreadsCount = 4;
        int[] fibonacciArray = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55};

        int startThreadCount = Thread.activeCount();
        try (ThreadPool threadPool = FixedThreadPool.create(threadPoolThreadsCount)) {
            threadPool.start();

            for (int i = 0; i < fibonacciArray.length; i++) {
                final int number = i;
                threadPool.execute(() -> {
                    int result = calculateFibonacci(number);
                    assertThat(result).isEqualTo(fibonacciArray[number]);
                });
            }

            assertEquals(Thread.activeCount(),startThreadCount + threadPoolThreadsCount);
        } catch (Exception e) {
            LogManager.getLogger().error(e.getMessage());
        }
    }

    private int calculateFibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return calculateFibonacci(n - 1) + calculateFibonacci(n - 2);
        }
    }
}
