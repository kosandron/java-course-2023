package edu.project4.Transformations;

import edu.project4.Point;

public class HeartTransformation implements Transformation {
    @Override
    public Point apply(Point point) {
        double theta = Math.sqrt(point.x() * point.x() + point.y() * point.y());
        double newX = theta * Math.sin(theta * Math.atan2(point.y(), point.x()));
        double newY = theta * Math.cos(theta * Math.atan2(point.y(), point.x()));
        return new Point(newX, newY);
    }
}
