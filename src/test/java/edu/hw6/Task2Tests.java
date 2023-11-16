package edu.hw6;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task2Tests {
    private final static String TEST_DIRECTORY_PATH = "src/test/java/edu/hw6/files/Task2/";

    @BeforeEach
    @AfterEach
    public void clearTestDirectory() {
        try (Stream<Path> stream = Files.list(Path.of(TEST_DIRECTORY_PATH))) {
            stream.filter(p -> p.getFileName().toString().contains(FileCloner.COPY_ENDING))
                .forEach(p -> {
                        try {
                            Files.delete(p);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void copyNotExistFileTest() {
        Path p = Path.of(TEST_DIRECTORY_PATH + "notFoundFile.txt");
        assertThrows(RuntimeException.class, () -> FileCloner.cloneFile(p));
    }

    @Test
    void copyFileWithExtensionTest() {
        Path path = Path.of(TEST_DIRECTORY_PATH + "myFile1.txt");
        Path pathAnswerFirstCopy = Path.of(TEST_DIRECTORY_PATH + "myFile1" + FileCloner.COPY_ENDING + ".txt");
        Path pathAnswerSecondCopy = Path.of(TEST_DIRECTORY_PATH + "myFile1" + FileCloner.COPY_ENDING + " (1).txt");

        FileCloner.cloneFile(path);
        FileCloner.cloneFile(path);

        assertThat(Files.exists(pathAnswerFirstCopy)).isTrue();
        assertThat(Files.exists(pathAnswerSecondCopy)).isTrue();
    }

    @Test
    void copyFileWithoutExtensionTest() throws IOException {
        Path path = Path.of(TEST_DIRECTORY_PATH + "myFile2");
        Path pathAnswer = Path.of(TEST_DIRECTORY_PATH + "myFile2" + FileCloner.COPY_ENDING);

        FileCloner.cloneFile(path);

        assertThat(Files.exists(pathAnswer)).isTrue();
        assertThat(Files.readAllLines(pathAnswer)).isEqualTo(Files.readAllLines(path));
    }
}
