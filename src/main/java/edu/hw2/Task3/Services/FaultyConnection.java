package edu.hw2.Task3.Services;

import edu.hw2.Task3.Exceptions.ConnectionException;
import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FaultyConnection implements Connection {
    private final static Logger LOGGER = LogManager.getLogger();
    Random random = new Random();

    @Override
    public void close() {
        LOGGER.info("FaultyConnection closed.");
    }

    @Override
    public void execute(String command) {
        if (random.nextBoolean()) {
            throw new ConnectionException();
        }
        LOGGER.info(command);
    }
}
