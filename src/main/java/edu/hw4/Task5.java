package edu.hw4;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final class Task5 {
    private Task5() {
    }

    public static Animal.Sex mostPopularGender(List<Animal> animals) {
        return Collections.max(animals.stream()
            .collect(Collectors.groupingBy(Animal::sex, Collectors.counting())).keySet());
    }
}
