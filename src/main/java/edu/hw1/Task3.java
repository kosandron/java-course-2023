package edu.hw1;

public final class Task3 {
    private Task3() {
    }

    public static boolean isNestable(int[] a, int[] b) {
        if (a.length == 0) {
            return true;
        }
        if (b.length == 0) {
            return false;
        }

        int aMax = a[0];
        int aMin = a[0];
        int bMax = b[0];
        int bMin = b[0];

        for (int i = 1; i < a.length; i++) {
            if (a[i] < aMin) {
                aMin = a[i];
            }
            if (a[i] > aMax) {
                aMax = a[i];
            }
        }
        for (int i = 1; i < b.length; i++) {
            if (b[i] < bMin) {
                bMin = b[i];
            }
            if (b[i] > bMax) {
                bMax = b[i];
            }
        }

        return aMin > bMin && aMax < bMax;
    }
}
