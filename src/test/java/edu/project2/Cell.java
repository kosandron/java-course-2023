package edu.project2;

public class Cell {
    private boolean rightWall;
    private boolean leftWall;
    private boolean upWall;
    private boolean downWall;

    public Cell() {
        rightWall = true;
        leftWall = true;
        upWall = true;
        downWall = true;
    }

    public boolean hasLeftWall() {
        return leftWall;
    }

    public boolean hasRightWall() {
        return rightWall;
    }

    public boolean hasUpWall() {
        return upWall;
    }

    public boolean hasDownWall() {
        return downWall;
    }

    public boolean isNew() {
        return leftWall && rightWall && upWall && downWall;
    }

    public void breakRightWall() {
        rightWall = false;
    }

    public void breakLeftWall() {
        leftWall = false;
    }

    public void breakUpWall() {
        upWall = false;
    }

    public void breakDownWall() {
        downWall = false;
    }
}
