package edu.hw7.Task3Tests;

import edu.hw7.Task3.LockedGosuslugiPersonDataBase;
import edu.hw7.Task3.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class LockedDataBaseTests {
    @Test
    @DisplayName("Check find by name")
    public void checkFindingByName() {
        LockedGosuslugiPersonDataBase database = new LockedGosuslugiPersonDataBase();
        Thread thread = new Thread(() -> {
            database.add(new Person(1, "Petya", "Nevskiy 6", "+978332211"));
            database.add(new Person(2, "Kolya", "Kronverkskiy 12", "+344233223"));
        });
        thread.start();
        database.add(new Person(3, "Igor", "Pochtampskaya 9", "+921876343"));
        database.add(new Person(4, "Vasya", null, "+82782974932"));

        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        assertThat(database.findByName("Petya")).isNotNull();
        assertThat(database.findByName("Kolya")).isNotNull();
        assertThat(database.findByName("Igor")).isNotNull();
        assertThat(database.findByName("Vasya")).isNull();

        database.delete(2);
        assertThat(database.findByPhone("Kolya")).isNull();
    }

    @Test
    @DisplayName("Check find by phone")
    public void checkFindingByPhone() {
        LockedGosuslugiPersonDataBase database = new LockedGosuslugiPersonDataBase();
        Thread thread = new Thread(() -> {
            database.add(new Person(1, "Petya", "Nevskiy 6", "+978332211"));
            database.add(new Person(2, "Kolya", "Kronverkskiy 12", "+344233223"));
        });
        thread.start();
        database.add(new Person(3, "Igor", "Pochtampskaya 9", "+921876343"));
        database.add(new Person(4, "Vasya", null, "+82782974932"));

        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        assertThat(database.findByPhone("+978332211")).isNotNull();
        assertThat(database.findByPhone("+344233223")).isNotNull();
        assertThat(database.findByPhone("+921876343")).isNotNull();
        assertThat(database.findByPhone("+82782974932")).isNull();

        database.delete(2);
        assertThat(database.findByPhone("+344233223")).isNull();
    }

    @Test
    @DisplayName("Check find by address")
    public void checkFindingByAddress() {
        LockedGosuslugiPersonDataBase database = new LockedGosuslugiPersonDataBase();
        Thread thread = new Thread(() -> {
            database.add(new Person(1, "Petya", "Nevskiy 6", "+978332211"));
            database.add(new Person(2, "Kolya", "Kronverkskiy 12", "+344233223"));
        });
        thread.start();
        database.add(new Person(3, "Igor", "Pochtampskaya 9", "+921876343"));
        database.add(new Person(4, "Vasya", "Kirochnaya 1", null));

        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        assertThat(database.findByAddress("Nevskiy 6")).isNotNull();
        assertThat(database.findByAddress("Kronverkskiy 12")).isNotNull();
        assertThat(database.findByAddress("Pochtampskaya 9")).isNotNull();
        assertThat(database.findByAddress("Kirochnaya 1")).isNull();

        database.delete(2);
        assertThat(database.findByPhone("Kronverkskiy 12")).isNull();
    }
}
