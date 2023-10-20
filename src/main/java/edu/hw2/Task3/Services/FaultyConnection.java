package edu.hw2.Task3.Services;

import edu.hw2.Task3.Exceptions.ConnectionException;
import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FaultyConnection implements Connection {
    private final static Logger LOGGER = LogManager.getLogger();
    Random random = new Random();
    private int callCounter = 0;

    @Override
    public void close() {
        LOGGER.info("FaultyConnection closed.");
    }

    @Override
    @SuppressWarnings("MagicNumber")
    public void execute(String command) {
        callCounter++;
        if (random.nextBoolean() && callCounter < 100) {
            throw new ConnectionException();
        }
        LOGGER.info(command);
    }
}
