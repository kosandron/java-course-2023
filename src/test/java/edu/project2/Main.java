package edu.project2;

import edu.project2.Generators.Generator;
import edu.project2.Generators.*;
import edu.project2.Solvers.*;

public class Main {
    private Main() {
    }

    @SuppressWarnings("MagicNumber")
    public static void main(String[] args) {
        Generator generator = new SidewinderGenerator();
        Maze maze = generator.generate(20, 25);

        DefaultRenderer renderer = new DefaultRenderer();
        System.out.println(renderer.render(maze));
        System.out.println("Solve:");
        System.out.println(renderer.renderSolve(maze, new BFSSolver()));
    }
}
