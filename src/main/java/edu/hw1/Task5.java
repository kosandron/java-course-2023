package edu.hw1;

public final class Task5 {
    private Task5() { }

    public static int binpow(int value, int power) {
        int number = value;
        int k = power;
        int res = 1;

        while (k != 0) {
            if (k % 2 == 1) {
                res *= number;
            }
            number *= number;
            k >>= 1;
        }

        return res;
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

    @SuppressWarnings("MagicNumber")
    public static int makeNewNumber(int value) {
        int number = value;
        int length = countDigits(number);
        int newNumber = 0;
        int delitel = binpow(10, length - 1);

        for (int i = 1; i < length; i += 2) {
            int newDigit = (number / delitel) % 10 + (number / (delitel / 10)) % 10;
            if (newDigit > 9) {
                newNumber = newNumber * 100 + newDigit;
            } else {
                newNumber = newNumber * 10 + newDigit;
            }
            delitel /= 100;
        }

        if (length % 2 == 1) {
            newNumber = newNumber * 10 + number % 10;
        }

        return newNumber;
    }

    @SuppressWarnings("MagicNumber")
    public static boolean isPalindrome(int number) {
        int numberCopy = number;
        int reversedNumber = 0;

        while (numberCopy != 0) {
            reversedNumber = reversedNumber * 10 + numberCopy % 10;
            numberCopy /= 10;
        }

        return number == reversedNumber;
    }

    public static boolean isPalindromeDescendant(int value) {
        int number = Math.abs(value);
        if (countDigits(number) == 1) {
            return false;
        }

        if (isPalindrome(number)) {
            return true;
        }

        return isPalindromeDescendant(makeNewNumber(number));
    }
}
