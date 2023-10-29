package edu.project1.Entities;

public record FailedGuess(int attempt, int maxAttempt) implements State {
    public String message() {
        return "Missed, mistake " + attempt + " out of " + maxAttempt + ".";
    }
}
