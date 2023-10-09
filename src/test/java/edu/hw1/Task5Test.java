package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {
    @Test
    @DisplayName("Test: 11211230")
    void randomTestOne() {
        // Arrange
        int number = 11211230;

        // Act
        boolean currentAnswer = Task5.isPalindromeDescendant(number);

        // Assert
        assertThat(currentAnswer)
            .isEqualTo(true);
    }

    @Test
    @DisplayName("Test: 13001120")
    void randomTestTwo() {
        // Arrange
        int number = 13001120;

        // Act
        boolean currentAnswer = Task5.isPalindromeDescendant(number);

        // Assert
        assertThat(currentAnswer)
            .isEqualTo(true);
    }

    @Test
    @DisplayName("Test: 23336014")
    void randomTestThree() {
        // Arrange
        int number = 23336014;

        // Act
        boolean currentAnswer = Task5.isPalindromeDescendant(number);

        // Assert
        assertThat(currentAnswer)
            .isEqualTo(true);
    }

    @Test
    @DisplayName("Test: 11")
    void isPalindromeAtBeginTest() {
        // Arrange
        int number = 11;

        // Act
        boolean currentAnswer = Task5.isPalindromeDescendant(number);

        // Assert
        assertThat(currentAnswer)
            .isEqualTo(true);
    }

    @Test
    @DisplayName("Test: 32455 -> 595")
    void rightOrderOfSumOfDigitsTest() {
        // Arrange
        int number = 32455;

        // Act
        boolean currentAnswer = Task5.isPalindromeDescendant(number);

        // Assert
        assertThat(currentAnswer)
            .isEqualTo(true);
    }

    @Test
    @DisplayName("Test: 32456")
    void randomTestFour() {
        // Arrange
        int number = 32456;

        // Act
        boolean currentAnswer = Task5.isPalindromeDescendant(number);

        // Assert
        assertThat(currentAnswer)
            .isEqualTo(true);
    }

    @Test
    @DisplayName("Test: 32457")
    void randomTestFive() {
        // Arrange
        int number = 32457;

        // Act
        boolean currentAnswer = Task5.isPalindromeDescendant(number);

        // Assert
        assertThat(currentAnswer)
            .isEqualTo(false);
    }

    @Test
    @DisplayName("Test 8: current sum is > 9")
    void bigSumTest() {
        // Arrange
        int number = 325632;

        // Act
        boolean currentAnswer = Task5.isPalindromeDescendant(number);

        // Assert
        assertThat(currentAnswer)
            .isEqualTo(true);
    }

    @Test
    @DisplayName("Test: 1")
    void oneDigitTest() {
        // Arrange
        int number = 1;

        // Act
        boolean currentAnswer = Task5.isPalindromeDescendant(number);

        // Assert
        assertThat(currentAnswer)
            .isEqualTo(false);
    }

    @Test
    @DisplayName("Test: 1345")
    void randomTestSix() {
        // Arrange
        int number = 1345;

        // Act
        boolean currentAnswer = Task5.isPalindromeDescendant(number);

        // Assert
        assertThat(currentAnswer)
            .isEqualTo(false);
    }
}
