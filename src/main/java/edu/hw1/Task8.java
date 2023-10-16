package edu.hw1;

public final class Task8 {
    public final static int CELL_IN_ROW_COUNT = 8;

    private Task8() {
    }

    public static boolean isInField(int i, int j) {
        return i >= 0 && i < CELL_IN_ROW_COUNT && j >= 0 && j < CELL_IN_ROW_COUNT;
    }

    @SuppressWarnings("MagicNumber")
    public static boolean checkNeither(int i, int j, int[][] field) {
        for (int diffI = -2; diffI < 3; diffI++) {
            for (int diffJ = -2; diffJ < 3; diffJ++) {
                if (Math.abs(diffI) == Math.abs(diffJ) || diffI == 0 || diffJ == 0) {
                    continue;
                }
                if (isInField(i + diffI, j + diffJ) && field[i + diffI][j + diffJ] == 1) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean knightBoardCapture(int[][] field) {
        for (int i = 1; i < CELL_IN_ROW_COUNT - 1; i++) {
            for (int j = 1; j < CELL_IN_ROW_COUNT - 1; j++) {
                if (field[i][j] == 1 && checkNeither(i, j, field)) {
                    return false;
                }
            }
        }

        return true;
    }
}
