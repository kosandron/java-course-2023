package edu.hw2.Task3.Services;

public interface Connection extends AutoCloseable {
    void execute(String command);
}
