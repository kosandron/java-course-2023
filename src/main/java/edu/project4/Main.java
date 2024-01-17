package edu.project4;

import edu.project4.Rendering.ImageCorrection.GammaCorrection;
import edu.project4.Rendering.MultiThreadRenderer;
import edu.project4.Rendering.Rectangle;
import edu.project4.Transformations.HeartTransformation;
import edu.project4.Transformations.LinearTransformation;
import edu.project4.Transformations.SpiralTransformation;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public final class Main {
    private static final Path IMAGE1 = Path.of("src/test/java/edu/project4/examples/image.png");
    private static final Path IMAGE2 = Path.of("src/test/java/edu/project4/examples/imageGamma.png");

    private Main() {
    }

    @SuppressWarnings("MagicNumber")
    public static void main(String[] args) throws IOException {

        var image = new MultiThreadRenderer(-1).render(
            FractalImage.create(1920, 1080),
            new Rectangle(1.777, 1, 3.554, 2),
            List.of(
                new LinearTransformation(),
                new HeartTransformation(),
                new SpiralTransformation()
            ),
            10000, 2000, 2
        );

        ImagePrinter.save(
            image,
            IMAGE1,
            ImageFormat.PNG
        );
        GammaCorrection correction = new GammaCorrection();
        correction.process(image);
        ImagePrinter.save(
            image,
            IMAGE2,
            ImageFormat.PNG
        );
    }
}
