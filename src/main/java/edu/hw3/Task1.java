package edu.hw3;

public final class Task1 {

    private Task1() {
    }

    public static String atbash(String str) {
        StringBuilder builder = new StringBuilder(str);
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                if (str.charAt(i) == str.toUpperCase().charAt(i)) {
                    builder.replace(i, i + 1, Character.toString('Z' - (str.charAt(i) - 'A')));
                } else {
                    builder.replace(i, i + 1, Character.toString( 'z' - (str.charAt(i) - 'a')));
                }
            }
        }

        return builder.toString();
    }
}
