package edu.hw5;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task1Tests {
    private static Stream<Arguments> paramsValidArguments() {
        return Stream.of(
            Arguments.of(new String[] {"2023-03-12, 20:20 - 2023-03-12, 20:20"}, "0ч 0м"),
            Arguments.of(new String[] {"2023-03-12, 20:20 - 2023-03-12, 20:21"}, "0ч 1м"),
            Arguments.of(new String[] {"2023-03-12, 20:20 - 2023-03-12, 21:20"}, "1ч 0м"),
            Arguments.of(new String[] {
                "2023-03-12, 20:20 - 2023-03-12, 23:50",
                "2023-03-12, 20:20 - 2023-03-13, 20:20"},
                "13ч 45м"),
            Arguments.of(new String[] {
                "2023-03-12, 20:20 - 2023-03-13, 20:20",
                "2023-03-12, 20:20 - 2023-03-14, 20:25",
                "2023-03-12, 20:20 - 2023-03-12, 20:24"
            }, "24ч 3м")
        );
    }

    @ParameterizedTest
    @MethodSource("paramsValidArguments")
    void getDurationTest(String[] time, String answer) {
        String result = Task1.getAverageTime(time);

        assertThat(result).isEqualTo(answer);
    }

    private static Stream<Arguments> invalidFormat() {
        return Stream.of(
            Arguments.of((Object) null),
            Arguments.of((Object) new String[] {""}),
            Arguments.of((Object) new String[] {"2023-03-12, 20:20"}),
            Arguments.of((Object) new String[] {"2023-03-12, 20:20 -- 2023-03-12, 20:21"}),
            Arguments.of((Object) new String[] {"2023-03-12 20:20 - 2023-03-12 21:20"}),
            Arguments.of((Object) new String[] {"20:20, 2023-03-12 - 23:50, 2023-03-12"}),
            Arguments.of((Object) new String[] {"2021-01-99, 20:20 - 2023-01-99, 21:20"}),
            Arguments.of((Object) new String[] {"2023-29-01, 21:20 - 2023-56-01, 23:20"}),
            Arguments.of((Object) new String[] {"2023-03-12, 99:20 - 2023-03-14, 00:25"}),
            Arguments.of((Object) new String[] {"2023-03-12, 11:34 - 2023-03-14, 23:61"})
        );
    }

    @ParameterizedTest
    @MethodSource("invalidFormat")
    void getDurationFromInvalidDateTime(String[] invalidTime) {
        assertThrows(Exception.class, () -> Task1.getAverageTime(invalidTime));
    }
}
