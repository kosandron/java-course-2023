package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    @Test
    @DisplayName("Тест 1: 100")
    void random_test1() {
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
    void one_digit_number_test2() {
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
    void null_test3() {
        // Arrange
        int number = 0;

        // Act
        int timeInSeconds = Task2.countDigits(number);

        // Assert
        assertThat(timeInSeconds)
            .isEqualTo(1);
    }

    @Test
    @DisplayName("Тест 4: -2234")
    void negative_number_random_test4() {
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
    void negative_number_one_digit_random_test5() {
        // Arrange
        int number = -3;

        // Act
        int timeInSeconds = Task2.countDigits(number);

        // Assert
        assertThat(timeInSeconds)
            .isEqualTo(1);
    }

    @Test
    @DisplayName("Тест 6: -0")
    void minus_null_test6() {
        // Arrange
        int number = -0;

        // Act
        int timeInSeconds = Task2.countDigits(number);

        // Assert
        assertThat(timeInSeconds)
            .isEqualTo(1);
    }
}
