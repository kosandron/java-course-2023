package edu.hw4;

import java.util.List;

public final class Task17 {
    private Task17() {
    }

    public static boolean spidersBiteMoreThanDogs(List<Animal> animals) {
        return animals.stream().filter(animal -> animal.type() == Animal.Type.SPIDER && animal.bites()).count()
            > animals.stream().filter(animal -> animal.type() == Animal.Type.DOG && animal.bites()).count();
    }
}
