package edu.hw3;

public final class Task1 {
    private static final int FIRST_LATIN_ASCII_SMALL_CHAR_INDEX = 65;
    private static final int LAST_LATIN_ASCII_SMALL_CHAR_INDEX = 90;
    private static final int FIRST_LATIN_ASCII_BIG_CHAR_INDEX = 97;
    private static final int LAST_LATIN_ASCII_BIG_CHAR_INDEX = 122;

    private Task1() {
    }

    public static String atbash(String str) {
        StringBuilder builder = new StringBuilder(str);
        for (int i = 0; i < str.length(); i++) {
            if (isLatin(str.charAt(i))) {
                if (str.charAt(i) == str.toUpperCase().charAt(i)) {
                    builder.replace(i, i + 1, Character.toString('Z' - (str.charAt(i) - 'A')));
                } else {
                    builder.replace(i, i + 1, Character.toString('z' - (str.charAt(i) - 'a')));
                }
            }
        }

        return builder.toString();
    }

    private static boolean isLatin(char index) {
        return (index >= FIRST_LATIN_ASCII_SMALL_CHAR_INDEX
            && index <= LAST_LATIN_ASCII_SMALL_CHAR_INDEX)
            || (index >= FIRST_LATIN_ASCII_BIG_CHAR_INDEX
            && index <= LAST_LATIN_ASCII_BIG_CHAR_INDEX);
    }
}
