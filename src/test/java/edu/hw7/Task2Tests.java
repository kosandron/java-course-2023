package edu.hw7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.math.BigInteger;
import static org.assertj.core.api.Assertions.assertThat;

public class Task2Tests {
    @Test
    @DisplayName("Factorial of positive number")
    public void positiveNumberFactorial() {
        for (int i = 1; i < 100; i++) {
            BigInteger factorialOfNum = BigInteger.ONE;
            for (int j = 1; j <= i; j++) {
                factorialOfNum = factorialOfNum.multiply(BigInteger.valueOf(j));
            }

            BigInteger result = Task2.factorial(i);

            assertThat(result).isNotNull();
            assertThat(result).isEqualTo(factorialOfNum);
        }
    }

    @Test
    @DisplayName("Factorial of zero")
    public void zeroFactorial() {
        int num = 0;
        BigInteger answer = BigInteger.ONE;

        BigInteger result = Task2.factorial(num);

        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(answer);
    }

    @Test
    @DisplayName("Factorial of negative number")
    public void negativeNumberFactorial() {
        for (int i = -100; i < 0; i++) {
            BigInteger result = Task2.factorial(i);
            assertThat(result).isNull();
        }
    }
}
