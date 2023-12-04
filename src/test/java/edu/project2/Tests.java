package edu.project2;

import edu.project2.Generators.Generator;
import edu.project2.Generators.RecursiveBacktrackingGenerator;
import edu.project2.Generators.SidewinderGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Tests {
    @Test
    @DisplayName("Error coordinate")
    void validCoordinate() {
        assertThatThrownBy(() -> new Coordinate(-1, 0));
    }

    @Test
    @DisplayName("Null field error")
    void nullField() {
        assertThatThrownBy(() -> new Maze(null, new Coordinate(1, 1), new Coordinate(2, 2)));
    }

    @Test
    @DisplayName("Empty field error")
    void emptyField() {
        assertThatThrownBy(() -> new Maze(new Cell[0][4], new Coordinate(1, 1), new Coordinate(2, 2)));
        assertThatThrownBy(() -> new Maze(new Cell[5][0], new Coordinate(1, 1), new Coordinate(2, 2)));
    }

    @Test
    @DisplayName("Bad coordinates of start and finish error")
    void badStartOfFinishNotOnField() {
        assertThatThrownBy(() -> new Maze(new Cell[5][5], new Coordinate(6, 1), new Coordinate(2, 2)));
        assertThatThrownBy(() -> new Maze(new Cell[5][5], new Coordinate(1, 1), new Coordinate(6, 2)));
        assertThatThrownBy(() -> new Maze(new Cell[5][5], new Coordinate(1, 1), new Coordinate(0, 2)));
        assertThatThrownBy(() -> new Maze(new Cell[5][5], new Coordinate(0, 1), new Coordinate(6, 2)));
    }

    @Test
    @DisplayName("Cannot go from start to finish")
    void badStartOfFinish() {
        assertThatThrownBy(() -> new Maze(new Cell[5][5], new Coordinate(2, 1), new Coordinate(2, 2)));
        assertThatThrownBy(() -> new Maze(new Cell[5][5], new Coordinate(1, 1), new Coordinate(2, 2)));
    }

    static Arguments[] generators() {
        return new Arguments[] {Arguments.of(new RecursiveBacktrackingGenerator()), Arguments.of(new SidewinderGenerator())};
    }

    @ParameterizedTest()
    @MethodSource("generators")
    @DisplayName("Generator error")
    void generatorTest(Generator generator) {
        assertThat(generator.generate(23, 12)).isNotNull();
        assertThatThrownBy(() -> generator.generate(1, 3)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> generator.generate(0, 1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> generator.generate(-8, -3)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> generator.generate(0, 0)).isInstanceOf(IllegalArgumentException.class);
    }
}
