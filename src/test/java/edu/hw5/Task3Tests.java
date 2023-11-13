package edu.hw5;

import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Stream;
import edu.hw5.Task3.DateMonthYearParser;
import edu.hw5.Task3.DaysAndWordParser;
import edu.hw5.Task3.TimeParser;
import edu.hw5.Task3.WordDateParser;
import edu.hw5.Task3.YearMonthDateParser;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

public class Task3Tests {
    private static Stream<Arguments> paramsDate() {
        return Stream.of(
            Arguments.of("TodAy", Optional.of(LocalDate.now())),
            Arguments.of("Yesterday", Optional.of(LocalDate.now().minusDays(1))),
            Arguments.of("TOMORROW", Optional.of(LocalDate.now().plusDays(1))),
            Arguments.of("2026-09-15", Optional.of(LocalDate.of(2026, 9, 15))),
            Arguments.of("2029-04-09", Optional.of(LocalDate.of(2029, 4, 9))),
            Arguments.of("5/1/1955", Optional.of(LocalDate.of(1955, 1, 5))),
            Arguments.of("1 day ago", Optional.of(LocalDate.now().minusDays(1))),
            Arguments.of("1 week ago", Optional.of(LocalDate.now().minusWeeks(1))),
            Arguments.of("1 month ago", Optional.of(LocalDate.now().minusMonths(1))),
            Arguments.of("1 year ago", Optional.of(LocalDate.now().minusYears(1))),
            Arguments.of("1703 day ago", Optional.of(LocalDate.now().minusDays(1703))),
            Arguments.of("2090", Optional.empty()),
            Arguments.of("21 07 1676", Optional.empty()),
            Arguments.of(null, Optional.empty()),
            Arguments.of("", Optional.empty())
        );
    }

    @ParameterizedTest
    @MethodSource("paramsDate")
    void testDateParser(String date, Optional<LocalDate> answer) {
        // Assert
        assertThat(TimeParser.makeParsersChain(
            new DateMonthYearParser(),
            new YearMonthDateParser(),
            new WordDateParser(),
            new DaysAndWordParser()
        ).tryParse(date))
            .isEqualTo(answer);
    }
}
