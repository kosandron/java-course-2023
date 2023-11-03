package edu.hw4.Errors;

import edu.hw4.Animal;

public abstract class ValidationError {
    public abstract String getDescription();

    public abstract boolean isValid(Animal animal);
}
