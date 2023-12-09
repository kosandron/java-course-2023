package edu.project4.Rendering;

import edu.project4.FractalImage;
import edu.project4.Transformations.Transformation;
import java.util.List;

public interface Renderer {
    FractalImage render(
        FractalImage image,
        Rectangle world,
        List<Transformation> transformations,
        int samples,
        int iterationsPerSample,
        int symmetry
    );
}
