package edu.project1.Service;

import edu.project1.Entities.Dictionary;
import edu.project1.Entities.State;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProgrammIO implements InputOutputManager {
    private final static Logger LOGGER = LogManager.getLogger();
    private final List<String> stringInput;
    private final List<Integer> intInput;
    private int stringInputCounter;
    private int intInputCounter;

    public ProgrammIO(List<String> stringInput, List<Integer> intInput) {
        stringInputCounter = 0;
        intInputCounter = 0;

        this.stringInput = stringInput;
        this.intInput = intInput;
    }

    public String getNextString() {
        return stringInput.get(stringInputCounter++);
    }

    public int getNextInt() {
        return intInput.get(intInputCounter++);
    }

    private boolean isValidLetter(String input, String openWord) {
        if (input.length() != 1) {
            LOGGER.info("You enter more than 1 character!");
            return false;
        }
        if (!Character.isLetter(input.charAt(0))) {
            LOGGER.info("Character is not letter!");
            return false;
        }
        if (openWord.contains(input.toLowerCase())) {
            LOGGER.info("This character is opened!");
            return false;
        }

        return true;
    }

    @Override
    public String tryGo(String openWord) {
        LOGGER.info("The word: " + openWord + '\n');

        String input;
        do {
            LOGGER.info("Guess a letter: ");
            input = getNextString();
        } while (!isValidLetter(input, openWord));

        return input.toLowerCase();
    }

    @Override
    public void printState(State state) {
        LOGGER.info(state.message());
    }

    @Override
    public int getWordSize() {
        int input = 0;
        boolean continueInput = false;
        do {
            try {
                LOGGER.info("Enter word size: ");
                input = getNextInt();
                continueInput = false;

                if (!Dictionary.consistWordBySize(input)) {
                    LOGGER.info("There are not words in dictionary with this size((");
                    continueInput = true;
                }
            } catch (InputMismatchException e) {
                LOGGER.info("Invalid integer input!");
                continueInput = true;
            }
        } while (continueInput);

        return input;
    }
}
