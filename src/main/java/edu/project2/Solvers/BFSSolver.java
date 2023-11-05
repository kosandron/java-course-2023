package edu.project2.Solvers;

import edu.project2.Coordinate;
import edu.project2.Maze;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSSolver implements Solver {
    private boolean[][] used;
    private Coordinate[][] prev;
    private List<Coordinate> path;

    private void bfs(Maze maze) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(maze.start());
        prev[maze.start().row()][maze.start().col()] = null;
        used[maze.start().row()][maze.start().col()] = true;

        Coordinate currentCoordinate;
        while (!queue.isEmpty()) {
            currentCoordinate = queue.peek();
            if (currentCoordinate.equals(maze.end())) {
                break;
            }

            int x = queue.peek().row();
            int y = queue.peek().col();
            used[x][y] = true;
            if (!used[x + 1][y] && !maze.get(currentCoordinate).hasDownWall()) {
                queue.add(new Coordinate(x + 1, y));
                prev[x + 1][y] = currentCoordinate;
            }

            if (!used[x - 1][y] && !maze.get(currentCoordinate).hasUpWall()) {
                queue.add(new Coordinate(x - 1, y));
                prev[x - 1][y] = currentCoordinate;
            }

            if (!used[x][y + 1] && !maze.get(currentCoordinate).hasRightWall()) {
                queue.add(new Coordinate(x, y + 1));
                prev[x][y + 1] = currentCoordinate;
            }

            if (!used[x][y - 1] && !maze.get(currentCoordinate).hasLeftWall()) {
                queue.add(new Coordinate(x, y - 1));
                prev[x][y - 1] = currentCoordinate;
            }

            queue.remove();
        }

        currentCoordinate = maze.end();
        while (currentCoordinate != null) {
            path.add(currentCoordinate);
            currentCoordinate = prev[currentCoordinate.row()][currentCoordinate.col()];
        }
        Collections.reverse(path);
    }

    @Override
    public List<Coordinate> findPath(Maze maze) {
        if (maze == null) {
            throw new NullPointerException();
        }
        used = new boolean[maze.height()][maze.width()];
        for (int i = 0; i < maze.height(); i++) {
            for (int j = 0; j < maze.width(); j++) {
                if (maze.get(i, j).isNew()) {
                    used[i][j] = true;
                }
            }
        }
        prev = new Coordinate[maze.height()][maze.width()];
        path = new ArrayList<>();

        bfs(maze);

        return path;
    }
}
