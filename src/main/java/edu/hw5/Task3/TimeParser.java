package edu.hw5.Task3;

import java.time.LocalDate;
import java.util.Optional;

public abstract class TimeParser {
    private TimeParser next;

    public static TimeParser makeParsersChain(TimeParser first, TimeParser... chain) {
        TimeParser head = first;
        for (TimeParser nextInChain : chain) {
            head.next = nextInChain;
            head = nextInChain;
        }

        return first;
    }

    public abstract Optional<LocalDate> tryParse(String date);

    protected Optional<LocalDate> parseNext(String date) {
        if (next == null) {
            return Optional.empty();
        }

        return next.tryParse(date);
    }
}
