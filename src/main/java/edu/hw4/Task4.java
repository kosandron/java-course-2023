package edu.hw4;

import java.util.Comparator;
import java.util.List;

public final class Task4 {
    private Task4() {
    }

    public static Animal animalWithLongestName(List<Animal> animals) {
        return animals.stream().max(Comparator.comparingInt(animal -> animal.name().length())).get();
    }
}
