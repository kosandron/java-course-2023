package edu.project4.Transformations;

import edu.project4.Point;

public class DiskTransformation implements Transformation {
    @Override
    public Point apply(Point point) {
        double radius = Math.sqrt(point.x() * point.x() + point.y() * point.y()) * Math.PI;
        double theta = Math.atan2(point.y(), point.x()) / Math.PI;
        double newX = theta * Math.sin(radius);
        double newY = theta * Math.cos(radius);
        return new Point(newX, newY);
    }
}
