package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        // Arrange
        int number = 11211230;

        // Act
        boolean currentAnswer = Task5.isPalindromeDescendant(number);

        // Assert
        assertThat(currentAnswer)
            .isEqualTo(true);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        // Arrange
        int number = 13001120;

        // Act
        boolean currentAnswer = Task5.isPalindromeDescendant(number);

        // Assert
        assertThat(currentAnswer)
            .isEqualTo(true);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        // Arrange
        int number = 23336014;

        // Act
        boolean currentAnswer = Task5.isPalindromeDescendant(number);

        // Assert
        assertThat(currentAnswer)
            .isEqualTo(true);
    }

    @Test
    @DisplayName("Test 4")
    void test4() {
        // Arrange
        int number = 11;

        // Act
        boolean currentAnswer = Task5.isPalindromeDescendant(number);

        // Assert
        assertThat(currentAnswer)
            .isEqualTo(true);
    }

    @Test
    @DisplayName("Test 5: 32455 -> 595")
    void test5() {
        // Arrange
        int number = 32455;

        // Act
        boolean currentAnswer = Task5.isPalindromeDescendant(number);

        // Assert
        assertThat(currentAnswer)
            .isEqualTo(true);
    }

    @Test
    @DisplayName("Test 6")
    void test6() {
        // Arrange
        int number = 32456;

        // Act
        boolean currentAnswer = Task5.isPalindromeDescendant(number);

        // Assert
        assertThat(currentAnswer)
            .isEqualTo(true);
    }

    @Test
    @DisplayName("Test 7")
    void test7() {
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
    void big_sum_test() {
        // Arrange
        int number = 325632;

        // Act
        boolean currentAnswer = Task5.isPalindromeDescendant(number);

        // Assert
        assertThat(currentAnswer)
            .isEqualTo(true);
    }

    @Test
    @DisplayName("Test 9: 1")
    void one_digit_test() {
        // Arrange
        int number = 1;

        // Act
        boolean currentAnswer = Task5.isPalindromeDescendant(number);

        // Assert
        assertThat(currentAnswer)
            .isEqualTo(false);
    }

    @Test
    @DisplayName("Test 10")
    void test10() {
        // Arrange
        int number = 1345;

        // Act
        boolean currentAnswer = Task5.isPalindromeDescendant(number);

        // Assert
        assertThat(currentAnswer)
            .isEqualTo(false);
    }
}
