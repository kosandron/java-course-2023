package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    @Test
    @DisplayName("Тест: 100")
    void hundredValueTest() {
        // Arrange
        int number = 100;

        // Act
        int timeInSeconds = Task2.countDigits(number);

        // Assert
        assertThat(timeInSeconds)
            .isEqualTo(3);
    }

    @Test
    @DisplayName("Тест: 3 - one digit")
    void oneDigitNumberTest() {
        // Arrange
        int number = 3;

        // Act
        int timeInSeconds = Task2.countDigits(number);

        // Assert
        assertThat(timeInSeconds)
            .isEqualTo(1);
    }

    @Test
    @DisplayName("Тест: 0 - null")
    void nullValueTest() {
        // Arrange
        int number = 0;

        // Act
        int timeInSeconds = Task2.countDigits(number);

        // Assert
        assertThat(timeInSeconds)
            .isEqualTo(1);
    }

    @Test
    @DisplayName("Тест: -2234 - negative number")
    void negativeNumberTest() {
        // Arrange
        int number = -2234;

        // Act
        int timeInSeconds = Task2.countDigits(number);

        // Assert
        assertThat(timeInSeconds)
            .isEqualTo(4);
    }

    @Test
    @DisplayName("Тест: -3 - negative one-digit number")
    void negativeNumberOneDigitTest() {
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
    void minusNullValueTest() {
        // Arrange
        int number = -0;

        // Act
        int timeInSeconds = Task2.countDigits(number);

        // Assert
        assertThat(timeInSeconds)
            .isEqualTo(1);
    }
}
