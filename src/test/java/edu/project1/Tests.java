package edu.project1;

import edu.project1.Entities.Dictionary;
import edu.project1.Models.Status;
import edu.project1.Service.GameManager;
import edu.project1.Service.ProgrammIO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Tests {
    public Tests() {
        /*Dictionary.addWord("dog");
        Dictionary.addWord("cat");
        Dictionary.addWord("home");
        Dictionary.addWord("world");
        Dictionary.addWord("peace");
        Dictionary.addWord("pen");
        Dictionary.addWord("carrot");
        Dictionary.addWord("book");
        Dictionary.addWord("root");
        Dictionary.addWord("word");*/
    }
    @Test
    @DisplayName("Win test")
    void winWithoutFailsTest() {
        // Arrange
        Dictionary.addWord("dog");
        GameManager game = new GameManager(3, new ProgrammIO(new ArrayList<String>(Arrays.asList("d", "o", "g")) { }, new ArrayList<Integer>(Arrays.asList(3))));

        // Act
        game.run();

        // Assert
        assertThat(game.getStatus()).isEqualTo(Status.win);
    }

    @Test
    @DisplayName("Lose test")
    void loseTest() {
        // Arrange
        Dictionary.addWord("dog");
        GameManager game = new GameManager(3, new ProgrammIO(new ArrayList<String>(Arrays.asList("d", "o", "b", "z", "a", "e", "r")) { }, new ArrayList<Integer>(Arrays.asList(3))));

        // Act
        game.run();

        // Assert
        assertThat(game.getStatus()).isEqualTo(Status.lose);
    }

    @Test
    @DisplayName("Bad input test")
    void errorInInputTest() {
        // Arrange
        Dictionary.addWord("dog");
        GameManager game = new GameManager(3, new ProgrammIO(new ArrayList<String>(Arrays.asList("d", "oa", "ba", "o", "ag", "er", "g")) { }, new ArrayList<Integer>(Arrays.asList(3))));

        // Act
        game.run();

        // Assert
        assertThat(game.getStatus()).isEqualTo(Status.win);
    }

    @Test
    @DisplayName("Bad word length test")
    void incorrectLengthTest() {
        // Arrange
        Dictionary.addWord("word");
        GameManager game = new GameManager(3, new ProgrammIO(new ArrayList<String>(Arrays.asList("w", "oa", "ba", "o", "r", "er", "d")) { }, new ArrayList<Integer>(Arrays.asList(5, 4))));

        // Act
        game.run();

        // Assert
        assertThat(game.getStatus()).isEqualTo(Status.win);
    }
}
