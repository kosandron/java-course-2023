package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    @Test
    @DisplayName("Test: valid time")
    void normalTimeTest() {
        // Arrange
        String str = "17:03";

        // Act
        int timeInSeconds = Task1.minutesToSeconds(str);

        // Assert
        assertThat(timeInSeconds)
            .isEqualTo(17 * 60 + 3);
    }

    @Test
    @DisplayName("Test: однозначные минуты")
    void oneDigitMinuteTest() {
        // Arrange
        String str = "09:12";

        // Act
        int timeInSeconds = Task1.minutesToSeconds(str);

        // Assert
        assertThat(timeInSeconds)
            .isEqualTo(9 * 60 + 12);
    }

    @Test
    @DisplayName("Test: однозначные минуты")
    void nullMinuteTest() {
        // Arrange
        String str = "0:59";

        // Act
        int timeInSeconds = Task1.minutesToSeconds(str);

        // Assert
        assertThat(timeInSeconds)
            .isEqualTo(-1);
    }

    @Test
    @DisplayName("Test: только секунды")
    void onlySecondsTest() {
        // Arrange
        String str = "00:59";

        // Act
        int timeInSeconds = Task1.minutesToSeconds(str);

        // Assert
        assertThat(timeInSeconds)
            .isEqualTo(59);
    }

    @Test
    @DisplayName("Test: время = 0")
    void nullTimeTest() {
        // Arrange
        String str = "00:00";

        // Act
        int timeInSeconds = Task1.minutesToSeconds(str);

        // Assert
        assertThat(timeInSeconds)
            .isEqualTo(0);
    }

    @Test
    @DisplayName("Test: много минут")
    void aLotOfHours_Test() {
        // Arrange
        String str = "9998:34";

        // Act
        int timeInSeconds = Task1.minutesToSeconds(str);

        // Assert
        assertThat(timeInSeconds)
            .isEqualTo(9998 * 60 + 34);
    }

    @Test
    @DisplayName("Test: a lot of seconds - 60")
    void secondsEqualMinuteTest() {
        // Arrange
        String str = "12:60";

        // Act
        int timeInSeconds = Task1.minutesToSeconds(str);

        // Assert
        assertThat(timeInSeconds)
            .isEqualTo(-1);
    }

    @Test
    @DisplayName("Test: a lot of seconds - > 60")
    void aLotOfSecondsTest() {
        // Arrange
        String str = "12:124";

        // Act
        int timeInSeconds = Task1.minutesToSeconds(str);

        // Assert
        assertThat(timeInSeconds)
            .isEqualTo(-1);
    }

    @Test
    @DisplayName("Test: a lot of hours and seconds")
    void aLotOfHoursAndSecondsTest() {
        // Arrange
        String str = "1442:61";

        // Act
        int timeInSeconds = Task1.minutesToSeconds(str);

        // Assert
        assertThat(timeInSeconds)
            .isEqualTo(-1);
    }

    @Test
    @DisplayName("Test: null")
    void stringIsNullTest() {
        // Arrange
        String str = null;

        // Act
        int timeInSeconds = Task1.minutesToSeconds(str);

        // Assert
        assertThat(timeInSeconds)
            .isEqualTo(-1);
    }

    @Test
    @DisplayName("Test: another symbols")
    void anotherCharsTest() {
        // Arrange
        String str = "145:t45";

        // Act
        int timeInSeconds = Task1.minutesToSeconds(str);

        // Assert
        assertThat(timeInSeconds)
            .isEqualTo(-1);
    }

    @Test
    @DisplayName("Test: 2 \':\'")
    void doubleColonTest() {
        // Arrange
        String str = "145::54";

        // Act
        int timeInSeconds = Task1.minutesToSeconds(str);

        // Assert
        assertThat(timeInSeconds)
            .isEqualTo(-1);
    }

    @Test
    @DisplayName("Test: no :")
    void notColontTest() {
        // Arrange
        String str = "14554";

        // Act
        int timeInSeconds = Task1.minutesToSeconds(str);

        // Assert
        assertThat(timeInSeconds)
            .isEqualTo(-1);
    }

    @Test
    @DisplayName("Test: 433:")
    void noSecondsTest() {
        // Arrange
        String str = "433:";

        // Act
        int timeInSeconds = Task1.minutesToSeconds(str);

        // Assert
        assertThat(timeInSeconds)
            .isEqualTo(-1);
    }

    @Test
    @DisplayName("Test 15: -00:01")
    void negativeTimeValueTest() {
        // Arrange
        String str = "-00:01";

        // Act
        int timeInSeconds = Task1.minutesToSeconds(str);

        // Assert
        assertThat(timeInSeconds)
            .isEqualTo(-1);
    }
}
