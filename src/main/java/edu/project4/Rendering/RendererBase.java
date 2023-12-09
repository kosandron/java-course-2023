package edu.project4.Rendering;

import edu.project4.AffineFactor;
import edu.project4.FractalImage;
import edu.project4.Pixel;
import edu.project4.Point;
import edu.project4.Transformations.Transformation;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public abstract class RendererBase implements Renderer {
    protected static final int SKIP_ITERATIONS = -20;

    protected void renderSample(
        FractalImage image,
        Rectangle world,
        int iterations,
        int symmetry,
        List<Transformation> transformations,
        AffineFactor[] affineFactorsArray
    ) {
        Point point = world.getRandomPoint();

        for (int i = SKIP_ITERATIONS; i < iterations; i++) {
            int randomIndex = ThreadLocalRandom.current().nextInt(0, affineFactorsArray.length);
            AffineFactor affineFactor = affineFactorsArray[randomIndex];
            point = transformPointAndGet(affineFactor, point);
            Transformation transformation =
                transformations.get(ThreadLocalRandom.current().nextInt(0, transformations.size()));
            point = transformation.apply(point);

            if (i >= 0) {
                double theta = 0;
                for (int s = 0; s < symmetry; s++) {
                    theta += 2 * Math.PI / symmetry;
                    Point rotatedPoint = getRotatedPoint(point, theta);
                    if (!world.contains(rotatedPoint)) {
                        continue;
                    }

                    Pixel pixel =
                        image.getPixel(
                            image.getWidth()
                                - (int) ((world.width() / 2 - rotatedPoint.x()) / (world.width()) * image.getWidth()),
                            image.getHeight()
                                - (int) ((world.height() / 2 - rotatedPoint.y()) / world.height() * image.getHeight())
                        );
                    if (pixel == null) {
                        continue;
                    }

                    synchronized (pixel) {
                        setPixelColor(pixel, affineFactor);
                        pixel.setHitCount(pixel.getHitCount() + 1);
                    }
                }
            }
        }
    }

    protected Point getRotatedPoint(Point point, double theta) {
        double xRotated = point.x() * Math.cos(theta) - point.y() * Math.sin(theta);
        double yRotated = point.x() * Math.sin(theta) + point.y() * Math.cos(theta);
        return new Point(xRotated, yRotated);
    }

    protected double getNewTransformedX(AffineFactor coefficients, Point point) {
        return coefficients.a() * point.x() + coefficients.b() * point.y()
            + coefficients.c();
    }

    protected double getNewTransformedY(AffineFactor coefficients, Point point) {
        return coefficients.d() * point.x() + coefficients.e() * point.y()
            + coefficients.f();
    }

    protected void setPixelColor(Pixel pixel, AffineFactor coefficients) {
        if (pixel.getHitCount() == 0) {
            pixel.setRed(coefficients.color().getRed());
            pixel.setGreen(coefficients.color().getGreen());
            pixel.setBlue(coefficients.color().getBlue());
        } else {
            pixel.setRed((pixel.getRed() + coefficients.color().getRed()) / 2);
            pixel.setGreen((pixel.getGreen() + coefficients.color().getGreen()) / 2);
            pixel.setBlue((pixel.getBlue() + coefficients.color().getBlue()) / 2);
        }
    }

    protected AffineFactor[] getRandomAffineFactors(int factorsCount) {
        AffineFactor[] transformations = new AffineFactor[factorsCount];
        for (int i = 0; i < factorsCount; i++) {
            transformations[i] = AffineFactor.create();
        }
        return transformations;
    }

    protected Point transformPointAndGet(AffineFactor coefficients, Point pw) {
        double x = getNewTransformedX(coefficients, pw);
        double y = getNewTransformedY(coefficients, pw);
        return new Point(x, y);
    }
}
