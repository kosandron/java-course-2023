package edu.hw6;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task1Tests {
    private final static String TEST_DIRECTORY_PATH = "src/test/java/edu/hw6/files/Task1/";

    @BeforeEach
    @AfterEach
    public void clearTestDirectory() {
        try (Stream<Path> stream = Files.list(Path.of(TEST_DIRECTORY_PATH))) {
            stream.filter(p -> p.getFileName().toString().contains("Test"))
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
    void loadFromFileTest() throws IOException {
        // Arrange
        String expectedFileName = "MapExample.map";
        String fileName = "MapExampleCopy.map";

        // Act
        DiskMap diskMap = new DiskMap(TEST_DIRECTORY_PATH + fileName);
        Path filePath = Path.of(TEST_DIRECTORY_PATH + fileName);

        // Assert
        assertThat(Files.exists(filePath)).isTrue();
        assertThat(diskMap.size()).isEqualTo(3);
        assertThat(Files.readAllLines(filePath)).isEqualTo(Files.readAllLines(Path.of(TEST_DIRECTORY_PATH + expectedFileName)));
    }

    @Test
    void putTest() throws IOException {
        // Arrange
        String fileName = "putTest.map";
        DiskMap diskMap = new DiskMap(TEST_DIRECTORY_PATH + fileName);
        Path filePath = Path.of(TEST_DIRECTORY_PATH + fileName);

        // Act
        String putResult1 = diskMap.put("key1", "value1");
        String putResult2 = diskMap.put("key2", "value2");
        String putResult3 = diskMap.put("key1", "value3");

        // Assert
        assertThat(putResult1).isNull();
        assertThat(putResult2).isNull();
        assertThat(putResult3).isEqualTo("value1");

        assertThat(Files.exists(filePath)).isTrue();
        assertThat(Files.readAllLines(filePath)).hasSameElementsAs(List.of("key2" + DiskMap.SPLITTER + "value2", "key1" + DiskMap.SPLITTER + "value3"));
    }

    @Test
    void putAllTest() throws IOException {
        // Arrange
        String fileName = "putAllTest.map";
        DiskMap diskMap = new DiskMap(TEST_DIRECTORY_PATH + fileName);
        Map<String, String> expectedMap = Map.of(
            "key1", "value1",
            "key2", "value2"
        );
        Path filePath = Path.of(TEST_DIRECTORY_PATH + fileName);

        // Act
        diskMap.putAll(expectedMap);

        // Assert
        assertThat(Files.exists(filePath)).isTrue();
        assertThat(Files.readAllLines(filePath)).hasSameElementsAs(List.of("key1" + DiskMap.SPLITTER + "value1", "key2" + DiskMap.SPLITTER + "value2"));
    }

    @Test
    void removeTest() throws IOException {
        // Arrange
        String fileName = "removeTest.map";
        Path filePath = Path.of(TEST_DIRECTORY_PATH + fileName);
        Files.copy(Path.of(TEST_DIRECTORY_PATH + "MapExample.map"), filePath);
        DiskMap diskMap = new DiskMap(TEST_DIRECTORY_PATH + fileName);

        // Act
        diskMap.remove("key1");
        diskMap.remove("key2");
        diskMap.remove("key3");

        // Assert
        assertThat(Files.exists(filePath)).isTrue();
        assertThat(Files.readAllLines(filePath)).isEmpty();
    }

    @Test
    void clearTest() throws IOException {
        // Arrange
        String fileName = "clearTest.map";
        Path filePath = Path.of(TEST_DIRECTORY_PATH + fileName);
        Files.copy(Path.of(TEST_DIRECTORY_PATH + "MapExample.map"), filePath);
        DiskMap diskMap = new DiskMap(TEST_DIRECTORY_PATH + fileName);

        // Act
        diskMap.clear();

        // Assert
        assertThat(Files.exists(filePath)).isTrue();
        assertThat(Files.readAllLines(filePath)).isEmpty();
    }

    @Test
    void keySetTest() throws IOException {
        // Arrange
        String fileName = "keySetTest.map";
        Path filePath = Path.of(TEST_DIRECTORY_PATH + fileName);
        Files.copy(Path.of(TEST_DIRECTORY_PATH + "MapExample.map"), filePath);
        DiskMap diskMap = new DiskMap(TEST_DIRECTORY_PATH + fileName);

        // Act, Assert
        assertThat(Files.exists(filePath)).isTrue();
        assertThat(diskMap.keySet()).isEqualTo(Set.of("key1", "key2", "key3"));
    }

    @Test
    void valuesTest() throws IOException {
        // Arrange
        String fileName = "valuesTest.map";
        Path filePath = Path.of(TEST_DIRECTORY_PATH + fileName);
        Files.copy(Path.of(TEST_DIRECTORY_PATH + "MapExample.map"), filePath);
        DiskMap diskMap = new DiskMap(TEST_DIRECTORY_PATH + fileName);

        // Act, Assert
        assertThat(Files.exists(filePath)).isTrue();
        assertThat(diskMap.values()).hasSameElementsAs(List.of("value1", "value2", "value3"));
    }

    @Test
    void getTest() throws IOException {
        // Arrange
        String fileName = "getTest.map";
        Path filePath = Path.of(TEST_DIRECTORY_PATH + fileName);
        Files.copy(Path.of(TEST_DIRECTORY_PATH + "MapExample.map"), filePath);
        DiskMap diskMap = new DiskMap(TEST_DIRECTORY_PATH + fileName);

        // Act, Assert
        assertThat(Files.exists(filePath)).isTrue();
        assertThat(diskMap.get("key1")).isEqualTo("value1");
        assertThat(diskMap.get("key3")).isEqualTo("value3");
        assertThat(diskMap.get("key2")).isEqualTo("value2");
        assertThrows(NoSuchElementException.class, () -> diskMap.get("unknownKey"));
    }

    @Test
    void containsTest() throws IOException {
        // Arrange
        String fileName = "containsTest.map";
        Path filePath = Path.of(TEST_DIRECTORY_PATH + fileName);
        Files.copy(Path.of(TEST_DIRECTORY_PATH + "MapExample.map"), filePath);
        DiskMap diskMap = new DiskMap(TEST_DIRECTORY_PATH + fileName);

        // Act, Assert
        assertThat(Files.exists(filePath)).isTrue();
        assertThat(diskMap.containsKey("key1")).isTrue();
        assertThat(diskMap.containsKey("key2")).isTrue();
        assertThat(diskMap.containsKey("key3")).isTrue();
        assertThat(diskMap.containsKey("unknownKey")).isFalse();

        assertThat(diskMap.containsValue("value1")).isTrue();
        assertThat(diskMap.containsValue("value2")).isTrue();
        assertThat(diskMap.containsValue("value3")).isTrue();
        assertThat(diskMap.containsValue("unknownValue")).isFalse();
    }
}
