package edu.hw2.Task3.Services;

import edu.hw2.Task3.Exceptions.ConnectionException;
import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FaultyConnection implements Connection {
    private final static Logger LOGGER = LogManager.getLogger();
    private final static Random RANDOM = new Random();
    private final static int MIN_SUCCESS_FREQUENCY = 100;
    private int callCounter = 0;

    @Override
    public void close() {
        LOGGER.info("FaultyConnection closed.");
    }

    @Override
    public void execute(String command) {
        callCounter++;
        if (RANDOM.nextBoolean() && callCounter < MIN_SUCCESS_FREQUENCY) {
            throw new ConnectionException();
        }
        LOGGER.info(command);
    }
}
