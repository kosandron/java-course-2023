package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {
    @Test
    @DisplayName("Test 1")
    void Test1() {
        // Arrange
        int number = 3524;

        // Act
        int currentAnswer = Task6.countK(number);

        // Assert
        assertThat(currentAnswer)
            .isEqualTo(3);
    }

    @Test
    @DisplayName("Test 2")
    void Test2() {
        // Arrange
        int number = 6621;

        // Act
        int currentAnswer = Task6.countK(number);

        // Assert
        assertThat(currentAnswer)
            .isEqualTo(5);
    }

    @Test
    @DisplayName("Test 3")
    void Test3() {
        // Arrange
        int number = 6554;

        // Act
        int currentAnswer = Task6.countK(number);

        // Assert
        assertThat(currentAnswer)
            .isEqualTo(4);
    }

    @Test
    @DisplayName("Test 4")
    void Test4() {
        // Arrange
        int number = 1234;

        // Act
        int currentAnswer = Task6.countK(number);

        // Assert
        assertThat(currentAnswer)
            .isEqualTo(3);
    }

    @Test
    @DisplayName("Test 5")
    void Test5() {
        // Arrange
        int number = 6174;

        // Act
        int currentAnswer = Task6.countK(number);

        // Assert
        assertThat(currentAnswer)
            .isEqualTo(0);
    }

    @Test
    @DisplayName("Test 6")
    void Test6() {
        // Arrange
        int number = 34;

        // Act
        int currentAnswer = Task6.countK(number);

        // Assert
        assertThat(currentAnswer)
            .isEqualTo(-1);
    }

    @Test
    @DisplayName("Test 7")
    void Test7() {
        // Arrange
        int number = 1001;

        // Act
        int currentAnswer = Task6.countK(number);

        // Assert
        assertThat(currentAnswer)
            .isEqualTo(4);
    }
}
