import org.code.theater.*;
import org.code.media.*;

/*
 * Represents a image that shows impact
 */
public class ImpactImage extends ImagePlus {

  /*
   * Constructor to create a ImpactImage
   * with the specified file name
   */
  public ImpactImage(String filename) {
    super(filename);
  }

  /*
   * Applies a impact filter to the image
   */
  public void makeImpact() {
    Pixel[][] pixels = getPixelsFromImage();

    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[0].length; col++) {
        Pixel currentPixel = pixels[row][col];

        int currentRed = currentPixel.getRed();
        int currentGreen = currentPixel.getGreen();
        int currentBlue = currentPixel.getBlue();

        int newRed = (int)((0.693 * currentRed) + (0.769 * currentGreen) + (0.189 * currentBlue));
        int newGreen = (int)((0.649 * currentRed) + (0.686 * currentGreen) + (0.168 * currentBlue));
        int newBlue = (int)((0.672 * currentRed) + (0.534 * currentGreen) + (0.431 * currentBlue));

        currentPixel.setRed(newRed);
        currentPixel.setGreen(newGreen);
        currentPixel.setBlue(newBlue);
      }
    }
  }
  
}