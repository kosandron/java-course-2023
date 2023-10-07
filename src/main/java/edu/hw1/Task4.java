package edu.hw1;

public final class Task4 {
    private Task4() {
    }

    public static String fixString(String str) {
        if (str == null) {
            throw new NullPointerException();
        }

        StringBuilder buffer = new StringBuilder(str);
        for (int i = 0; i < (str.length() / 2) * 2; i++) {
            if (i % 2 == 0) {
                buffer.setCharAt(i + 1, str.charAt(i));
            } else {
                buffer.setCharAt(i - 1, str.charAt(i));
            }
        }

        return buffer.toString();
    }
}
