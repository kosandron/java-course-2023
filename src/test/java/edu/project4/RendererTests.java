package edu.project4;

import edu.project4.Rendering.MultiThreadRenderer;
import edu.project4.Rendering.Rectangle;
import edu.project4.Rendering.SimpleRenderer;
import edu.project4.Transformations.DiskTransformation;
import edu.project4.Transformations.HeartTransformation;
import edu.project4.Transformations.LinearTransformation;
import edu.project4.Transformations.SinusoidalTransformation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

public class RendererTests {
    @Test
    void simpleRendererRightWork() {
        Assertions.assertDoesNotThrow(() ->
            new SimpleRenderer().render(
                FractalImage.create(1900, 1080),
                new Rectangle(1.777, 1, 3.554, 2),
                List.of(
                    new SinusoidalTransformation(),
                    new LinearTransformation()
                ),
                20000, 2000, 1
            )
        );
    }

    @Test
    void multiThreadRendererRightWork() {
        Assertions.assertDoesNotThrow(() ->
            new MultiThreadRenderer(-1).render(
                FractalImage.create(1000, 1000),
                new Rectangle(1.777, 1, 3.554, 2),
                List.of(
                    new HeartTransformation(),
                    new LinearTransformation(),
                    new DiskTransformation()
                ),
                2000, 3000, 2
            )
        );
    }
}
