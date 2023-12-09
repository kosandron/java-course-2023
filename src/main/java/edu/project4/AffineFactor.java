package edu.project4;

import java.awt.Color;
import java.util.concurrent.ThreadLocalRandom;

public record AffineFactor(
    double a,
    double b,
    double c,
    double d,
    double e,
    double f,
    Color color) {
    private static final int MAX_ATTEMPTS_COUNT = 100000;
    private static final int MAX_PALETTE_NUMBER = 256;
    private static final double DEFAULT_VALUE = 0.1;

    public static AffineFactor create() {
        int attempt = 0;
        while (attempt++ < MAX_ATTEMPTS_COUNT) {
            double a = ThreadLocalRandom.current().nextDouble(-1, 1);
            double b = ThreadLocalRandom.current().nextDouble(-1, 1);
            double c = ThreadLocalRandom.current().nextDouble(-1, 1);
            double d = ThreadLocalRandom.current().nextDouble(-1, 1);
            double e = ThreadLocalRandom.current().nextDouble(-1, 1);
            double f = ThreadLocalRandom.current().nextDouble(-1, 1);
            if (isFactorValid(a, b, d, e)) {
                return new AffineFactor(a, b, c, d, e, f, getRandomColor());
            }
        }

        return new AffineFactor(
            DEFAULT_VALUE,
            DEFAULT_VALUE,
            DEFAULT_VALUE,
            DEFAULT_VALUE,
            DEFAULT_VALUE,
            DEFAULT_VALUE,
            getRandomColor()
        );
    }

    private static boolean isFactorValid(double a, double b, double d, double e) {
        return (a * a + d * d < 1)
            && (b * b + e * e < 1)
            && (a * a + b * b + d * d + e * e < 1 + (a * e - b * d) * (a * e - b * d));
    }

    private static Color getRandomColor() {
        return new Color(
            ThreadLocalRandom.current().nextInt(1, MAX_PALETTE_NUMBER),
            ThreadLocalRandom.current().nextInt(1, MAX_PALETTE_NUMBER),
            ThreadLocalRandom.current().nextInt(1, MAX_PALETTE_NUMBER)
        );
    }
}
