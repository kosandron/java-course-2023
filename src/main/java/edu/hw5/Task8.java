package edu.hw5;

public final class Task8 {
    private final static String REGEX1 = "^([01][01])*[01]$"; // нечетной длины

    private final static String REGEX2 = "0([01][01])*|1([01][01])*[01]";
        // начинается с 0 и имеет нечетную длину, или начинается с 1 и имеет четную длину

    private final static String REGEX3 = "^1*$|^(1*01*01*01*)*$"; // количество 0 кратно 3

    private final static String REGEX4 = "^(?!^111$|^11$)([01]*?)$"; // любая строка, кроме 11 или 111

    private Task8() {
    }

    public static boolean lengthOdd(String string) {
        if (string == null) {
            throw new NullPointerException();
        }

        return string.matches(REGEX1);
    }

    public static boolean beginWithZeroAndOddLengthOrBeginWithOneAndEvenLength(String string) {
        if (string == null) {
            throw new NullPointerException();
        }

        return string.matches(REGEX2);
    }

    public static boolean zeroCountDivisibleBy3(String string) {
        if (string == null) {
            throw new NullPointerException();
        }

        return string.matches(REGEX3);
    }

    public static boolean not11or111(String string) {
        if (string == null) {
            throw new NullPointerException();
        }

        return string.matches(REGEX4);
    }
}
