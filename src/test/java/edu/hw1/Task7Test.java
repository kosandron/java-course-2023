package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task7Test {
    @Test
    @DisplayName("Test: rotate right 8 to 1 step")
    void rotateRightExampleTest() {
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
    @DisplayName("Test: rotate left 16 to 1 step")
    void rotateLeftExampleOneTest() {
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
    @DisplayName("Test: rotate left 17 to 2 steps")
    void rotateLeftExampleTwoTest() {
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
    @DisplayName("Test: number 1 and a lot of steps, rotate left")
    void oneDigitNumberAndALotOfSteps() {
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
    @DisplayName("Test: number is equal steps, small number")
    void ThreeAndThreeNoChangesTest() {
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
    @DisplayName("Test: negative steps in rotateLeft")
    void negativeStepsRotateLeftTest() {
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
    @DisplayName("Test: negative steps in rotateRight")
    void negativeStepsRotateRightTest() {
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
    @DisplayName("Test: rotate null")
    void nullAndRotate() {
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
    @DisplayName("Test: rotate 15 right to 2 steps")
    void easyRotateRightTest() {
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
