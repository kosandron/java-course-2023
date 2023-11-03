package edu.hw4;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class Task17 {
    private Task17() {
    }

    public static boolean spidersBiteMoreThanDogs(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> animal.bites()
                && (animal.type() == Animal.Type.SPIDER || animal.type() == Animal.Type.DOG))
            .collect(Collectors.groupingBy(Animal::type, Collectors.counting()))
            .entrySet()
            .stream()
            .reduce((firstEntry, secondEntry) -> {
                if (firstEntry.getValue() > secondEntry.getValue()) {
                    return firstEntry;
                }
                if (firstEntry.getValue() < secondEntry.getValue()) {
                    return secondEntry;
                }

                return Map.entry(Animal.Type.BIRD, 1L);
            })
            .stream()
            .anyMatch(entry -> entry.getKey() == Animal.Type.SPIDER);
    }
}
