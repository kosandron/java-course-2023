package edu.hw1;

public final class Task1 {
    private Task1() { }

    @SuppressWarnings("MagicNumber")
    public static int minutesToSeconds(String str) {
        if (str == null) {
            return -1;
        }

        int seconds = 0;
        int minutes = 0;
        boolean delimetr = false;
        int answer = 0;

        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                if (!delimetr) {
                    minutes = minutes * 10 + Character.getNumericValue(str.charAt(i));
                } else {
                    seconds = seconds * 10 + Character.getNumericValue(str.charAt(i));
                }
            } else if (str.charAt(i) == ':') {
                if (delimetr || i == str.length() - 1) {
                    answer = -1;
                    break;
                }
                delimetr = true;
            } else {
                answer = -1;
                break;
            }
        }

        if (seconds > 59 || !delimetr) {
            answer = -1;
        }

        return answer == -1 ? -1 : minutes * 60 + seconds;
    }
}
