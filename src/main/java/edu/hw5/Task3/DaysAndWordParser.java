package edu.hw5.Task3;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Optional;

public class DaysAndWordParser extends TimeParser {
    private final static String PARSING_REGEX = "-?\\d+ (days?|weeks?|months?|years?) (ago|after)";

    @Override
    public Optional<LocalDate> tryParse(String date) {
        if (date == null || !date.toLowerCase().matches(PARSING_REGEX)) {
            return parseNext(date);
        }

        String[] dateArray = date.toLowerCase().split(" ");
        int count = Integer.parseInt(dateArray[0]);
        String timeLength = dateArray[1];
        TemporalUnit unit = switch (timeLength) {
            case "day", "days" -> ChronoUnit.DAYS;
            case "month", "months" -> ChronoUnit.MONTHS;
            case "year", "years" -> ChronoUnit.YEARS;
            case "week", "weeks" -> ChronoUnit.WEEKS;
            default -> ChronoUnit.valueOf(timeLength);
        };

        String direction = dateArray[2];
        return switch (direction) {
            case "ago" -> Optional.of(LocalDate.now().minus(count, unit));
            case "after" -> Optional.of(LocalDate.now().plus(count, unit));
            default -> parseNext(date);
        };
    }
}
