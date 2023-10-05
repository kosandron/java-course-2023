package edu.hw1;

public final class Task6 {
    private Task6() { }

    @SuppressWarnings("MagicNumber")
    public static int sortByDecreaseNumber(int value) {
        int number = value;
        int[] digitCount = new int[10];
        for (int i = 0; i < digitCount.length; i++) {
            digitCount[i] = 0;
        }

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
    public static int sortNumber(int value) {
        int number = value;
        int[] digitCount = new int[10]; // count-sort
        for (int i = 0; i < digitCount.length; i++) {
            digitCount[i] = 0;
        }

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
    public static int countK(int value) {
        int number = value;
        if (number < 1001) {
            return -1;
        }

        int step = 0;

        while (number != 6174) {
            number = sortByDecreaseNumber(number) - sortNumber(number);
            step++;
        }

        return step;
    }
}
