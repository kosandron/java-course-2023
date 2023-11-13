package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Task4 {
    private static final String PASSWORD_REGEX = "[~!@#$%^&*|]";

    private Task4() {
    }

    public static boolean isValidPassword(String password) {
        if (password == null) {
            return false;
        }

        Pattern passwordPattern = Pattern.compile(PASSWORD_REGEX);
        Matcher matcher = passwordPattern.matcher(password);
        return matcher.find();
    }
}
