package edu.project4.Transformations;

import edu.project4.Point;

public class SphericalTransformation implements Transformation {
    @Override
    public Point apply(Point point) {
        double radius = 1.0 / (point.x() * point.x() + point.y() * point.y());
        double newX = radius * point.x();
        double newY = radius * point.y();
        return new Point(newX, newY);
    }
}
