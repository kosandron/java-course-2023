package edu.project5;

public record Student(String name, String surname) {
    public String identify() {
        return name + surname;
    }
}
