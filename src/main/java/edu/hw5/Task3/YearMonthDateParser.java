package edu.hw5.Task3;

import java.time.LocalDate;
import java.util.Optional;

public class YearMonthDateParser extends TimeParser {
    private final static String PARSING_REGEX = "\\d{4}-\\d{2}-\\d{2}";

    @Override
    public Optional<LocalDate> tryParse(String date) {
        if (date == null || !date.matches(PARSING_REGEX)) {
            return parseNext(date);
        }

        return Optional.of(LocalDate.parse(date));
    }
}
