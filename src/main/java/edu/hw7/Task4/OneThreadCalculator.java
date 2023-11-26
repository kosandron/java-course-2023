package edu.hw7.Task4;

import java.security.SecureRandom;

public final class OneThreadCalculator {
    private final static double SQUARE_SIDE_LENGTH = 1;
    private final static double CIRCLE_CENTER = SQUARE_SIDE_LENGTH / 2;
    private final static double CIRCLE_RADIUS = SQUARE_SIDE_LENGTH / 2;
    private final static int FACTOR_OF_THE_PI_FORMULA = 4;

    private OneThreadCalculator() { }

    public static double calculate(int pointsCount) {
        SecureRandom random = new SecureRandom();
        int circleCount = 0;
        int totalCount = 0;
        double x;
        double y;
        while (totalCount < pointsCount) {
            x = random.nextDouble(0, SQUARE_SIDE_LENGTH);
            y = random.nextDouble(0, SQUARE_SIDE_LENGTH);
            if (isInCircle(x, y)) {
                circleCount++;
            }
            totalCount++;
        }
        return FACTOR_OF_THE_PI_FORMULA * ((double) circleCount / (double) totalCount);
    }

    private static boolean isInCircle(double x, double y) {
        return Math.pow(CIRCLE_CENTER - x, 2) + Math.pow(CIRCLE_CENTER - y, 2) <= CIRCLE_RADIUS * CIRCLE_RADIUS;
    }
}
