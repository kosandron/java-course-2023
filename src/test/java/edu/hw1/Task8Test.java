package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task8Test {
    @Test
    @DisplayName("Test 1")
    void Test1() {
        // Arrange
        int[][] field = new int[][] {
            {0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 1, 0, 0, 0}};

        // Act
        boolean currentAnswer = Task8.knightBoardCapture(field);

        // Assert
        assertThat(currentAnswer)
            .isEqualTo(true);
    }

    @Test
    @DisplayName("Test 2")
    void Test2() {
        // Arrange
        int[][] field = new int[][] {
            {1, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 1, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0, 1, 0, 1}};

        // Act
        boolean currentAnswer = Task8.knightBoardCapture(field);

        // Assert
        assertThat(currentAnswer)
            .isEqualTo(false);
    }

    @Test
    @DisplayName("Test 3")
    void Test3() {
        // Arrange
        int[][] field = new int[][] {
            {0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0}};

        // Act
        boolean currentAnswer = Task8.knightBoardCapture(field);

        // Assert
        assertThat(currentAnswer)
            .isEqualTo(false);
    }

    @Test
    @DisplayName("Test 4")
    void Test4() {
        // Arrange
        int[][] field = new int[][] {
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0}};

        // Act
        boolean currentAnswer = Task8.knightBoardCapture(field);

        // Assert
        assertThat(currentAnswer)
            .isEqualTo(false);
    }

    @Test
    @DisplayName("Test 5")
    void Test5() {
        // Arrange
        int[][] field = new int[][] {
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0}};

        // Act
        boolean currentAnswer = Task8.knightBoardCapture(field);

        // Assert
        assertThat(currentAnswer)
            .isEqualTo(false);
    }

    @Test
    @DisplayName("Test 6")
    void Test6() {
        // Arrange
        int[][] field = new int[][] {
            {0, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 0},
            {1, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 1, 0, 0}};

        // Act
        boolean currentAnswer = Task8.knightBoardCapture(field);

        // Assert
        assertThat(currentAnswer)
            .isEqualTo(false);
    }

    @Test
    @DisplayName("Test 7")
    void Test7() {
        // Arrange
        int[][] field = new int[][] {
            {0, 0, 1, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {1, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 1, 0},
            {1, 0, 0, 0, 0, 1, 0, 1},
            {0, 1, 0, 0, 0, 0, 1, 0},
            {1, 0, 0, 0, 0, 1, 0, 0}};

        // Act
        boolean currentAnswer = Task8.knightBoardCapture(field);

        // Assert
        assertThat(currentAnswer)
            .isEqualTo(true);
    }
}
