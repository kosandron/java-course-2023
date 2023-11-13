package edu.hw5;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

public class Task8Tests {
    //1 subtask
    private static Stream<Arguments> paramsValidStringsSubtask1() {
        return Stream.of(
            Arguments.of("1"),
            Arguments.of("101"),
            Arguments.of("01101"),
            Arguments.of("0111001")
        );
    }

    @ParameterizedTest
    @MethodSource("paramsValidStringsSubtask1")
    void validStringsSubtask1(String string) {
        assertThat(Task8.lengthOdd(string)).isTrue();
    }

    private static Stream<Arguments> paramsInvalidStringsSubtask1() {
        return Stream.of(
            Arguments.of(""),
            Arguments.of("10"),
            Arguments.of("1111"),
            Arguments.of("110011")
        );
    }

    @ParameterizedTest
    @MethodSource("paramsInvalidStringsSubtask1")
    void invalidStringsSubtask1(String string) {
        assertThat(Task8.lengthOdd(string)).isFalse();
    }

    //2 subtask
    private static Stream<Arguments> paramsValidStringsSubtask2() {
        return Stream.of(
            Arguments.of("0"),
            Arguments.of("10"),
            Arguments.of("010"),
            Arguments.of("100101")
        );
    }

    @ParameterizedTest
    @MethodSource("paramsValidStringsSubtask2")
    void validStringsSubtask2(String string) {
        assertThat(Task8.beginWithZeroAndOddLengthOrBeginWithOneAndEvenLength(string)).isTrue();
    }

    private static Stream<Arguments> paramsInvalidStringsSubtask2() {
        return Stream.of(
            Arguments.of(""),
            Arguments.of("1"),
            Arguments.of("00"),
            Arguments.of("0110"),
            Arguments.of("101"),
            Arguments.of("10101")
        );
    }

    @ParameterizedTest
    @MethodSource("paramsInvalidStringsSubtask2")
    void invalidStringsSubtask2(String string) {
        assertThat(Task8.beginWithZeroAndOddLengthOrBeginWithOneAndEvenLength(string)).isFalse();
    }

    //3 subtask
    private static Stream<Arguments> paramsValidStringsSubtask3() {
        return Stream.of(
            Arguments.of(""),
            Arguments.of("11"),
            Arguments.of("10001"),
            Arguments.of("000"),
            Arguments.of("1010101")
        );
    }

    @ParameterizedTest
    @MethodSource("paramsValidStringsSubtask3")
    void validStringsSubtask3(String string) {
        assertThat(Task8.zeroCountDivisibleBy3(string)).isTrue();
    }

    private static Stream<Arguments> paramsInvalidStringsSubtask3() {
        return Stream.of(
            Arguments.of("0"),
            Arguments.of("110"),
            Arguments.of("010"),
            Arguments.of("0100100")
        );
    }

    @ParameterizedTest
    @MethodSource("paramsInvalidStringsSubtask3")
    void invalidStringsSubtask3(String string) {
        assertThat(Task8.zeroCountDivisibleBy3(string)).isFalse();
    }

    //4 subtask
    private static Stream<Arguments> paramsValidStringsSubtask4() {
        return Stream.of(
            Arguments.of(""),
            Arguments.of("110"),
            Arguments.of("1010"),
            Arguments.of("011"),
            Arguments.of("01001")
        );
    }

    @ParameterizedTest
    @MethodSource("paramsValidStringsSubtask4")
    void validStringsSubtask4(String string) {
        assertThat(Task8.not11or111(string)).isTrue();
    }

    private static Stream<Arguments> paramsInvalidStringsSubtask4() {
        return Stream.of(
            Arguments.of("11"),
            Arguments.of("111")
        );
    }

    @ParameterizedTest
    @MethodSource("paramsInvalidStringsSubtask4")
    void invalidStringsSubtask4(String string) {
        assertThat(Task8.not11or111(string)).isFalse();
    }

}
