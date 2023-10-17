package edu.hw2;

import edu.hw2.Task3.Exceptions.ConnectionException;
import edu.hw2.Task3.Services.FaultyConnectionManager;
import edu.hw2.Task3.Services.PopularCommandExecutor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Tests {
    @Test
    @DisplayName("Test")
    void goodManager() {
        // Arrange
        PopularCommandExecutor executor = new PopularCommandExecutor(new FaultyConnectionManager(), 2);
        // Act
        try {
            executor.tryExecute("blabla");
        } catch (ConnectionException e) {

        }



        // Assert
    }
}
