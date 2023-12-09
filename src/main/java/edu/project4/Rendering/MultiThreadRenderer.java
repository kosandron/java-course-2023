package edu.project4.Rendering;

import edu.project4.AffineFactor;
import edu.project4.FractalImage;
import edu.project4.Transformations.Transformation;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultiThreadRenderer extends RendererBase {
    private static final int TIMEOUT = 7;
    private final ExecutorService executorService;

    public MultiThreadRenderer(int numThreads) {
        executorService =
            Executors.newFixedThreadPool(numThreads > 0 ? numThreads : Runtime.getRuntime().availableProcessors());
    }

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
        for (int i = 0; i < samples; i++) {
            executorService.execute(() -> renderSample(
                image,
                world,
                iterationsPerSample,
                symmetry,
                transformations,
                affineFactorsArray
            ));
        }
        executorService.shutdown();

        try {
            executorService.awaitTermination(TIMEOUT, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return image;
    }
}
