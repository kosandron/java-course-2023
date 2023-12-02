package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task2Tests {
    @Test
    @DisplayName("Easy 3 scopes")
    void ThreeScopesTest() {
        // Arrange
        String line = "()()()";

        // Act
        ArrayList<String> result = Task2.clusterize(line);

        // Assert
        assertThat(result)
            .isEqualTo(new ArrayList<>(Arrays.asList("()", "()", "()")));
    }

    @Test
    @DisplayName("Scopes in scopes")
    void inScopesTest() {
        // Arrange
        String line = "((()))";

        // Act
        ArrayList<String> result = Task2.clusterize(line);

        // Assert
        assertThat(result)
            .isEqualTo(new ArrayList<>(Arrays.asList("((()))")));
    }

    @Test
    @DisplayName("Combination of lot of scopes")
    void bigCombinationOfScopesTest() {
        // Arrange
        String line = "((()))(())()()(()())";

        // Act
        ArrayList<String> result = Task2.clusterize(line);

        // Assert
        assertThat(result)
            .isEqualTo(new ArrayList<>(Arrays.asList("((()))", "(())", "()", "()", "(()())")));
    }

    @Test
    @DisplayName("Combination of scopes")
    void combinationOfScopesTest() {
        // Arrange
        String line = "((())())(()(()()))";

        // Act
        ArrayList<String> result = Task2.clusterize(line);

        // Assert
        assertThat(result)
            .isEqualTo(new ArrayList<>(Arrays.asList("((())())", "(()(()()))")));
    }

    @Test
    @DisplayName("One scope")
    void oneScopeTest() {
        // Arrange
        String line = "()";

        // Act
        ArrayList<String> result = Task2.clusterize(line);

        // Assert
        assertThat(result)
            .isEqualTo(new ArrayList<>(Arrays.asList("()")));
    }

    @Test
    @DisplayName("No one scope")
    void noOneScopeTest() {
        // Arrange
        String line = "";

        // Act
        ArrayList<String> result = Task2.clusterize(line);

        // Assert
        assertThat(result)
            .isEqualTo(new ArrayList<>());
    }

    @Test
    @DisplayName("Wrong case")
    void wrongCaseTest() {
        // Arrange
        String line = ")()())(()(())())((())";

        // Act, Assert
        Throwable exception = assertThrows(IllegalArgumentException.class,() -> Task2.clusterize(line));
        assertEquals("Cannot clusterize!", exception.getMessage());
    }
}
