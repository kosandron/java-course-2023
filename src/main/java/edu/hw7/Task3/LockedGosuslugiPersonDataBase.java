package edu.hw7.Task3;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockedGosuslugiPersonDataBase implements PersonDataBase {
    private static final ReadWriteLock LOCK = new ReentrantReadWriteLock(true);
    private final Map<Integer, Person> persons;

    public LockedGosuslugiPersonDataBase() {
        persons = new HashMap<>();
    }

    public synchronized void add(Person person) {
        LOCK.writeLock().lock();
        try {
            if (person != null) {
                persons.put(person.id(), person);
            }
        } finally {
            LOCK.writeLock().unlock();
        }
    }

    public synchronized void delete(int id) {
        LOCK.writeLock().lock();
        try {
            persons.remove(id);
        } finally {
            LOCK.writeLock().unlock();
        }
    }

    public Person findByName(String name) {
        LOCK.readLock().lock();
        Optional<Person> man;
        try {
            man = persons
                .values()
                .stream()
                .filter(person -> person.name() != null && person.name().equals(name))
                .findAny();

            if (man.isPresent()) {
                if (man.get().address() == null || man.get().phoneNumber() == null) {
                    return null;
                }
            }
        } finally {
            LOCK.readLock().unlock();
        }

        return man.orElse(null);
    }

    public Person findByAddress(String address) {
        LOCK.readLock().lock();
        Optional<Person> man;

        try {
            man = persons
                .values()
                .stream()
                .filter(person -> person.address() != null && person.address().equals(address))
                .findAny();

            if (man.isPresent()) {
                if (man.get().name() == null || man.get().phoneNumber() == null) {
                    return null;
                }
            }
        } finally {
            LOCK.readLock().unlock();
        }

        return man.orElse(null);
    }

    public Person findByPhone(String phone) {
        LOCK.readLock().lock();
        Optional<Person> man;
        try {
            man = persons
                .values()
                .stream()
                .filter(person -> person.phoneNumber() != null && person.phoneNumber().equals(phone))
                .findAny();

            if (man.isPresent()) {
                if (man.get().name() == null || man.get().address() == null) {
                    return null;
                }
            }
        } finally {
            LOCK.readLock().unlock();
        }

        return man.orElse(null);
    }
}

