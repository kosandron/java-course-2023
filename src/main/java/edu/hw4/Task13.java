package edu.hw4;

import java.util.List;

public final class Task13 {
    private Task13() {
    }

    public static List<Animal> animalsWithLongName(List<Animal> animals) {
        return animals.stream().filter(animal -> animal.name().split("\\ ").length > 2).toList();
    }
}
