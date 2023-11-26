package edu.hw7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task1Tests {
    @Test
    @DisplayName("1 thread")
    public void increaseOneThreadTest() {
        int threadsCount = 1;

        int counter = Task1.increaseCounter(threadsCount);

        assertThat(counter).isEqualTo(threadsCount);
    }

    @Test
    @DisplayName("Many threads")
    public void increaseManyThreadsTest() {
        int threadsCount = 4;

        int counter = Task1.increaseCounter(threadsCount);

        assertThat(counter).isEqualTo(threadsCount);
    }
}
