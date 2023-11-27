package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Tests {
    @Test
    @DisplayName("Empty array")
    void emptyArrayTest() {
        // Arrange
        String[] namesList = new String[0];

        // Act
        List<Contact> contactBook = Task5.parseContacts(namesList, "ASC");

        // Assert
        assertThat(contactBook)
            .isEqualTo(new ArrayList<Contact>());
    }

    @Test
    @DisplayName("Null array")
    void nullArrayTest() {
        // Arrange
        // Act
        List<Contact> contactBook = Task5.parseContacts(null, "ASC");

        // Assert
        assertThat(contactBook)
            .isEqualTo(new ArrayList<Contact>());
    }

    @Test
    @DisplayName("Full name array, ASC")
    void nameAndSurnameASCTest() {
        // Arrange
        String[] namesList = new String[4];
        namesList[0] = "John Locke";
        namesList[1] = "Thomas Aquinas";
        namesList[2] = "David Hume";
        namesList[3] = "Rene Descartes";

        // Act
        List<Contact> contactBook = Task5.parseContacts(namesList, "ASC");

        // Assert
        ArrayList<Contact> answer = new ArrayList<>(Arrays.asList(
            new Contact("Thomas", "Aquinas"),
            new Contact("Rene", "Descartes"),
            new Contact("David", "Hume"),
            new Contact("John", "Locke")
        ));
        assertThat(contactBook)
            .isEqualTo(answer);
    }

    @Test
    @DisplayName("Full name array, DESC")
    void nameAndSurnameDESCTest() {
        // Arrange
        String[] namesList = new String[4];
        namesList[0] = "John Locke";
        namesList[1] = "Thomas Aquinas";
        namesList[2] = "David Hume";
        namesList[3] = "Rene Descartes";

        // Act
        List<Contact> contactBook = Task5.parseContacts(namesList, "DESC");

        // Assert
        ArrayList<Contact> answer = new ArrayList<>(Arrays.asList(
            new Contact("Thomas", "Aquinas"),
            new Contact("Rene", "Descartes"),
            new Contact("David", "Hume"),
            new Contact("John", "Locke")
        ));
        Collections.reverse(answer);
        assertThat(contactBook)
            .isEqualTo(answer);
    }

    @Test
    @DisplayName("Array with some people without surname, ASC")
    void notFullNameASCTest() {
        // Arrange
        String[] namesList = new String[4];
        namesList[0] = "John Locke";
        namesList[1] = "Thomas";
        namesList[2] = "David";
        namesList[3] = "Rene Descartes";

        // Act
        List<Contact> contactBook = Task5.parseContacts(namesList, "ASC");

        // Assert
        ArrayList<Contact> answer = new ArrayList<>(Arrays.asList(
            new Contact("David", ""),
            new Contact("Rene", "Descartes"),
            new Contact("John", "Locke"),
            new Contact("Thomas", "")
        ));
        assertThat(contactBook)
            .isEqualTo(answer);
    }

    @Test
    @DisplayName("Array with some people without surname, DESC")
    void notFullNameDESCTest() {
        // Arrange
        String[] namesList = new String[4];
        namesList[0] = "John Locke";
        namesList[1] = "Thomas";
        namesList[2] = "David";
        namesList[3] = "Rene Descartes";

        // Act
        List<Contact> contactBook = Task5.parseContacts(namesList, "DESC");

        // Assert
        ArrayList<Contact> answer = new ArrayList<>(Arrays.asList(
            new Contact("David", ""),
            new Contact("Rene", "Descartes"),
            new Contact("John", "Locke"),
            new Contact("Thomas", "")
        ));
        Collections.reverse(answer);
        assertThat(contactBook)
            .isEqualTo(answer);
    }
}
