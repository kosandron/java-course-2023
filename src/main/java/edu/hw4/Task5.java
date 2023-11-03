package edu.hw4;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class Task5 {
    private Task5() {
    }

    public static Animal.Sex mostPopularGender(List<Animal> animals) {
        return animals.stream()
            .collect(Collectors.groupingBy(Animal::sex, Collectors.counting()))
            .entrySet()
            .stream()
            .max(Map.Entry.comparingByValue())
            .map(Map.Entry::getKey)
            .get();
    }
}
