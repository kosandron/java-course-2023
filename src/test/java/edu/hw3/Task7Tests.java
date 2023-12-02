package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Comparator;
import java.util.TreeMap;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task7Tests {
    @Test
    @DisplayName("most expensive stock")
    void mostExpensiveStock() {
        // Arrange
        TreeMap<String, String> tree = new TreeMap<>(Comparator.nullsFirst(Comparator.naturalOrder()));

        // Act
        tree.put(null, "test");

        // Assert
        assertThat(tree.containsKey(null)).isTrue();
    }
}
