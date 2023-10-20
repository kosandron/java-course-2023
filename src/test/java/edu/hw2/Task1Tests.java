package edu.hw2;

import edu.hw2.Task1.Expr;
import edu.hw2.Task1.Expr.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.stream.Stream;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Tests {
    private static Stream<Arguments> checkAdditionTests() {
        return Stream.of(
            Arguments.of(new Constant(1.0), new Constant( 0), 1 + 0),
            Arguments.of(new Constant( -1.), new Constant( 0), -1),
            Arguments.of(new Constant(239.0), new Constant(12233429.), 12233429 + 239),
            Arguments.of(new Negate(new Constant(239.)), new Constant(12233429.), -239 + 12233429),
            Arguments.of(new Constant(239.0), new Negate(new Constant(12233429.)), 239 - 12233429)
        );
    }

    private static Stream<Arguments> checkMultiplicationTests() {
        return Stream.of(
            Arguments.of(new Constant(1.0), new Constant(0.), 1 * 0),
            Arguments.of(new Constant( -1.), new Constant( 0.), 0),
            Arguments.of(new Constant(23432.0), new Constant( 5334.), 23432 * 5334),
            Arguments.of(new Negate(new Constant(84375765.0)), new Constant( 67667.), -84375765 * 67667),
            Arguments.of(new Constant(4354), new Negate(new Constant(3748734.)), -67667 * 3748734)
        );
    }

    private static Stream<Arguments> checkExponentTests() {
        return Stream.of(
            Arguments.of(new Constant(4.), 0, 1),
            Arguments.of(new Constant((double) 12.), 0, 1),
            Arguments.of(new Constant(34.), 7.0, 34 ^ 7),
            Arguments.of(new Negate(new Constant(7.0)), -5, 7 ^ (-5)),
            Arguments.of(new Constant(-27.0), 9, -27 ^ 9),
            Arguments.of(new Constant(-9.0), 3, -9 ^ 3)
        );
    }

    @Test
    @DisplayName("Комбинированный тест")
    public void combinationTest() {
        var two = new Constant(2.0);
        var four = new Constant(4.0);
        var negOne = new Negate(new Constant(1.0));
        var sumTwoFour = new Addition(two, four);
        var mult = new Multiplication(sumTwoFour, negOne);
        var exp = new Exponent(mult, 2.0);
        var res = new Addition(exp, new Constant(1.0));

        assertThat((((2 + 4) * (-1)) ^ 2 + 1) == res.evaluate());
    }

    @ParameterizedTest
    @MethodSource("checkAdditionTests")
    public void checkAddition(Expr first, Expr second, double result) {
        // Arrange, Act
        Addition addition = new Addition(first, second);

        // Assert
        assertThat(result).isEqualTo(addition.evaluate());
    }

    @ParameterizedTest
    @MethodSource("checkMultiplicationTests")
    public void checkMultiplication(Expr first, Expr second, double result) {
        // Arrange, Act
        Multiplication multiplication = new Multiplication(first, second);

        // Assert
        assertThat(result).isEqualTo(multiplication.evaluate());
    }

    @ParameterizedTest
    @MethodSource("checkExponentTests")
    public void checkMultiplication(Expr first, double second, double result) {
        // Arrange, Act
        Exponent exponent = new Exponent(first, second);

        // Assert
        assertThat(result).isEqualTo(exponent.evaluate());
    }
}
