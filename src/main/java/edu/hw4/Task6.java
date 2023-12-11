package edu.hw4;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public final class Task6 {
    private Task6() {
    }

    public static Map<Animal.Type, Animal> mostHeavyAnimal(List<Animal> animals) {
        return animals.stream()
            .collect(Collectors.toMap(Animal::type, animal -> animal,
                BinaryOperator.maxBy(Comparator.comparing(Animal::weight))
            ));
    }
}
