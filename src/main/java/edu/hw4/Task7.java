package edu.hw4;

import java.util.Comparator;
import java.util.List;

public final class Task7 {
    private Task7() {
    }

    public static Animal oldestAnimal(List<Animal> animals) {
        return animals.stream().max(Comparator.comparingInt(Animal::age)).get();
    }
}
