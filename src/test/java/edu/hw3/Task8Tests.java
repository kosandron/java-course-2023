package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task8Tests {
    @Test
    @DisplayName("ArrayList iterating")
    void iterateArrayListTest() {
        // Arrange
        List<String> pets = new ArrayList<>(Arrays.asList("Dog", "Cat", "Parrot", "Fish"));
        int i = 3;
        BackwardIterator<String> iter = new BackwardIterator<>(pets);


        // Act, Assert
        while (iter.hasNext()) {
            assertThat(pets.get(i)).isEqualTo(iter.next());
            i--;
        }
    }

    @Test
    @DisplayName("Set iterating")
    void iterateSetTest() {
        // Arrange
        Set<String> pets = new HashSet<>(Arrays.asList("Dog", "Cat", "Parrot", "Fish"));
        int i = 3;
        BackwardIterator<String> iter = new BackwardIterator<>(pets);
        List<String> checkList = new ArrayList<>(pets);

        // Act, Assert
        while (iter.hasNext()) {
            assertThat(checkList.get(i)).isEqualTo(iter.next());
            i--;
        }
    }

    @Test
    @DisplayName("Queue iterating")
    void iterateQueueTest() {
        // Arrange
        Deque<String> pets = new ArrayDeque<>(Arrays.asList("Dog", "Cat", "Parrot", "Fish"));
        int i = 3;
        BackwardIterator<String> iter = new BackwardIterator<>(pets);

        // Act, Assert
        while (iter.hasNext()) {
            assertThat(pets.pollLast()).isEqualTo(iter.next());
            i--;
        }
    }
}
