package edu.hw5;

public final class Task7 {
    private static final String THIRD_CHAR_NULL_REGEX = "^[01]{2}0[01]*$";
    private static final String START_AND_ENDS_SAME_CHAR_REGEX = "0|1|^0[01]*0$|^1[01]*1$";
    private static final String LENGTH_REGEX = "^[01]{1,3}$";

    private Task7() {
    }

    public static boolean moreThanThreeCharsThirdIsZero(String string) {
        return string.matches(THIRD_CHAR_NULL_REGEX);
    }

    public static boolean startsAndEndsWithSameChar(String string) {
        return string.matches(START_AND_ENDS_SAME_CHAR_REGEX);
    }

    public static boolean lengthIsBetweenOneAndThree(String string) {
        return string.matches(LENGTH_REGEX);
    }
}
