package edu.hw4;

import java.util.List;

public final class Task10 {
    private Task10() {
    }

    public static List<Animal> animalWithDifferentAgeAndPawsCount(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> animal.age() != animal.paws())
            .toList();
    }
}
