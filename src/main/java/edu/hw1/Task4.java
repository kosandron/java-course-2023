package edu.hw1;

public final class Task4 {
    private Task4() { }

    public static String fixString(String str) {
        if (str == null) {
            throw new NullPointerException();
        }

        StringBuffer buffer = new StringBuffer(str);
        for (int i = 0; i < str.length() - 1; i += 2) {
            buffer.setCharAt(i + 1, str.charAt(i));
        }
        for (int i = 1; i < str.length(); i += 2) {
            buffer.setCharAt(i - 1, str.charAt(i));
        }

        return buffer.toString();
    }
}
