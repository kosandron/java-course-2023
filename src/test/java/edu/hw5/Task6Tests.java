package edu.hw5;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

public class Task6Tests {
    private static Stream<Arguments> paramsWithSubstring() {
        return Stream.of(
            Arguments.of("", ""),
            Arguments.of("", "abc"),
            Arguments.of("e", "e"),
            Arguments.of("abc", "jhvhbhyabczxcvbjbnujnm"),
            Arguments.of("res", "reshjvhj"),
            Arguments.of("qwe", "hbvyuqwe"),
            Arguments.of("abc", "ahbgdcu")
        );
    }

    @ParameterizedTest
    @MethodSource("paramsWithSubstring")
    void testHasSubstring(String pattern, String string) {
        assertThat(Task6.hasSubstring(pattern, string)).isTrue();
    }

    private static Stream<Arguments> paramsNotSubstring() {
        return Stream.of(
            Arguments.of("a", ""),
            Arguments.of("cde", "cd"),
            Arguments.of("dccd", "dabcd"),
            Arguments.of("dc", "cd"),
            Arguments.of("a", "bcdefg")
        );
    }

    @ParameterizedTest
    @MethodSource("paramsNotSubstring")
    void testNotSubstring(String pattern, String string) {
        assertThat(Task6.hasSubstring(pattern, string)).isFalse();
    }
}
