package edu.hw4.Errors;

import edu.hw4.Animal;

public class EmptyNameError extends ValidationError {
    @Override
    public String getDescription() {
        return "Name is empty or null!";
    }

    @Override
    public boolean isValid(Animal animal) {
        return animal.name() == null || animal.name().isEmpty();
    }
}
