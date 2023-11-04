package edu.project2;

import edu.project2.Solvers.DFSSolver;

public class DefaultRenderer implements Renderer {
    private String getUpRow(Cell cell) {
        return cell.hasUpWall() ? "▆▆▆" : "▆ ▆";
    }

    private String getDownRow(Cell cell) {
        return cell.hasDownWall() ? "▆▆▆" : "▆ ▆";
    }

    private String getCurrentRow(Cell cell) {
        if (cell.isNew()) {
            return "▆▆▆";
        }

        if (cell.hasLeftWall() && cell.hasRightWall()) {
            return "▆ ▆";
        } else if (cell.hasRightWall() && !cell.hasLeftWall()) {
            return "  ▆";
        } else if (!cell.hasRightWall() && cell.hasLeftWall()) {
            return "▆  ";
        }
        return "   ";
    }

    private void printOnMaze(StringBuilder map, Maze maze, Coordinate coordinate, String word) {
        map.replace(3 * coordinate.row() * (3 * maze.width() + 1) + 3 * maze.width() + 1 + coordinate.col() * 3 + 1,
            3 * coordinate.row() * (3 * maze.width() + 1) + 3 * maze.width() + 1 + coordinate.col() * 3 + 2, word
        );
    }

    @Override
    public String render(Maze maze) {
        if (maze == null) {
            throw new NullPointerException();
        }

        StringBuilder line1 = new StringBuilder();
        StringBuilder line2 = new StringBuilder();
        StringBuilder line3 = new StringBuilder();
        StringBuilder currentLine = new StringBuilder();
        for (int i = 0; i < maze.height(); i++) {
            for (int j = 0; j < maze.width(); j++) {
                line1.append(getUpRow(maze.get(i, j)));
                line2.append(getCurrentRow(maze.get(i, j)));
                line3.append(getDownRow(maze.get(i, j)));
            }
            line1.append('\n');
            line2.append('\n');
            line3.append('\n');
            currentLine.append(line1);
            currentLine.append(line2);
            currentLine.append(line3);
            line1.delete(0, line1.length());
            line2.delete(0, line2.length());
            line3.delete(0, line3.length());
        }

        printOnMaze(currentLine, maze, maze.start(), "@");
        printOnMaze(currentLine, maze, maze.end(), "@");
        return currentLine.toString();
    }

    public String renderSolve(Maze maze) {
        StringBuilder map = new StringBuilder(render(maze));
        DFSSolver dfsSolver = new DFSSolver();
        for (Coordinate coordinate : dfsSolver.findPath(maze)) {
            printOnMaze(map, maze, coordinate, "*");
        }
        printOnMaze(map, maze, maze.start(), "@");
        printOnMaze(map, maze, maze.end(), "@");

        return map.toString();
    }
}
