package edu.hw4.Errors;

import edu.hw4.Animal;

public abstract class ValidationError {
    public abstract String getDescription();

    public abstract boolean isValid(Animal animal);

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        ValidationError guess = (ValidationError) obj;
        return this.getDescription().equals(guess.getDescription());
    }

    @Override
    public int hashCode() {
        return this.getDescription().hashCode();
    }
}
