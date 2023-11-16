package edu.hw6;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.assertj.core.api.Assertions.assertThat;

public class Task4Tests {
    private final static Path TEST_FILE_PATH = Path.of("src/test/java/edu/hw6/files/Task4/file.txt");

    @Test
    void outputWriterTest() throws IOException {
        // Arrange
        String input = "Programming is learned by writing programs. ― Brian Kernighan";

        // Act
        try (PrintWriter printWriter = OutputWriter.newOutputWriter(TEST_FILE_PATH)) {
            printWriter.println(input);
        } catch (IOException e) {
        }

        // Assert
        assertThat(1).isEqualTo(Files.readAllLines(TEST_FILE_PATH).size());
        assertThat(Files.readAllLines(TEST_FILE_PATH).get(0)).isEqualTo(input);
    }
}
