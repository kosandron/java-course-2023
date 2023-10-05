package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    @Test
    @DisplayName("Корректный тест 1")
    void SuccessTest1() {
        // Arrange
        String str = "17:03";

        // Act
        int timeInSeconds = Task1.minutesToSeconds(str);

        // Assert
        assertThat(timeInSeconds)
            .isEqualTo(1023);
    }

    @Test
    @DisplayName("Корректный тест 2: однозначные минуты")
    void SuccessTest2() {
        // Arrange
        String str = "9:12";

        // Act
        int timeInSeconds = Task1.minutesToSeconds(str);

        // Assert
        assertThat(timeInSeconds)
            .isEqualTo(552);
    }

    @Test
    @DisplayName("Корректный тест 3: только секунды")
    void SuccessTest3() {
        // Arrange
        String str = "0:59";

        // Act
        int timeInSeconds = Task1.minutesToSeconds(str);

        // Assert
        assertThat(timeInSeconds)
            .isEqualTo(59);
    }

    @Test
    @DisplayName("Корректный тест 4: время = 0")
    void SuccessTest4() {
        // Arrange
        String str = "0:0";

        // Act
        int timeInSeconds = Task1.minutesToSeconds(str);

        // Assert
        assertThat(timeInSeconds)
            .isEqualTo(0);
    }

    @Test
    @DisplayName("Корректный тест 5: много минут")
    void SuccessTest5() {
        // Arrange
        String str = "9998:34";

        // Act
        int timeInSeconds = Task1.minutesToSeconds(str);

        // Assert
        assertThat(timeInSeconds)
            .isEqualTo(599914);
    }

    @Test
    @DisplayName("Ошибочный тест 1")
    void ErrorTest1() {
        // Arrange
        String str = "12:60";

        // Act
        int timeInSeconds = Task1.minutesToSeconds(str);

        // Assert
        assertThat(timeInSeconds)
            .isEqualTo(-1);
    }

    @Test
    @DisplayName("Ошибочный тест 2")
    void ErrorTest2() {
        // Arrange
        String str = "12:124";

        // Act
        int timeInSeconds = Task1.minutesToSeconds(str);

        // Assert
        assertThat(timeInSeconds)
            .isEqualTo(-1);
    }

    @Test
    @DisplayName("Ошибочный тест 3")
    void ErrorTest3() {
        // Arrange
        String str = "1442:61";

        // Act
        int timeInSeconds = Task1.minutesToSeconds(str);

        // Assert
        assertThat(timeInSeconds)
            .isEqualTo(-1);
    }

    @Test
    @DisplayName("Ошибочный тест 4: null")
    void ErrorTest4() {
        // Arrange
        String str = null;

        // Act
        int timeInSeconds = Task1.minutesToSeconds(str);

        // Assert
        assertThat(timeInSeconds)
            .isEqualTo(-1);
    }

    @Test
    @DisplayName("Ошибочный тест 5: another symbols")
    void ErrorTest5() {
        // Arrange
        String str = "145:t45";

        // Act
        int timeInSeconds = Task1.minutesToSeconds(str);

        // Assert
        assertThat(timeInSeconds)
            .isEqualTo(-1);
    }

    @Test
    @DisplayName("Ошибочный тест 6: 2 \':\'")
    void ErrorTest6() {
        // Arrange
        String str = "145::54";

        // Act
        int timeInSeconds = Task1.minutesToSeconds(str);

        // Assert
        assertThat(timeInSeconds)
            .isEqualTo(-1);
    }

    @Test
    @DisplayName("Ошибочный тест 6: no :")
    void ErrorTest7() {
        // Arrange
        String str = "14554";

        // Act
        int timeInSeconds = Task1.minutesToSeconds(str);

        // Assert
        assertThat(timeInSeconds)
            .isEqualTo(-1);
    }

    @Test
    @DisplayName("Ошибочный тест 6: 433:")
    void ErrorTest8() {
        // Arrange
        String str = "433:";

        // Act
        int timeInSeconds = Task1.minutesToSeconds(str);

        // Assert
        assertThat(timeInSeconds)
            .isEqualTo(-1);
    }
}
