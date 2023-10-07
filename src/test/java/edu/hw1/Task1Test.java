package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    @Test
    @DisplayName("Test 1: normal time")
    void normal_time_test1() {
        // Arrange
        String str = "17:03";

        // Act
        int timeInSeconds = Task1.minutesToSeconds(str);

        // Assert
        assertThat(timeInSeconds)
            .isEqualTo(17 * 60 + 3);
    }

    @Test
    @DisplayName("Test 2: однозначные минуты")
    void one_number_minute_test() {
        // Arrange
        String str = "09:12";

        // Act
        int timeInSeconds = Task1.minutesToSeconds(str);

        // Assert
        assertThat(timeInSeconds)
            .isEqualTo(9 * 60 + 12);
    }

    @Test
    @DisplayName("Test 3: однозначные минуты")
    void null_minute_test() {
        // Arrange
        String str = "0:59";

        // Act
        int timeInSeconds = Task1.minutesToSeconds(str);

        // Assert
        assertThat(timeInSeconds)
            .isEqualTo(-1);
    }

    @Test
    @DisplayName("Test 4: только секунды")
    void only_seconds_test() {
        // Arrange
        String str = "00:59";

        // Act
        int timeInSeconds = Task1.minutesToSeconds(str);

        // Assert
        assertThat(timeInSeconds)
            .isEqualTo(59);
    }

    @Test
    @DisplayName("Test 5: время = 0")
    void null_time_test() {
        // Arrange
        String str = "00:00";

        // Act
        int timeInSeconds = Task1.minutesToSeconds(str);

        // Assert
        assertThat(timeInSeconds)
            .isEqualTo(0);
    }

    @Test
    @DisplayName("Test 5: много минут")
    void a_lot_of_hours_test() {
        // Arrange
        String str = "9998:34";

        // Act
        int timeInSeconds = Task1.minutesToSeconds(str);

        // Assert
        assertThat(timeInSeconds)
            .isEqualTo(9998 * 60 + 34);
    }

    @Test
    @DisplayName("Test 7: a lot of seconds - 60")
    void a_lot_of_seconds_test1() {
        // Arrange
        String str = "12:60";

        // Act
        int timeInSeconds = Task1.minutesToSeconds(str);

        // Assert
        assertThat(timeInSeconds)
            .isEqualTo(-1);
    }

    @Test
    @DisplayName("Test 8: a lot of seconds - > 60")
    void a_lot_of_seconds_test2() {
        // Arrange
        String str = "12:124";

        // Act
        int timeInSeconds = Task1.minutesToSeconds(str);

        // Assert
        assertThat(timeInSeconds)
            .isEqualTo(-1);
    }

    @Test
    @DisplayName("Test 9: a lot of hours and seconds")
    void a_lot_of_seconds_test3() {
        // Arrange
        String str = "1442:61";

        // Act
        int timeInSeconds = Task1.minutesToSeconds(str);

        // Assert
        assertThat(timeInSeconds)
            .isEqualTo(-1);
    }

    @Test
    @DisplayName("Test 10: null")
    void null_string() {
        // Arrange
        String str = null;

        // Act
        int timeInSeconds = Task1.minutesToSeconds(str);

        // Assert
        assertThat(timeInSeconds)
            .isEqualTo(-1);
    }

    @Test
    @DisplayName("Test 11: another symbols")
    void another_chars_test() {
        // Arrange
        String str = "145:t45";

        // Act
        int timeInSeconds = Task1.minutesToSeconds(str);

        // Assert
        assertThat(timeInSeconds)
            .isEqualTo(-1);
    }

    @Test
    @DisplayName("Test 12: 2 \':\'")
    void triple_time_test() {
        // Arrange
        String str = "145::54";

        // Act
        int timeInSeconds = Task1.minutesToSeconds(str);

        // Assert
        assertThat(timeInSeconds)
            .isEqualTo(-1);
    }

    @Test
    @DisplayName("Test 13: no :")
    void one_time_test() {
        // Arrange
        String str = "14554";

        // Act
        int timeInSeconds = Task1.minutesToSeconds(str);

        // Assert
        assertThat(timeInSeconds)
            .isEqualTo(-1);
    }

    @Test
    @DisplayName("Test 14: 433:")
    void no_seconds_test() {
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
    void negative_time_test() {
        // Arrange
        String str = "-00:01";

        // Act
        int timeInSeconds = Task1.minutesToSeconds(str);

        // Assert
        assertThat(timeInSeconds)
            .isEqualTo(-1);
    }
}
