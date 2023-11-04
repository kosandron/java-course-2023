package edu.project2.Generators;

import edu.project2.Cell;
import edu.project2.Coordinate;
import edu.project2.Maze;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RecursiveBacktrackingGenerator implements Generator {
    private final int MIN_HEIGHT = 3;
    private final int MIN_WIDTH = 3;

    @Override
    public Maze generate(int height, int width) {
        if (height < MIN_HEIGHT || width < MIN_WIDTH) {
            throw new IllegalArgumentException();
        }

        Cell[][] grid = new Cell[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                grid[i][j] = new Cell();
            }
        }

        int xStart = (int) (Math.random() * (height - MIN_HEIGHT) + 1);
        int yStart = ((int) (Math.random() * (width - MIN_WIDTH) + 1));
        Coordinate start = new Coordinate(xStart, yStart);

        makePassage(grid, xStart, yStart, -1, -1);

        int xFinish = (int) (Math.random() * (height - MIN_HEIGHT) + 1);
        int yFinish = (int) (Math.random() * (width - MIN_WIDTH) + 1);

        while (grid[xFinish][yFinish].isNew() || xStart == xFinish && yStart == yFinish) {
            xFinish = (int) (Math.random() * (height - MIN_HEIGHT) + 1);
            yFinish = (int) (Math.random() * (width - MIN_WIDTH) + 1);
        }

        Coordinate finish = new Coordinate(xFinish, yFinish);

        return new Maze(grid, start, finish);
    }

    private void breakWall(Cell[][] grid, int x, int y, int xPrev, int yPrev) {
        if (x < 0 || y < 0 || xPrev < 0 || yPrev < 0) {
            return;
        }

        if (x == xPrev + 1) {
            grid[x][y].breakUpWall();
            grid[xPrev][yPrev].breakDownWall();
        } else if (x == xPrev - 1) {
            grid[x][y].breakDownWall();
            grid[xPrev][yPrev].breakUpWall();
        } else if (y == yPrev + 1) {
            grid[x][y].breakLeftWall();
            grid[xPrev][yPrev].breakRightWall();
        } else if (y == yPrev - 1) {
            grid[x][y].breakRightWall();
            grid[xPrev][yPrev].breakLeftWall();
        } else {
            throw new IllegalArgumentException("Strange step!");
        }
    }

    private void makePassage(Cell[][] grid, int x, int y, int xPrev, int yPrev) {
        breakWall(grid, x, y, xPrev, yPrev);

        List<Coordinate> neighbours = Arrays.asList(
            new Coordinate(x - 1, y),
            new Coordinate(x + 1, y),
            new Coordinate(x, y - 1),
            new Coordinate(x, y + 1)
        );
        Collections.shuffle(neighbours);

        for (Coordinate coordinate : neighbours) {
            if (canMakePassage(grid, coordinate.row(), coordinate.col())) {
                makePassage(grid, coordinate.row(), coordinate.col(), x, y);
            }
        }
    }

    private boolean canMakePassage(Cell[][] grid, int x, int y) {
        if (x == 0 || x == grid.length - 1 || y == 0 || y == grid[0].length - 1) {
            return false;
        }
        return grid[x][y].isNew();
    }
}
