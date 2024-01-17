package edu.hw4;

import java.util.Comparator;
import java.util.List;

public final class Task16 {
    private Task16() {
    }

    public static List<Animal> sortByTypeSexName(List<Animal> animals) {
        return animals.stream()
            .sorted(Comparator.comparing(Animal::type)
                .thenComparing(Animal::sex)
                .thenComparing(Animal::name))
            .toList();
    }
}
