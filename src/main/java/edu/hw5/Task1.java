package edu.hw5;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class Task1 {
    private final static String DATE_TIME_PATTERN = "yyyy-MM-dd, HH:mm";
    private final static String SPLITTER = " - ";
    private final static String TIME_REGEX = "\\d{4}-\\d{2}-\\d{2}, \\d{2}:\\d{2}";
    private final static String INPUT_TIME_REGEX = TIME_REGEX + SPLITTER + TIME_REGEX;

    private Task1() {
    }

    public static String getTimeDifference(String time) {
        if (time == null) {
            throw new NullPointerException();
        }

        if (!time.matches(INPUT_TIME_REGEX)) {
            throw new IllegalArgumentException();
        }

        String[] times = time.split(SPLITTER);
        String start = times[0];
        String finish = times[1];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_TIME_PATTERN);

        return Duration
            .between(LocalDateTime.parse(start, formatter), LocalDateTime.parse(finish, formatter))
            .toString();
    }
}
