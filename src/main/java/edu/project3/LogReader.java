package edu.project3;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class LogReader {
    private final static Logger LOGGER = LogManager.getLogger();
    private static final int TIMEOUT = 20;

    private LogReader() {
    }

    public static List<Log> getLogs(Settings settings) {
        List<Log> logs = new ArrayList<>();
        for (String path : settings.path()) {
            if (path.startsWith("http")) {
                logs.addAll(parseFromStringsList(getLogStringsFromURL(path), settings));
            } else {
                try {
                    logs.addAll(parseFromStringsList((Files.readAllLines(Path.of(path))), settings));
                } catch (IOException e) {
                    LOGGER.error("Bad path error: " + e);
                }
            }
        }

        return logs;
    }

    private static List<String> getLogStringsFromURL(String path) {
        try {
            HttpClient client = HttpClient.newBuilder().build();
            var request = HttpRequest.newBuilder()
                .uri(URI.create(path))
                .timeout(Duration.ofSeconds(TIMEOUT))
                .GET()
                .build();
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return Arrays.stream(response.body().split("\n")).toList();
        } catch (Exception e) {
            LOGGER.error("Bad URL error: " + e);
            throw new RuntimeException(e);
        }
    }

    private static List<Log> parseFromStringsList(List<String> strings, Settings settings) {
        List<Log> logs = new ArrayList<>();
        for (String line : strings) {
            Log newLog = Log.parse(line);
            if (isDateBetween(newLog.timeLocal().toLocalDate(), settings.fromDate(), settings.toDate())) {
                logs.add(newLog);
            }
        }

        return logs;
    }

    private static boolean isDateBetween(LocalDate date, LocalDate start, LocalDate finish) {
        return date.isAfter(start) && date.isBefore(finish);
    }
}
