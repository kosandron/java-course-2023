package edu.hw1;

public final class Task1 {

    private Task1() {
    }

    @SuppressWarnings({"MagicNumber", "ReturnCount"})
    public static boolean isValid(String str) {
        if (str == null) {
            return false;
        }
        boolean wasDelimetr = false;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ':') {
                if (wasDelimetr || i == str.length() - 1 || i < 2 || i + 3 != str.length()) {
                    return false;
                }
                wasDelimetr = true;
            } else if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        if (!wasDelimetr) {
            return false;
        }

        return true;
    }

    @SuppressWarnings("MagicNumber")
    public static int minutesToSeconds(String str) {
        if (!isValid(str)) {
            return -1;
        }

        boolean delimetr = false;
        int answer = 0;
        String[] time = str.split(":");
        int minutes = Integer.parseInt(time[0]);
        int seconds = Integer.parseInt(time[1]);

        if (seconds > 59) {
            return -1;
        }

        return minutes * 60 + seconds;
    }
}
