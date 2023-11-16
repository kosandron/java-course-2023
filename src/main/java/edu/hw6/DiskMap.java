package edu.hw6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DiskMap implements Map<String, String> {
    private final static String TEMPLATE_NAME = "DiskMap.txt";
    public final static String SPLITTER = "~";

    private final String filePath;

    public DiskMap() {
        this(TEMPLATE_NAME);
    }

    public DiskMap(String filePath) {
        this.filePath = filePath;
        File file = new File(filePath);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int size() {
        int lineCount;
        try (Stream<String> stream = Files.lines(Path.of(filePath))) {
            lineCount = (int) stream.count();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return lineCount;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        if (!(key instanceof String)) {
            return false;
        }

        try (Stream<String> stream = Files.lines(Path.of(filePath))) {
            return stream.anyMatch(keyValueLine -> keyValueLine.startsWith(key + SPLITTER));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean containsValue(Object value) {
        if (!(value instanceof String)) {
            return false;
        }

        try (Stream<String> stream = Files.lines(Path.of(filePath))) {
            return stream.anyMatch(keyValueLine -> keyValueLine.endsWith(SPLITTER + value));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String get(Object key) {
        if (!(key instanceof String)) {
            throw new IllegalArgumentException();
        }

        try (Stream<String> stream = Files.lines(Path.of(filePath))) {
            return stream
                .filter(keyValueLine -> keyValueLine.startsWith(key.toString() + SPLITTER))
                .findFirst()
                .orElseThrow(NoSuchElementException::new)
                .split(SPLITTER)[1];
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Nullable
    @Override
    public String put(String key, String value) {
        String oldValue = remove(key);

        try {
            Files.write(Paths.get(filePath), (key + SPLITTER + value + '\n').getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return oldValue;
    }

    @Override
    public String remove(Object key) {
        if (!(key instanceof String)) {
            throw new IllegalArgumentException();
        }

        File inputFile = new File(filePath);
        File tempFile = new File(filePath + "temp");

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String removedValue = null;
            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                String trimmedLine = currentLine.trim();
                if (trimmedLine.startsWith(key.toString())) {
                    removedValue = trimmedLine.split(SPLITTER)[1];
                    continue;
                }
                writer.write(currentLine + '\n');
            }

            writer.close();
            reader.close();
            Files.delete(inputFile.toPath());
            tempFile.renameTo(inputFile);
            return removedValue;
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    public void putAll(@NotNull Map<? extends String, ? extends String> map) {
        for (var keyValueLine : map.entrySet()) {
            put(keyValueLine.getKey(), keyValueLine.getValue());
        }
    }

    @Override
    public void clear() {
        try {
            new PrintWriter(filePath).close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @NotNull
    @Override
    public Set<String> keySet() {
        try (Stream<String> stream = Files.lines(Path.of(filePath))) {
            return stream.map(keyValueLine -> keyValueLine.split(SPLITTER)[0]).collect(Collectors.toSet());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @NotNull
    @Override
    public Collection<String> values() {
        try (Stream<String> stream = Files.lines(Path.of(filePath))) {
            return stream.map(keyValueLine -> keyValueLine.split(SPLITTER)[1]).collect(Collectors.toSet());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @NotNull
    @Override
    public Set<Entry<String, String>> entrySet() {
        try (Stream<String> stream = Files.lines(Path.of(filePath))) {
            return stream
                .map(keyValueLine -> {
                        String[] split = keyValueLine.split(SPLITTER);
                        return Map.entry(split[0], split[1]);
                    }
                )
                .collect(Collectors.toSet());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
