package edu.hw3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class Task5 {
    private Task5() {
    }

    public static List<Contact> parseContacts(String[] namesList, String parameter) {
        if (namesList == null) {
            return new ArrayList<Contact>();
        }

        List<Contact> contactBook = new ArrayList<>(Arrays.asList(namesList)
            .stream().map(s -> {
            String[] words = s.split("\\ ");
            return new Contact(words[0], words.length > 1 ? words[1] : "");
        })
            .toList());

        if (parameter.equals("ASC")) {
            contactBook.sort(
                (a, b) -> a.surname().equals("") || b.surname().equals("")
                    ? a.name().compareToIgnoreCase(b.name())
                    : a.surname().compareToIgnoreCase(b.surname())
            );
        } else {
            Collections.sort(
                contactBook,
                (a, b) -> a.surname().equals("") || b.surname().equals("")
                    ? b.name().compareToIgnoreCase(a.name())
                    : b.surname().compareToIgnoreCase(a.surname())
            );
        }

        return contactBook;
    }
}
