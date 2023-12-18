package edu.hw5;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

public class Task4Tests {
    private static Stream<Arguments> paramsValidPasswords() {
        return Stream.of(
            Arguments.of("~"),
            Arguments.of("!password"),
            Arguments.of("password@"),
            Arguments.of("#$%"),
            Arguments.of("#$password%^"),
            Arguments.of("password~password"),
            Arguments.of("password!password"),
            Arguments.of("password@password"),
            Arguments.of("password#password"),
            Arguments.of("password$password"),
            Arguments.of("password%password"),
            Arguments.of("password^password"),
            Arguments.of("password&password"),
            Arguments.of("password*password"),
            Arguments.of("password|password")
        );
    }

    @ParameterizedTest
    @MethodSource("paramsValidPasswords")
    void testValidPassword(String validPassword) {
        assertThat(Task4.isValidPassword(validPassword)).isTrue();
    }

    private static Stream<Arguments> paramsInvalidPasswords() {
        return Stream.of(
            Arguments.of((Object) null),
            Arguments.of(""),
            Arguments.of("avrbc"),
            Arguments.of("34443"),
            Arguments.of("bg/b"),
            Arguments.of("№12"),
            Arguments.of("../3/.")
        );
    }

    @ParameterizedTest
    @MethodSource("paramsInvalidPasswords")
    void testInvalidPassword(String invalidPassword) {
        assertThat(Task4.isValidPassword(invalidPassword)).isFalse();
    }
}
