package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {
    @Test
    @DisplayName("Test: random")
    void randomTest() {
        // Arrange
        int[] a = new int[] {1, 2, 3, 4, 5};
        int[] b = new int[] {0, 2, 3, 4, 6};

        // Act
        boolean possibility = Task3.isNestable(a, b);

        // Assert
        assertThat(possibility)
            .isEqualTo(true);
    }

    @Test
    @DisplayName("Test: minA1 == minA2")
    void minesEqualTest() {
        // Arrange
        int[] a = new int[] {1, 2, 3, 4, 5};
        int[] b = new int[] {1, 2, 3, 4, 6};

        // Act
        boolean possibility = Task3.isNestable(a, b);

        // Assert
        assertThat(possibility)
            .isEqualTo(false);
    }

    @Test
    @DisplayName("Test: maxA1 == maxA2")
    void maxesEqualsTest() {
        // Arrange
        int[] a = new int[] {1, 2, 3, 4, 6};
        int[] b = new int[] {0, 2, 3, 4, 6};

        // Act
        boolean possibility = Task3.isNestable(a, b);

        // Assert
        assertThat(possibility)
            .isEqualTo(false);
    }

    @Test
    @DisplayName("Test: maxA1 == maxA2 and minA1 == minA2")
    void minEqualMinAndMaxEqualMaxTest() {
        // Arrange
        int[] a = new int[] {1, 2, 1, 3, 6};
        int[] b = new int[] {5, 1, 3, 6, 2};

        // Act
        boolean possibility = Task3.isNestable(a, b);

        // Assert
        assertThat(possibility)
            .isEqualTo(false);
    }

    @Test
    @DisplayName("Test: random shuffle")
    void randomShuffleTest() {
        // Arrange
        int[] a = new int[] {1, 4, 2, -1, 4, 43, -21};
        int[] b = new int[] {5, 3, 6, -10, 21, 34, -14, 45};

        // Act
        boolean possibility = Task3.isNestable(a, b);

        // Assert
        assertThat(possibility)
            .isEqualTo(false);
    }

    @Test
    @DisplayName("Test: big in small")
    void firstArrayIsMoreSecondTest() {
        // Arrange
        int[] a = new int[] {1, 2, 3, 4};
        int[] b = new int[] {2, 3};

        // Act
        boolean possibility = Task3.isNestable(a, b);

        // Assert
        assertThat(possibility)
            .isEqualTo(false);
    }

    @Test
    @DisplayName("Test: same numbers")
    void sameNumbersTest() {
        // Arrange
        int[] a = new int[] {9, 9, 8};
        int[] b = new int[] {8, 9};

        // Act
        boolean possibility = Task3.isNestable(a, b);

        // Assert
        assertThat(possibility)
            .isEqualTo(false);
    }

    @Test
    @DisplayName("Test: decrease sorted arrays")
    void decreaseSortedArraysTest() {
        // Arrange
        int[] a = new int[] {3, 1};
        int[] b = new int[] {4, 0};

        // Act
        boolean possibility = Task3.isNestable(a, b);

        // Assert
        assertThat(possibility)
            .isEqualTo(true);
    }
}
