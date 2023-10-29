package edu.project1.Entities;

public record Win(int attempt, int maxAttempt) implements State {
    public String message() {
        return "You won!";
    }
}
