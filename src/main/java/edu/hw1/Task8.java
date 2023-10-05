package edu.hw1;

public final class Task8 {
    public static final int CELLINROWCOUNT = 8;

    private Task8() { }

    public static boolean isInField(int i, int j) {
        return i >= 0 && i < CELLINROWCOUNT && j >= 0 && j < CELLINROWCOUNT;
    }

    @SuppressWarnings("MagicNumber")
    public static boolean checkNeither(int i, int j, int[][] field) {
        for (int diffI = -2; diffI < 3; diffI++) {
            for (int diffJ = -2; diffJ < 3; diffJ++) {
                if (Math.abs(diffI) == Math.abs(diffJ) || diffI == 0 || diffJ == 0) {
                    continue;
                }
                if (isInField(i + diffI, j + diffJ) && field[i + diffI][ j + diffJ] == 1) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean knightBoardCapture(int[][] field) {
        for (int i = 1; i < CELLINROWCOUNT - 1; i++) {
            for (int j = 1; j < CELLINROWCOUNT - 1; j++) {
                if (field[i][j] == 1 && checkNeither(i, j, field)) {
                    return false;
                }
            }
        }

        return true;
    }
}
