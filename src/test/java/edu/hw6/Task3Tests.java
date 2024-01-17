package edu.hw6;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import static edu.hw6.AbstractFilter.globMatches;
import static edu.hw6.AbstractFilter.largerThan;
import static edu.hw6.AbstractFilter.magicNumber;
import static org.assertj.core.api.Assertions.assertThat;

public class Task3Tests {
    private final static String TEST_DIRECTORY_PATH = "src/test/java/edu/hw6/files/Task3/";

    @Test
    void readableTest() {
        AbstractFilter filter = Files::isReadable;

        try (DirectoryStream<Path> entries = Files.newDirectoryStream(Path.of(TEST_DIRECTORY_PATH), filter)) {
            assertThat(entries).hasSameElementsAs(
                List.of(
                    Path.of(TEST_DIRECTORY_PATH + "file"),
                    Path.of(TEST_DIRECTORY_PATH + "fileWithExtension.txt"),
                    Path.of(TEST_DIRECTORY_PATH + "WordFile.docx")
                )
            );
        } catch (IOException e) {
        }
    }

    @Test
    void bigFileTest() {
        AbstractFilter filter = largerThan(10);

        try (DirectoryStream<Path> entries = Files.newDirectoryStream(Path.of(TEST_DIRECTORY_PATH), filter)) {
            assertThat(entries).hasSameElementsAs(
                List.of(
                    Path.of(TEST_DIRECTORY_PATH + "fileWithExtension.txt"),
                    Path.of(TEST_DIRECTORY_PATH + "WordFile.docx")
                )
            );
        } catch (IOException e) {
        }
    }

    @Test
    void globTest() {
        AbstractFilter filter = globMatches("*.docx");

        try (DirectoryStream<Path> entries = Files.newDirectoryStream(Path.of(TEST_DIRECTORY_PATH), filter)) {
            assertThat(entries).hasSameElementsAs(
                List.of(
                    Path.of(TEST_DIRECTORY_PATH + "WordFile.docx")
                )
            );
        } catch (IOException e) {
        }
    }

    @Test
    void magicNumberTest() {
        AbstractFilter filter = magicNumber(
            (byte) 0x89, (byte) 'C', (byte) 'o', (byte) 'd', (byte) 'e' , (byte) '9', (byte) '0', (byte) '9');

        try (DirectoryStream<Path> entries = Files.newDirectoryStream(Path.of(TEST_DIRECTORY_PATH), filter)) {
            assertThat(entries).hasSameElementsAs(
                List.of(
                    Path.of(TEST_DIRECTORY_PATH + "WordFile.docx")
                )
            );
        } catch (IOException e) {
        }
    }

    @Test
    void methodCombinationTest() {
        AbstractFilter regularFile = Files::isRegularFile;
        AbstractFilter readable = Files::isReadable;

        DirectoryStream.Filter<Path> filter = regularFile
            .and(readable)
            .and(largerThan(1000))
            .and(magicNumber(
                (byte) 0x89, (byte) 'C', (byte) 'o', (byte) 'd', (byte) 'e' , (byte) '9', (byte) '0', (byte) '9'))
            .and(globMatches("*.docx"));

        try (DirectoryStream<Path> entries = Files.newDirectoryStream(Path.of(TEST_DIRECTORY_PATH), filter)) {
            assertThat(entries).containsExactly(Path.of(TEST_DIRECTORY_PATH + "WordFile.docx"));
        } catch (IOException ignored) {
        }
    }
}
