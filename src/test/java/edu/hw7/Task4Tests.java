package edu.hw7;

import edu.hw7.Task4.ManyThreadsCalculator;
import edu.hw7.Task4.OneThreadCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task4Tests {
    @Test
    @DisplayName("One thread test")
    public void oneThreadTest() {
        int pointsCount = 100000;
        double maxDelta = 1;

        double result = OneThreadCalculator.calculate(pointsCount);

        assertThat(Math.abs(result - Math.PI) < maxDelta).isTrue();
    }

    @Test
    @DisplayName("Many threads test")
    public void manyThreadsTest() {
        int pointsCount = 100000;
        double maxDelta = 1;

        double result = ManyThreadsCalculator.calculate(pointsCount, 4);

        assertThat(Math.abs(result - Math.PI) < maxDelta).isTrue();
    }
}
