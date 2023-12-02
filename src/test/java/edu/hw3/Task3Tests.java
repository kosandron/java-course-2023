package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Tests {
    @Test
    @DisplayName("Strings dict")
    void stringsTest() {
        // Arrange
        List<String> list = new ArrayList<>(Arrays.asList("a", "bb", "a", "bb"));
        HashMap<String, Integer> answer = new HashMap<>();
        answer.put("a", 2);
        answer.put("bb", 2);

        // Act
        Map<String, Integer> result = Task3.freqDict(list);

        // Assert
        assertThat(result)
            .isEqualTo(answer);
    }

    @Test
    @DisplayName("Integer dict")
    void integersTest() {
        // Arrange
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 1, 2, 2, 1));
        HashMap<Integer, Integer> answer = new HashMap<>();
        answer.put(1, 3);
        answer.put(2, 2);

        // Act
        Map<Integer, Integer> result = Task3.freqDict(list);

        // Assert
        assertThat(result)
            .isEqualTo(answer);
    }

    @Test
    @DisplayName("Russian words dict")
    void russianTest() {
        // Arrange
        List<String> list = new ArrayList<>(Arrays.asList("код", "код", "код", "bug"));
        HashMap<String, Integer> answer = new HashMap<>();
        answer.put("код", 3);
        answer.put("bug", 1);

        // Act
        Map<String, Integer> result = Task3.freqDict(list);

        // Assert
        assertThat(result)
            .isEqualTo(answer);
    }

    @Test
    @DisplayName("Boolean dict")
    void booleanTest() {
        // Arrange
        List<Boolean> list = new ArrayList<>(Arrays.asList(true, false, true, false, true));
        HashMap<Boolean, Integer> answer = new HashMap<>();
        answer.put(true, 3);
        answer.put(false, 2);

        // Act
        Map<Boolean, Integer> result = Task3.freqDict(list);

        // Assert
        assertThat(result)
            .isEqualTo(answer);
    }
}
