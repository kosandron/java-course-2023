package edu.hw5;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

public class Task5Tests {
    private static Stream<Arguments> paramsValidNumber() {
        return Stream.of(
            Arguments.of("A456BC134"),
            Arguments.of("E565XM178"),
            Arguments.of("Y798CT789"),
            Arguments.of("Y798CT89")
        );
    }

    @ParameterizedTest
    @MethodSource("paramsValidNumber")
    void testValidPassword(String validNumber) {
        assertThat(Task5.isValidRussianNumber(validNumber)).isTrue();
    }

    private static Stream<Arguments> paramsInvalidNumber() {
        return Stream.of(
            Arguments.of(""),
            Arguments.of("079АВЕ586"),
            Arguments.of("A791ВЕ8A6"),
            Arguments.of("А264ВЕ6767"),
            Arguments.of("АB346Е989"),
            Arguments.of("У079Лв565"),
            Arguments.of("А565УЦ98"),
            Arguments.of("О09ОО99"),
            Arguments.of("А788ВС8756")
        );
    }

    @ParameterizedTest
    @MethodSource("paramsInvalidNumber")
    void testInvalidPassword(String invalidNumber) {
        assertThat(Task5.isValidRussianNumber(invalidNumber)).isFalse();
    }
}
