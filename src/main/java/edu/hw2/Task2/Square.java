package edu.hw2.Task2;

public class Square extends Rectangle {
    public Square() {
    }

    public Square(int width, int height) {
        super(width, height);
    }

    @Override
    public Rectangle setWidth(int width) {
        return new Rectangle(width, this.height);
    }

    @Override
    public Rectangle setHeight(int height) {
        return new Rectangle(this.width, height);
    }
}
