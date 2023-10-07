package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {
    @Test
    @DisplayName("Test 1: 3524")
    void random_test1() {
        // Arrange
        int number = 3524;

        // Act
        int currentAnswer = Task6.countK(number);

        // Assert
        assertThat(currentAnswer)
            .isEqualTo(3); //  3524 -> 3087 -> 8352 -> 6174
    }

    @Test
    @DisplayName("Test 2: 6621")
    void random_test2() {
        // Arrange
        int number = 6621;

        // Act
        int currentAnswer = Task6.countK(number);

        // Assert
        assertThat(currentAnswer)
            .isEqualTo(5); //  6621 -> 5355 -> 1998 -> 8082 -> 8532
    }

    @Test
    @DisplayName("Test 3: 6554")
    void random_test3() {
        // Arrange
        int number = 6554;

        // Act
        int currentAnswer = Task6.countK(number);

        // Assert
        assertThat(currentAnswer)
            .isEqualTo(4); //  6554 -> 1998 -> 8082 -> 8532 -> 6174
    }

    @Test
    @DisplayName("Test 4: 1234")
    void random_test4() {
        // Arrange
        int number = 1234;

        // Act
        int currentAnswer = Task6.countK(number);

        // Assert
        assertThat(currentAnswer)
            .isEqualTo(3); //  1234 -> 3087 -> 8352 -> 6174
    }

    @Test
    @DisplayName("Test 5: 6174!")
    void null_answer_test() {
        // Arrange
        int number = 6174;

        // Act
        int currentAnswer = Task6.countK(number);

        // Assert
        assertThat(currentAnswer)
            .isEqualTo(0);
    }

    @Test
    @DisplayName("Test 6: small number")
    void small_number() {
        // Arrange
        int number = 34;

        // Act
        int currentAnswer = Task6.countK(number);

        // Assert
        assertThat(currentAnswer)
            .isEqualTo(-1);
    }

    @Test
    @DisplayName("Test 7: 1001")
    void test7() {
        // Arrange
        int number = 1001;

        // Act
        int currentAnswer = Task6.countK(number);

        // Assert
        assertThat(currentAnswer)
            .isEqualTo(4); // 1001 -> 1089 -> 9621 -> 8352 -> 6174
    }

    @Test
    @DisplayName("Test 8: 1111 - same digits")
    void same_digits_test1() {
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
    void test9() {
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
    void same_digits_test2() {
        // Arrange
        int number = 9999;

        // Act
        int currentAnswer = Task6.countK(number);

        // Assert
        assertThat(currentAnswer)
            .isEqualTo(-1);
    }
}
