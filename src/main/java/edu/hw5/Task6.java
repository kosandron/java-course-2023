package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Task6 {
    private Task6() {
    }

    public static boolean hasSubstring(String pattern, String string) {
        if (pattern == null) {
            throw new NullPointerException();
        }

        if (string == null) {
            throw new NullPointerException();
        }

        Pattern patternRegex = Pattern.compile(pattern);
        Matcher matcher = patternRegex.matcher(string);
        return matcher.find();
    }
}
