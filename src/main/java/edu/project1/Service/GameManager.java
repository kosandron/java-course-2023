package edu.project1.Service;

import edu.project1.Entities.Defeat;
import edu.project1.Entities.Dictionary;
import edu.project1.Entities.FailedGuess;
import edu.project1.Entities.SuccessfulGuess;
import edu.project1.Entities.Win;
import edu.project1.Models.Status;

public final class GameManager {
    private Status status;
    private int wordSize;
    private int attempt = 0;
    private final int maxAttempt;
    private String secretWord;
    private StringBuilder userWord;
    private final InputOutputManager console;

    @SuppressWarnings("ReturnCount")
    public void tryGuess() {
        String input = console.tryGo(userWord.toString());
        boolean success = false;
        for (int i = 0; i < wordSize; i++) {
            if (secretWord.charAt(i) == input.charAt(0)) {
                userWord.replace(i, i + 1, input);
                success = true;
            }
        }

        if (userWord.toString().equals(secretWord)) {
            console.printState(new Win(attempt, maxAttempt));
            attempt = maxAttempt;
            status = Status.win;
            return;
        }

        if (success) {
            console.printState(new SuccessfulGuess(attempt, maxAttempt));
            status = Status.successfulGuess;
            return;
        }

        attempt++;
        if (attempt == maxAttempt) {
            console.printState(new Defeat(attempt, maxAttempt));
            status = Status.lose;
            return;
        }

        console.printState(new FailedGuess(attempt, maxAttempt));
        status = Status.failedGuess;
    }

    public GameManager(int maxAttempt, InputOutputManager manager) {
        if (maxAttempt <= 0) {
            throw new IllegalArgumentException("Count of attempts is not positive!");
        }
        if (manager == null) {
            throw new NullPointerException("IO manager is null!");
        }

        this.maxAttempt = maxAttempt;
        console = manager;
    }

    public Status getStatus() {
        return status;
    }

    public void run() {
        wordSize = console.getWordSize();
        secretWord = Dictionary.getRandomWordBySize(wordSize);
        userWord = new StringBuilder("*".repeat(wordSize));

        while (attempt != maxAttempt) {
            tryGuess();
        }
    }
}
