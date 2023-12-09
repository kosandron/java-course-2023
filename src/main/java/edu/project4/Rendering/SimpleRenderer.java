package edu.project4.Rendering;

import edu.project4.AffineFactor;
import edu.project4.FractalImage;
import edu.project4.Transformations.Transformation;
import java.util.List;

public class SimpleRenderer extends RendererBase {
    @Override
    public FractalImage render(
        FractalImage image,
        Rectangle world,
        List<Transformation> transformations,
        int samples,
        int iterationsPerSample,
        int symmetry
    ) {
        AffineFactor[] affineFactorsArray = getRandomAffineFactors(transformations.size());
        for (int num = 0; num < samples; num++) {
            renderSample(
                image,
                world,
                iterationsPerSample,
                symmetry,
                transformations,
                affineFactorsArray
            );
        }

        return image;
    }
}
