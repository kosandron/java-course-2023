package edu.hw4;

import java.util.List;

public final class Task12 {
    private Task12() {
    }

    public static Long fatAnimalsCount(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> animal.weight() > animal.height())
            .count();
    }
}
