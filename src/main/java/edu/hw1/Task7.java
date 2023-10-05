package edu.hw1;

public final class Task7 {
    private Task7() { }

    public static int findNumberTwoPower(int value) {
        int number = value;
        number = Math.abs(number);
        int k = 0;
        while (number != 0) {
            k++;
            number >>= 1;
        }

        return Math.max(k, 1);
    }

    public static int rotateLeft(int value, int step) {
        int number = value;
        int k = step;
        if (k < 0) {
            return rotateRight(number, -k);
        }
        int twoPower = findNumberTwoPower(number);
        k = k % twoPower;

        int newNumber = (number >> (twoPower - k)) + ((number % (1 << (twoPower - k))) << k);

        return number > 0 ? newNumber : -newNumber;
    }

    public static int rotateRight(int number, int k) {
        if (k < 0) {
            return rotateLeft(number, -k);
        }
        return rotateLeft(number, findNumberTwoPower(number) - k);
    }
}
