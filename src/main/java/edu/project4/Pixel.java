package edu.project4;

public class Pixel {
    private int red;
    private int green;
    private int blue;
    private int hitCount;
    private double normal;

    public Pixel(int red, int green, int blue, int hitCount, double normal) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.hitCount = hitCount;
        this.normal = normal;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int r) {
        this.red = r;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int g) {
        this.green = g;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int b) {
        this.blue = b;
    }

    public int getHitCount() {
        return hitCount;
    }

    public void setHitCount(int hitCount) {
        this.hitCount = hitCount;
    }

    public double getNormal() {
        return normal;
    }

    public void setNormal(double normal) {
        this.normal = normal;
    }
}
