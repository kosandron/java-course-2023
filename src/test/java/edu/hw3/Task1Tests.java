package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Tests {
    @Test
    @DisplayName("Empty string")
    void emptyStringTest() {
        // Arrange
        String str = "";

        // Act
        String result = Task1.atbash(str);

        // Assert
        assertThat(result)
            .isEqualTo("");
    }

    @Test
    @DisplayName("One char")
    void oneCharTest() {
        // Arrange
        String str = "a";

        // Act
        String result = Task1.atbash(str);

        // Assert
        assertThat(result)
            .isEqualTo("z");
    }

    @Test
    @DisplayName("Combination string")
    void combinationStringTest() {
        // Arrange
        String str = "Hello world!";

        // Act
        String result = Task1.atbash(str);

        // Assert
        assertThat(result)
            .isEqualTo("Svool dliow!");
    }

    @Test
    @DisplayName("Long string")
    void longStringTest() {
        // Arrange
        String str = "Any fool can write code that a computer can understand. Good programmers write code that humans can understand. ― Martin Fowler";

        // Act
        String result = Task1.atbash(str);

        // Assert
        assertThat(result)
            .isEqualTo("Zmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw. Tllw kiltiznnvih dirgv xlwv gszg sfnzmh xzm fmwvihgzmw. ― Nzigrm Uldovi");
    }

    @Test
    @DisplayName("Russian string")
    void notEnglishTextTest() {
        // Arrange
        String str = "Мама мыла раму";

        // Act
        String result = Task1.atbash(str);

        // Assert
        assertThat(result)
            .isEqualTo("Мама мыла раму");
    }
}
