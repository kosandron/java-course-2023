package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    @Test
    @DisplayName("Тест 1: 100")
    void Test1() {
        // Arrange
        int number = 100;

        // Act
        int timeInSeconds = Task2.countDigits(number);

        // Assert
        assertThat(timeInSeconds)
            .isEqualTo(3);
    }

    @Test
    @DisplayName("Тест 2: 3")
    void Test2() {
        // Arrange
        int number = 3;

        // Act
        int timeInSeconds = Task2.countDigits(number);

        // Assert
        assertThat(timeInSeconds)
            .isEqualTo(1);
    }

    @Test
    @DisplayName("Тест 3: 0")
    void Test3() {
        // Arrange
        int number = 3;

        // Act
        int timeInSeconds = Task2.countDigits(number);

        // Assert
        assertThat(timeInSeconds)
            .isEqualTo(1);
    }

    @Test
    @DisplayName("Тест 4: -2234")
    void Test4() {
        // Arrange
        int number = -2234;

        // Act
        int timeInSeconds = Task2.countDigits(number);

        // Assert
        assertThat(timeInSeconds)
            .isEqualTo(4);
    }

    @Test
    @DisplayName("Тест 5: -3")
    void Test5() {
        // Arrange
        int number = -3;

        // Act
        int timeInSeconds = Task2.countDigits(number);

        // Assert
        assertThat(timeInSeconds)
            .isEqualTo(1);
    }
}
