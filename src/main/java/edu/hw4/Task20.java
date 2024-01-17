package edu.hw4;

import edu.hw4.Errors.EmptyNameError;
import edu.hw4.Errors.NegativeAgeError;
import edu.hw4.Errors.NegativeHeightError;
import edu.hw4.Errors.NegativeWeightError;
import edu.hw4.Errors.ValidationError;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public final class Task20 {
    private static Set<ValidationError> errors;

    private Task20() {
        errors = new HashSet<>();
        errors.add(new EmptyNameError());
        errors.add(new NegativeAgeError());
        errors.add(new NegativeHeightError());
        errors.add(new NegativeWeightError());
    }

    public static Map<String, String> validateAnimals(List<Animal> animals) {
        return Task19.validateAnimals(animals)
            .entrySet()
            .stream()
            .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue().stream().map(ValidationError::getDescription)
                .collect(Collectors.joining(" "))));
    }
}
