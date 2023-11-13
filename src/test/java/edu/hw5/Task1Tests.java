package edu.hw5;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task1Tests {
    private static Stream<Arguments> paramsTimeWithDuration() {
        return Stream.of(
            Arguments.of("2023-03-12, 20:20 - 2023-03-12, 20:20", "PT0S"),
            Arguments.of("2023-03-12, 20:20 - 2023-03-12, 20:21", "PT1M"),
            Arguments.of("2023-03-12, 20:20 - 2023-03-12, 21:20", "PT1H"),
            Arguments.of("2023-03-12, 20:20 - 2023-03-12, 23:50", "PT3H30M"),
            Arguments.of("2023-03-12, 20:20 - 2023-03-13, 20:20", "PT24H"),
            Arguments.of("2023-03-12, 20:20 - 2023-03-14, 20:25", "PT48H5M"),
            Arguments.of("2023-03-12, 20:20 - 2023-04-12, 20:20", "PT744H")
        );
    }

    @ParameterizedTest
    @MethodSource("paramsTimeWithDuration")
    void getDurationTest(String time, String answer) {
        String result = Task1.getTimeDifference(time);

        assertThat(result).isEqualTo(answer);
    }

    private static Stream<Arguments> invalidFormat() {
        return Stream.of(
            Arguments.of((Object) null),
            Arguments.of(""),
            Arguments.of("2023-03-12, 20:20"),
            Arguments.of("2023-03-12, 20:20 -- 2023-03-12, 20:21"),
            Arguments.of("2023-03-12 20:20 - 2023-03-12 21:20"),
            Arguments.of("20:20, 2023-03-12 - 23:50, 2023-03-12"),
            Arguments.of("2021-01-99, 20:20 - 2023-01-99, 21:20"),
            Arguments.of("2023-29-01, 21:20 - 2023-56-01, 23:20"),
            Arguments.of("2023-03-12, 99:20 - 2023-03-14, 00:25"),
            Arguments.of("2023-03-12, 11:34 - 2023-03-14, 23:61")
        );
    }

    @ParameterizedTest
    @MethodSource("invalidFormat")
    void getDurationFromInvalidDateTime(String invalidTime) {
        assertThrows(Exception.class, () -> Task1.getTimeDifference(invalidTime));
    }
}
