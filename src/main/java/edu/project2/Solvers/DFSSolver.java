package edu.project2.Solvers;

import edu.project2.Coordinate;
import edu.project2.Maze;
import java.util.ArrayList;
import java.util.List;

public class DFSSolver implements Solver {
    private List<Coordinate> path;
    private boolean[][] used;
    private boolean continueFinding;

    void dfs(Maze maze, Coordinate coordinate) {
        used[coordinate.row()][coordinate.col()] = true;
        path.add(coordinate);
        if (coordinate.equals(maze.finish())) {
            continueFinding = false;
            return;
        }

        if (!used[coordinate.row() + 1][coordinate.col()] && !maze.get(coordinate).hasDownWall() && continueFinding) {
            dfs(maze, new Coordinate(coordinate.row() + 1, coordinate.col()));
        }

        if (!used[coordinate.row() - 1][coordinate.col()] && !maze.get(coordinate).hasUpWall() && continueFinding) {
            dfs(maze, new Coordinate(coordinate.row() - 1, coordinate.col()));
        }

        if (!used[coordinate.row()][coordinate.col() + 1] && !maze.get(coordinate).hasRightWall() && continueFinding) {
            dfs(maze, new Coordinate(coordinate.row(), coordinate.col() + 1));
        }

        if (!used[coordinate.row()][coordinate.col() - 1] && !maze.get(coordinate).hasLeftWall() && continueFinding) {
            dfs(maze, new Coordinate(coordinate.row(), coordinate.col() - 1));
        }

        if (continueFinding) {
            path.remove(path.size() - 1);
        }
    }

    @Override
    public List<Coordinate> findPath(Maze maze) {
        path = new ArrayList<>();
        used = new boolean[maze.height()][maze.width()];
        for (int i = 0; i < maze.height(); i++) {
            for (int j = 0; j < maze.width(); j++) {
                if (maze.get(i, j).isNew()) {
                    used[i][j] = true;
                }
            }
        }
        continueFinding = true;
        dfs(maze, maze.start());
        return path;
    }
}
