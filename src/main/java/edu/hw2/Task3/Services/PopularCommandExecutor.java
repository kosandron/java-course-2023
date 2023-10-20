package edu.hw2.Task3.Services;

import edu.hw2.Task3.Exceptions.ConnectionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class PopularCommandExecutor {
    private final static Logger LOGGER = LogManager.getLogger();
    private final ConnectionManager manager;
    private final int maxAttempts;

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        if (maxAttempts < 0) {
            throw new IllegalArgumentException("maxAttempts < 0!");
        }
        if (manager == null) {
            throw new NullPointerException("Manager is null!");
        }

        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    public void updatePackages() {
        tryExecute("apt update && apt upgrade -y");
    }

    public boolean tryExecute(String command) {
        for (int i = 0; i < maxAttempts; i++) {
            try (Connection connection = manager.getConnection()) {
                LOGGER.info("Success!");
                return true;
            } catch (ConnectionException e) {
                LOGGER.info("Attempt " + i + 1 + ": connection exception.");
            } catch (Exception e) {
                LOGGER.info("Another exception!");
            }
        }
        LOGGER.info("Failure!");
        //throw new ConnectionException();
        return false;
    }
}
