package edu.hw2.Task3.Services;

import java.util.Random;

public class DefaultConnectionManager implements ConnectionManager {
    final Random random = new Random();

    @Override
    public Connection getConnection() {
        if (random.nextBoolean()) {
            return new StableConnection();
        }
        return new FaultyConnection();
    }
}
