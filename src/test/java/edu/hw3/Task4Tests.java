package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task4Tests {
    @Test
    @DisplayName("1")
    void oneTest() {
        // Arrange
        int value = 1;

        // Act
        String result = Task4.intToRoman(value);

        // Assert
        assertThat(result)
            .isEqualTo("I");
    }

    @Test
    @DisplayName("4")
    void fourTest() {
        // Arrange
        int value = 4;

        // Act
        String result = Task4.intToRoman(value);

        // Assert
        assertThat(result)
            .isEqualTo("IV");
    }

    @Test
    @DisplayName("5")
    void fiveTest() {
        // Arrange
        int value = 5;

        // Act
        String result = Task4.intToRoman(value);

        // Assert
        assertThat(result)
            .isEqualTo("V");
    }

    @Test
    @DisplayName("9")
    void neinTest() {
        // Arrange
        int value = 9;

        // Act
        String result = Task4.intToRoman(value);

        // Assert
        assertThat(result)
            .isEqualTo("IX");
    }

    @Test
    @DisplayName("10")
    void tenTest() {
        // Arrange
        int value = 10;

        // Act
        String result = Task4.intToRoman(value);

        // Assert
        assertThat(result)
            .isEqualTo("X");
    }

    @Test
    @DisplayName("50")
    void fiftyTest() {
        // Arrange
        int value = 50;

        // Act
        String result = Task4.intToRoman(value);

        // Assert
        assertThat(result)
            .isEqualTo("L");
    }

    @Test
    @DisplayName("100")
    void hundredTest() {
        // Arrange
        int value = 100;

        // Act
        String result = Task4.intToRoman(value);

        // Assert
        assertThat(result)
            .isEqualTo("C");
    }

    @Test
    @DisplayName("500")
    void fiveHundredTest() {
        // Arrange
        int value = 500;

        // Act
        String result = Task4.intToRoman(value);

        // Assert
        assertThat(result)
            .isEqualTo("D");
    }

    @Test
    @DisplayName("1000")
    void thousandTest() {
        // Arrange
        int value = 1000;

        // Act
        String result = Task4.intToRoman(value);

        // Assert
        assertThat(result)
            .isEqualTo("M");
    }

    @Test
    @DisplayName("2999")
    void comboTest() {
        // Arrange
        int value = 2999;

        // Act
        String result = Task4.intToRoman(value);

        // Assert
        assertThat(result)
            .isEqualTo("MMCMXCIX");
    }

    @Test
    @DisplayName("Negative numbers")
    void negativeNumberTest() {
        // Arrange
        int value = -1;

        // Act
        Throwable exception = assertThrows(IllegalArgumentException.class,() -> Task4.intToRoman(value));
        assertEquals("Cannot cast to roman!", exception.getMessage());
    }

    @Test
    @DisplayName("Zero test")
    void zeroTest() {
        // Arrange
        int value = 0;

        // Act
        Throwable exception = assertThrows(IllegalArgumentException.class,() -> Task4.intToRoman(value));
        assertEquals("Cannot cast to roman!", exception.getMessage());
    }

    @Test
    @DisplayName("Too big number test")
    void tooBigNumber() {
        // Arrange
        int value = 10000;

        // Act
        Throwable exception = assertThrows(IllegalArgumentException.class,() -> Task4.intToRoman(value));
        assertEquals("Cannot cast to roman!", exception.getMessage());
    }
}
