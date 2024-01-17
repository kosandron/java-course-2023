package edu.hw4;

import java.util.List;

public final class Task9 {
    private Task9() {
    }

    public static Integer sumOfPaws(List<Animal> animals) {
        return animals.stream()
            .map(Animal::paws)
            .reduce(Integer::sum)
            .orElse(0);
    }
}
