package edu.project2.Generators;

import edu.project2.Cell;
import edu.project2.Coordinate;
import edu.project2.Maze;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RecursiveBacktrackingGenerator implements Generator {
    private static final Random RANDOM = new Random();
    private static final int MIN_HEIGHT = 3;
    private static final int MIN_WIDTH = 3;

    @Override
    public Maze generate(int height, int width) {
        if (height < MIN_HEIGHT || width < MIN_WIDTH) {
            throw new IllegalArgumentException();
        }

        Cell[][] field = new Cell[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                field[i][j] = new Cell();
            }
        }

        int xStart = RANDOM.nextInt(height - 1) + 1;
        int yStart = RANDOM.nextInt(width - 1) + 1;
        Coordinate start = new Coordinate(xStart, yStart);

        makePassage(field, xStart, yStart, -1, -1);

        int xFinish = RANDOM.nextInt(height - 1) + 1;
        int yFinish = RANDOM.nextInt(width - 1) + 1;

        while (field[xFinish][yFinish].isNew() || xStart == xFinish && yStart == yFinish) {
            xFinish = RANDOM.nextInt(height - 1) + 1;
            yFinish = RANDOM.nextInt(width - 1) + 1;
        }

        Coordinate finish = new Coordinate(xFinish, yFinish);

        return new Maze(field, start, finish);
    }

    private void breakWall(Cell[][] field, int x, int y, int xPrev, int yPrev) {
        if (x < 0 || y < 0 || xPrev < 0 || yPrev < 0) {
            return;
        }

        if (x == xPrev + 1) {
            field[x][y].breakUpWall();
            field[xPrev][yPrev].breakDownWall();
        } else if (x == xPrev - 1) {
            field[x][y].breakDownWall();
            field[xPrev][yPrev].breakUpWall();
        } else if (y == yPrev + 1) {
            field[x][y].breakLeftWall();
            field[xPrev][yPrev].breakRightWall();
        } else if (y == yPrev - 1) {
            field[x][y].breakRightWall();
            field[xPrev][yPrev].breakLeftWall();
        } else {
            throw new IllegalArgumentException("Strange step!");
        }
    }

    private void makePassage(Cell[][] field, int x, int y, int xPrev, int yPrev) {
        breakWall(field, x, y, xPrev, yPrev);

        List<Coordinate> neighbours = Arrays.asList(
            new Coordinate(x - 1, y),
            new Coordinate(x + 1, y),
            new Coordinate(x, y - 1),
            new Coordinate(x, y + 1)
        );
        Collections.shuffle(neighbours);

        for (Coordinate coordinate : neighbours) {
            if (canMakePassage(field, coordinate.row(), coordinate.col())) {
                makePassage(field, coordinate.row(), coordinate.col(), x, y);
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
