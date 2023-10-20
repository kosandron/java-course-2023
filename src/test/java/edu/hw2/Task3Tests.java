package edu.hw2;

import edu.hw2.Task3.Exceptions.ConnectionException;
import edu.hw2.Task3.Services.DefaultConnectionManager;
import edu.hw2.Task3.Services.FaultyConnectionManager;
import edu.hw2.Task3.Services.PopularCommandExecutor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Tests {
    @Test
    @DisplayName("aLotOfAttemptsFaultyConnectionTest")
    void aLotOfAttemptsFaultyConnectionTest() {
        // Arrange
        PopularCommandExecutor executor = new PopularCommandExecutor(new FaultyConnectionManager(), 101);
        // Act
        boolean result = executor.tryExecute("something");

        // Assert
        assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("aLotOfAttemptsDefaultConnectionTest")
    void aLotOfAttemptsDefaultConnectionTest() {
        for (int i = 0; i < 1000; i++) {
            // Arrange
            PopularCommandExecutor executor = new PopularCommandExecutor(new DefaultConnectionManager(), 101);
            // Act
            boolean result = executor.tryExecute("something");

            // Assert
            assertThat(result).isEqualTo(true);
        }
    }

    @Test
    @DisplayName("aLotOfAttemptsDefaultConnectionTest")
    void faultyConnectionSometimesFails() {
        int counter = 0;
        for (int i = 0; i < 1000; i++) {
            // Arrange
            PopularCommandExecutor executor = new PopularCommandExecutor(new DefaultConnectionManager(), 1);
            // Act
            boolean result = executor.tryExecute("something");

            // Assert
            counter += result ? 1 : 0;
        }

        assertThat(counter).isGreaterThan(0);
    }
}
