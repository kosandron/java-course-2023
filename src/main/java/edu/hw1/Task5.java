package edu.hw1;

public final class Task5 {
    private Task5() {
    }

    private static int binPow(int value, int powerValue) {
        int number = value;
        int power = powerValue;
        int res = 1;

        while (power != 0) {
            if (power % 2 == 1) {
                res *= number;
            }
            number *= number;
            power >>= 1;
        }

        return res;
    }

    @SuppressWarnings("MagicNumber")
    private static int makeNewNumber(int value) {
        int number = value;
        int numberLength = Task2.countDigits(number);
        int newNumber = 0;
        int divider = binPow(10, numberLength - 1);

        for (int i = 1; i < numberLength; i += 2) {
            int newDigit = (number / divider) % 10 + (number / (divider / 10)) % 10;
            if (newDigit > 9) {
                newNumber = newNumber * 100 + newDigit;
            } else {
                newNumber = newNumber * 10 + newDigit;
            }
            divider /= 100;
        }

        if (numberLength % 2 == 1) {
            newNumber = newNumber * 10 + number % 10;
        }

        return newNumber;
    }

    @SuppressWarnings("MagicNumber")
    private static boolean isPalindrome(int number) {
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
        if (Task2.countDigits(number) == 1) {
            return false;
        }

        if (isPalindrome(number)) {
            return true;
        }

        return isPalindromeDescendant(makeNewNumber(number));
    }
}
