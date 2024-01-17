package edu.hw4;

import java.util.List;

public final class Task15 {
    private Task15() {
    }

    public static Integer weightSumAnimalsInAgeInterval(List<Animal> animals, Integer minAge, Integer maxAge) {
        return animals.stream()
            .filter(animal -> animal.age() >= minAge && animal.age() <= maxAge)
            .map(Animal::weight)
            .reduce(Integer::sum)
            .orElse(0);
    }
}
