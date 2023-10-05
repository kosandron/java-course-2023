package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {
    @Test
    @DisplayName("Test 1")
    void Test1() {
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
    @DisplayName("Test 2: minA1 == minA2")
    void Test2() {
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
    @DisplayName("Test 3: maxA1 == maxA2")
    void Test3() {
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
    @DisplayName("Test 4: maxA1 == maxA2 and minA1 == minA2")
    void Test4() {
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
    @DisplayName("Test 5: random shuffle")
    void Test5() {
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
    @DisplayName("Test 6")
    void Test6() {
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
    @DisplayName("Test 7")
    void Test7() {
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
    @DisplayName("Test 8")
    void Test8() {
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
