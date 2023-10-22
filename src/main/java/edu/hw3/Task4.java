package edu.hw3;

public final class Task4 {
    private Task4() {
    }

    @SuppressWarnings("MagicNumber")
    public String intToRoman(int number) {
        int numberCopy = number;
        int[] letterValues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] letters = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder builder = new StringBuilder();
        if (numberCopy >= 1000) {
            builder.append("M".repeat(numberCopy / 1000));
            numberCopy /= 1000;
        }

        for (int i = 0; i < letterValues.length; i++) {
            while (numberCopy >= letterValues[i]) {
                numberCopy -= letterValues[i];
                builder.append(letters[i]);
            }
        }

        return builder.toString();
    }
}
