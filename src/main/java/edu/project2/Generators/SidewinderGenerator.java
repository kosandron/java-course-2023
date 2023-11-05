package edu.project2.Generators;

import edu.project2.Cell;
import edu.project2.Coordinate;
import edu.project2.Maze;
import java.util.Random;

public class SidewinderGenerator implements Generator {
    private static final int MIN_HEIGHT = 3;
    private static final int MIN_WIDTH = 3;
    private static final Random RANDOM = new Random();

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

        for (int j = 1; j < width - 2; j++) {
            field[1][j].breakRightWall();
            field[1][j + 1].breakLeftWall();
        }
        for (int i = 2; i < height - 1; i++) {
            int k = 1;
            while (k < width - 1) {
                int b = k;
                while (RANDOM.nextBoolean() && k < width - 2) {
                    k++;
                    field[i][k - 1].breakRightWall();
                    field[i][k].breakLeftWall();
                }
                int n = RANDOM.nextInt(b, k + 1);
                field[i][n].breakUpWall();
                field[i - 1][n].breakDownWall();
                k++;
            }
        }

        int xStart = (int) (Math.random() * (height - MIN_HEIGHT) + 1);
        int yStart = (int) (Math.random() * (width - MIN_WIDTH) + 1);
        Coordinate start = new Coordinate(xStart, yStart);

        int xFinish = (int) (Math.random() * (height - MIN_HEIGHT) + 1);
        int yFinish = (int) (Math.random() * (width - MIN_WIDTH) + 1);

        while (field[xFinish][yFinish].isNew() || xStart == xFinish && yStart == yFinish) {
            xFinish = (int) (Math.random() * (height - MIN_HEIGHT) + 1);
            yFinish = (int) (Math.random() * (width - MIN_WIDTH) + 1);
        }

        Coordinate finish = new Coordinate(xFinish, yFinish);

        return new Maze(field, start, finish);
    }
}
