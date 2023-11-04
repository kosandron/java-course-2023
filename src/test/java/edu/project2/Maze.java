package edu.project2;

public class Maze {
    private final Cell[][] grid;
    private final Coordinate start;
    private final Coordinate finish;

    public Maze(Cell[][] grid, Coordinate start, Coordinate finish) {
        if (!validArgs(grid, start, finish)) {
            throw new IllegalArgumentException();
        }

        this.start = start;
        this.finish = finish;
        this.grid = grid;
    }

    private boolean validArgs(Cell[][] field, Coordinate start, Coordinate finish) {
        if (field == null || field.length == 0) {
            return false;
        }

        int height = field.length;
        int width = field[0].length;

        for (Cell[] row : field) {
            if (row.length != width) {
                return false;
            }
        }

        int x1 = start.row();
        int y1 = start.col();
        int x2 = finish.row();
        int y2 = finish.col();

        if (x1 >= height || y1 >= width || x2 >= height || y2 >= width) {
            return false;
        }

        return !(field[x1][y1].isNew() || field[x2][y2].isNew());
    }

    public int height() {
        return grid.length;
    }

    public int width() {
        return grid[0].length;
    }

    public Cell get(int x, int y) {
        return grid[x][y];
    }

    public Cell get(Coordinate coordinate) {
        return get(coordinate.row(), coordinate.col());
    }

    public Coordinate start() {
        return start;
    }

    public Coordinate end() {
        return finish;
    }
}
