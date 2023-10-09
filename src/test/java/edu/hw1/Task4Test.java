package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {
    @Test
    @DisplayName("Test: 123456")
    void numberInStringTest() {
        // Arrange
        String str = "123456";

        // Act
        String rightString = Task4.fixString(str);

        // Assert
        assertThat(rightString)
            .isEqualTo("214365");
    }

    @Test
    @DisplayName("Test: long string")
    void longStringTest() {
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
    void smallStringTest() {
        // Arrange
        String str = "badce";

        // Act
        String rightString = Task4.fixString(str);

        // Assert
        assertThat(rightString)
            .isEqualTo("abcde");
    }

    @Test
    @DisplayName("Test: one char")
    void oneCharTest() {
        // Arrange
        String str = "a";

        // Act
        String rightString = Task4.fixString(str);

        // Assert
        assertThat(rightString)
            .isEqualTo("a");
    }

    @Test
    @DisplayName("Test: empty string")
    void emptyStringTest() {
        // Arrange
        String str = "";

        // Act
        String rightString = Task4.fixString(str);

        // Assert
        assertThat(rightString)
            .isEqualTo("");
    }
}
