package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task7Test {
    @Test
    @DisplayName("Test 1")
    void Test1() {
        // Arrange
        int number = 8;
        int k = 1;

        // Act
        int currentAnswer = Task7.rotateRight(number, k);

        // Assert
        assertThat(currentAnswer)
            .isEqualTo(4);
    }

    @Test
    @DisplayName("Test 2")
    void Test2() {
        // Arrange
        int number = 16;
        int k = 1;

        // Act
        int currentAnswer = Task7.rotateLeft(number, k);

        // Assert
        assertThat(currentAnswer)
            .isEqualTo(1);
    }

    @Test
    @DisplayName("Test 3")
    void Test3() {
        // Arrange
        int number = 17;
        int k = 2;

        // Act
        int currentAnswer = Task7.rotateLeft(number, k);

        // Assert
        assertThat(currentAnswer)
            .isEqualTo(6);
    }

    @Test
    @DisplayName("Test 4")
    void Test4() {
        // Arrange
        int number = 1;
        int k = 2;

        // Act
        int currentAnswer = Task7.rotateLeft(number, k);

        // Assert
        assertThat(currentAnswer)
            .isEqualTo(1);
    }

    @Test
    @DisplayName("Test 5")
    void Test5() {
        // Arrange
        int number = 3;
        int k = 3;

        // Act
        int currentAnswer = Task7.rotateLeft(number, k);

        // Assert
        assertThat(currentAnswer)
            .isEqualTo(3);
    }

    @Test
    @DisplayName("Test 6")
    void Test6() {
        // Arrange
        int number = 17;
        int k = -3;

        // Act
        int currentAnswer = Task7.rotateLeft(number, k);

        // Assert
        assertThat(currentAnswer)
            .isEqualTo(6);
    }

    @Test
    @DisplayName("Test 7")
    void Test7() {
        // Arrange
        int number = 17;
        int k = -2;

        // Act
        int currentAnswer = Task7.rotateRight(number, k);

        // Assert
        assertThat(currentAnswer)
            .isEqualTo(6);
    }

    @Test
    @DisplayName("Test 8")
    void Test8() {
        // Arrange
        int number = 0;
        int k = 2;

        // Act
        int currentAnswer = Task7.rotateRight(number, k);

        // Assert
        assertThat(currentAnswer)
            .isEqualTo(0);
    }

    @Test
    @DisplayName("Test 9")
    void Test9() {
        // Arrange
        int number = 15;
        int k = 2;

        // Act
        int currentAnswer = Task7.rotateRight(number, k);

        // Assert
        assertThat(currentAnswer)
            .isEqualTo(15);
    }
}
