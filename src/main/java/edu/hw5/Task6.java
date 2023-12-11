package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Task6 {
    private final static String DELIMETR = ".*";

    private Task6() {
    }

    public static boolean hasSubstring(String pattern, String string) {
        if (pattern == null) {
            throw new NullPointerException();
        }

        if (string == null) {
            throw new NullPointerException();
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(DELIMETR);

        for (char ch : pattern.toCharArray()) {
            stringBuilder.append(ch);
            stringBuilder.append(DELIMETR);
        }

        Pattern patternRegex = Pattern.compile(stringBuilder.toString());
        Matcher matcher = patternRegex.matcher(string);
        return matcher.matches();
    }
}
