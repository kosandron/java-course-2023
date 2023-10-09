package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {
    @Test
    @DisplayName("Test: 3524")
    void randomTestOne() {
        // Arrange
        int number = 3524;

        // Act
        int currentAnswer = Task6.countK(number);

        // Assert
        assertThat(currentAnswer)
            .isEqualTo(3); //  3524 -> 3087 -> 8352 -> 6174
    }

    @Test
    @DisplayName("Test: 6621")
    void randomTestTwo() {
        // Arrange
        int number = 6621;

        // Act
        int currentAnswer = Task6.countK(number);

        // Assert
        assertThat(currentAnswer)
            .isEqualTo(5); //  6621 -> 5355 -> 1998 -> 8082 -> 8532
    }

    @Test
    @DisplayName("Test: 6554")
    void randomTestThree() {
        // Arrange
        int number = 6554;

        // Act
        int currentAnswer = Task6.countK(number);

        // Assert
        assertThat(currentAnswer)
            .isEqualTo(4); //  6554 -> 1998 -> 8082 -> 8532 -> 6174
    }

    @Test
    @DisplayName("Test: 1234")
    void randomTestFour() {
        // Arrange
        int number = 1234;

        // Act
        int currentAnswer = Task6.countK(number);

        // Assert
        assertThat(currentAnswer)
            .isEqualTo(3); //  1234 -> 3087 -> 8352 -> 6174
    }

    @Test
    @DisplayName("Test: 6174 - answer = 0!")
    void nullAnswerTest() {
        // Arrange
        int number = 6174;

        // Act
        int currentAnswer = Task6.countK(number);

        // Assert
        assertThat(currentAnswer)
            .isEqualTo(0);
    }

    @Test
    @DisplayName("Test: small number")
    void smallNumber() {
        // Arrange
        int number = 34;

        // Act
        int currentAnswer = Task6.countK(number);

        // Assert
        assertThat(currentAnswer)
            .isEqualTo(-1);
    }

    @Test
    @DisplayName("Test: 1001")
    void lowerBoundTest() {
        // Arrange
        int number = 1001;

        // Act
        int currentAnswer = Task6.countK(number);

        // Assert
        assertThat(currentAnswer)
            .isEqualTo(4); // 1001 -> 1089 -> 9621 -> 8352 -> 6174
    }

    @Test
    @DisplayName("Test: 1111 - same digits")
    void sameDigitsTest1() {
        // Arrange
        int number = 1111;

        // Act
        int currentAnswer = Task6.countK(number);

        // Assert
        assertThat(currentAnswer)
            .isEqualTo(-1);
    }

    @Test
    @DisplayName("Test 8: 1000 - small number")
    void smallNumberTest() {
        // Arrange
        int number = 1000;

        // Act
        int currentAnswer = Task6.countK(number);

        // Assert
        assertThat(currentAnswer)
            .isEqualTo(-1);
    }

    @Test
    @DisplayName("Test 8: 9999 - same digits")
    void sameDigitsTest2() {
        // Arrange
        int number = 9999;

        // Act
        int currentAnswer = Task6.countK(number);

        // Assert
        assertThat(currentAnswer)
            .isEqualTo(-1);
    }
}
