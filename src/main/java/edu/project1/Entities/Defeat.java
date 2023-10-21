package edu.project1.Entities;

public record Defeat(int attempt, int maxAttempt) implements State {
    public String message() {
        return "You lose!";
    }
}
