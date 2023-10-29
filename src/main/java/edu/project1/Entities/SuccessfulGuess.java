package edu.project1.Entities;

public record SuccessfulGuess(int attempt, int maxAttempt) implements State {
    public String message() {
        return "Hit!";
    }
}
