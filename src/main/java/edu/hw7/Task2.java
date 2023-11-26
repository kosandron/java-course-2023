package edu.hw7;

import java.math.BigInteger;
import java.util.stream.LongStream;

public final class Task2 {
    private Task2() { }

    public static BigInteger factorial(int number) {
        if (number < 0) {
            return null;
        }
        if (number == 0) {
            return BigInteger.ONE;
        }

        return LongStream
            .rangeClosed(1, number)
            .parallel()
            .mapToObj(BigInteger::valueOf)
            .reduce(BigInteger.ONE, BigInteger::multiply);
    }
}
