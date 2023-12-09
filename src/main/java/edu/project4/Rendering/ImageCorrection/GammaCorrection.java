package edu.project4.Rendering.ImageCorrection;

import edu.project4.FractalImage;
import edu.project4.Pixel;

public class GammaCorrection implements ImageProcessor {
    private static final double GAMMA = 2.2;

    @Override
    public void process(FractalImage image) {
        double mx = 0;
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                Pixel curPixel = image.getPixel(x, y);
                if (curPixel.getHitCount() != 0) {
                    curPixel.setNormal(Math.log10(curPixel.getHitCount()));
                    mx = Math.max(mx, curPixel.getNormal());
                }
            }
        }
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                Pixel curPixel = image.getPixel(x, y);
                curPixel.setNormal(curPixel.getNormal() / mx);
                curPixel.setRed((int) (curPixel.getRed() * Math.pow(curPixel.getNormal(), (1.0 / GAMMA))));
                curPixel.setGreen((int) (curPixel.getGreen() * Math.pow(curPixel.getNormal(), (1.0 / GAMMA))));
                curPixel.setBlue((int) (curPixel.getBlue() * Math.pow(curPixel.getNormal(), (1.0 / GAMMA))));
            }
        }
    }
}
