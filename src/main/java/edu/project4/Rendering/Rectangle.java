package edu.project4.Rendering;

import edu.project4.Point;
import java.util.concurrent.ThreadLocalRandom;

public record Rectangle(double x, double y, double width, double height) {
    public boolean contains(Point p) {
        return p.x() >= -x && p.x() < width + x && p.y() >= -y && p.y() < height + y;
    }

    public Point getRandomPoint() {
        double px = ThreadLocalRandom.current().nextDouble(-x, x);
        double py = ThreadLocalRandom.current().nextDouble(-y, y);
        return new Point(px, py);
    }
}
