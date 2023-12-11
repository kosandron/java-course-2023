package edu.hw4;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public final class Task8 {
    private Task8() {
    }

    public static Optional<Animal> mostHeavyAnimalShorterK(List<Animal> animals, Integer k) {
        return animals.stream()
            .filter(animal -> animal.height() < k)
            .max(Comparator.comparingInt(Animal::weight));
    }
}
