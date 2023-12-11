package edu.hw5;

public final class Task5 {
    private static final String RUSSIAN_NUMBER_REGEX =
        "[ABCEHKMOPTXY]\\d{3}[ABCEHKMOPTXY]{2}(\\d{2,3}$)";

    private Task5() {
    }

    public static boolean isValidRussianNumber(String number) {
        if (number == null) {
            throw new NullPointerException();
        }

        return number.matches(RUSSIAN_NUMBER_REGEX);
    }
}
