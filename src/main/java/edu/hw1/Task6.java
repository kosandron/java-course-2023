package edu.hw1;

public final class Task6 {
    public final static int KAPREKAR_NUMBER = 6174;

    private Task6() {
    }

    @SuppressWarnings("MagicNumber")
    private static int sortByDecreaseNumber(int value) {
        int number = value;
        int[] digitCount = new int[10];

        while (number != 0) {
            digitCount[number % 10]++;
            number /= 10;
        }

        int sortedNumber = 0;
        for (int i = digitCount.length - 1; i >= 0; i--) {
            for (int j = 0; j < digitCount[i]; j++) {
                sortedNumber = sortedNumber * 10 + i;
            }
        }

        return sortedNumber;
    }

    @SuppressWarnings("MagicNumber")
    private static int sortNumber(int value) {
        int number = value;
        int[] digitCount = new int[10]; // count-sort

        while (number != 0) {
            digitCount[number % 10]++;
            number /= 10;
        }

        int sortedNumber = 0;
        for (int i = 0; i < digitCount.length; i++) {
            for (int j = 0; j < digitCount[i]; j++) {
                sortedNumber = sortedNumber * 10 + i;
            }
        }

        return sortedNumber;
    }

    @SuppressWarnings("MagicNumber")
    private static boolean isValid(int value) {
        if (value < 1001) {
            return false;
        }
        int number = value;
        int digit = value % 10;
        number /= 10;

        int currentLastDigit;
        while (number != 0) {
            currentLastDigit = number % 10;
            if (currentLastDigit != digit) {
                return true;
            }
            digit = currentLastDigit;
            number /= 10;
        }

        return false;
    }

    @SuppressWarnings("MagicNumber")
    public static int countK(int value) {
        if (!isValid(value)) {
            return -1;
        }
        int number = value;

        int step = 0;

        while (number != KAPREKAR_NUMBER) {
            number = sortByDecreaseNumber(number) - sortNumber(number);
            step++;
        }

        return step;
    }
}
