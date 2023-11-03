package edu.hw4;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class Task6 {
    private Task6() {
    }

    public static Map<Animal.Type, Animal> mostHeavyAnimal(List<Animal> animals) {
        return animals.stream()
            .collect(Collectors.groupingBy(Animal::type, Collectors.maxBy(Comparator.comparingInt(Animal::weight))))
            .entrySet()
            .stream()
            .filter(entry -> entry.getValue().isPresent())
            .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue()
                .get()));
    }
}
