package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {
    @Test
    @DisplayName("Test 1")
    void Test1() {
        // Arrange
        String str = "123456";

        // Act
        String rightString = Task4.fixString(str);

        // Assert
        assertThat(rightString)
            .isEqualTo("214365");
    }

    @Test
    @DisplayName("Test 2")
    void Test2() {
        // Arrange
        String str = "hTsii  s aimex dpus rtni.g";

        // Act
        String rightString = Task4.fixString(str);

        // Assert
        assertThat(rightString)
            .isEqualTo("This is a mixed up string.");
    }

    @Test
    @DisplayName("Test 3")
    void Test3() {
        // Arrange
        String str = "badce";

        // Act
        String rightString = Task4.fixString(str);

        // Assert
        assertThat(rightString)
            .isEqualTo("abcde");
    }

    @Test
    @DisplayName("Test 4")
    void Test4() {
        // Arrange
        String str = "a";

        // Act
        String rightString = Task4.fixString(str);

        // Assert
        assertThat(rightString)
            .isEqualTo("a");
    }
}
