package edu.project2;

import edu.project2.Generators.Generator;
import edu.project2.Generators.SidewinderGenerator;
import edu.project2.Solvers.BFSSolver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private final static Logger LOGGER = LogManager.getLogger();

    private Main() {
    }

    @SuppressWarnings("MagicNumber")
    public static void main(String[] args) {
        Generator generator = new SidewinderGenerator();
        Maze maze = generator.generate(20, 25);

        DefaultRenderer renderer = new DefaultRenderer();
        LOGGER.info(renderer.render(maze));
        LOGGER.info("Solve:");
        LOGGER.info(renderer.renderSolve(maze, new BFSSolver()));
    }
}
