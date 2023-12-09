package edu.project4.Transformations;

import edu.project4.Point;

public class SpiralTransformation  implements Transformation {
    @Override
    public Point apply(Point point) {
        double radius = Math.sqrt(point.x() * point.x() + point.y() * point.y());
        double theta = Math.atan2(point.y(), point.x());
        double newX = (1.0 / radius) * (Math.cos(theta) + Math.sin(radius));
        double newY = (1.0 / radius) * (Math.sin(theta) - Math.cos(radius));
        return new Point(newX, newY);
    }
}
