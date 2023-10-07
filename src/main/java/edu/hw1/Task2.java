package edu.hw1;

public final class Task2 {
    private Task2() {
    }

    @SuppressWarnings("MagicNumber")
    public static int countDigits(int value) {
        if (value == 0) {
            return 1;
        }
        int number = value;
        int counter = 0;
        while (number != 0) {
            counter++;
            number = number / 10;
        }
        return counter;
    }
}
