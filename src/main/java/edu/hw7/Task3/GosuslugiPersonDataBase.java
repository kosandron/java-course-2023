package edu.hw7.Task3;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GosuslugiPersonDataBase implements PersonDataBase {
    private final Map<Integer, Person> persons;

    public GosuslugiPersonDataBase() {
        persons = new HashMap<>();
    }

    public synchronized void add(Person person) {
        if (person != null) {
            persons.put(person.id(), person);
        }
    }

    public synchronized void delete(int id) {
        persons.remove(id);
    }

    public Person findByName(String name) {
        Optional<Person> man = persons
            .values()
            .stream()
            .filter(person -> person.name() != null && person.name().equals(name))
            .findAny();

        if (man.isPresent()) {
            if (man.get().address() == null || man.get().phoneNumber() == null) {
                return null;
            }
        }

        return man.orElse(null);
    }

    public Person findByAddress(String address) {
        Optional<Person> man = persons
            .values()
            .stream()
            .filter(person -> person.address() != null && person.address().equals(address))
            .findAny();

        if (man.isPresent()) {
            if (man.get().name() == null || man.get().phoneNumber() == null) {
                return null;
            }
        }

        return man.orElse(null);
    }

    public Person findByPhone(String phone) {
        Optional<Person> man = persons
            .values()
            .stream()
            .filter(person -> person.phoneNumber() != null && person.phoneNumber().equals(phone))
            .findAny();

        if (man.isPresent()) {
            if (man.get().name() == null || man.get().address() == null) {
                return null;
            }
        }

        return man.orElse(null);
    }
}
