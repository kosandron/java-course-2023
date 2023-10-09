package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task8Test {
    @Test
    @DisplayName("Test: 1st example")
    void exampleOneTest() {
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
    @DisplayName("Test: 2st example")
    void exampleTwoTest() {
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
    @DisplayName("Test: 3st example")
    void exampleThreeTest() {
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
    @DisplayName("Test: two figure")
    void twoFigureTest1() {
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
    @DisplayName("Test: 2 figure")
    void twoFigureTest2() {
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
    @DisplayName("Test: bad position and a lot of figures")
    void badPositionAndALotOfFigures() {
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
    @DisplayName("Test: gut position and a lot of figures")
    void gutPositionAndALotOfFigures() {
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

    @Test
    @DisplayName("Test: one figure")
    void oneFigureTest() {
        // Arrange
        int[][] field = new int[][] {
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0}};

        // Act
        boolean currentAnswer = Task8.knightBoardCapture(field);

        // Assert
        assertThat(currentAnswer)
            .isEqualTo(true);
    }

    @Test
    @DisplayName("Test: 0 figure")
    void noOneFigureTest() {
        // Arrange
        int[][] field = new int[][] {
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0}};

        // Act
        boolean currentAnswer = Task8.knightBoardCapture(field);

        // Assert
        assertThat(currentAnswer)
            .isEqualTo(true);
    }

    @Test
    @DisplayName("Test: all figure")
    void allFigureTest() {
        // Arrange
        int[][] field = new int[][] {
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1}};

        // Act
        boolean currentAnswer = Task8.knightBoardCapture(field);

        // Assert
        assertThat(currentAnswer)
            .isEqualTo(false);
    }
}
