import org.code.theater.*;
import org.code.media.*;
import org.code.theater.*;
import org.code.media.*;

/*
 * Represents a sharpened image
 */
public class SharpImage extends ImagePlus {

  /*
   * Calls the superclass constructor to initialize pixels
   */
  public SharpImage(String filename) {
    super(filename);
  }

  /*
   * Sharpens the image by calculating the difference between the color values of the current
   * and neighboring Pixel objects and adjust the color values to emphasize the edges
   */
  public void sharpen() {
    /* ----------------------------------- TO DO -----------------------------------
     * ✅ Get the pixels from the image, and traverse the 2D array of Pixel objects.
     * Calculate the difference between the current pixel and its top-left
     * neighbor in red, green, and blue values. Then find the average difference by
     * dividing these differences by 3. Adjust the color values of the current pixel
     * by adding the average difference to the current color values. Make sure the
     * new colors are less than or equal to 255! Then set the color values for the
     * current pixel to the new color values.
     * -----------------------------------------------------------------------------
     */

    Pixel[][] pixels = getImagePixels();

    for (int row = 1; row < pixels.length - 1; row++) {
      for (int col = 1; col < pixels[0].length - 1; col++) {
        Pixel currentPixel = pixels[row][col];
        
        int redDiff = currentPixel.getRed() - pixels[row - 1][col - 1].getRed();
        int greenDiff = currentPixel.getGreen() - pixels[row - 1][col - 1].getGreen();
        int blueDiff = currentPixel.getBlue() - pixels[row - 1][col - 1].getBlue();
        int averageDiff = (redDiff + greenDiff + blueDiff) / 3;

        int newRed = currentPixel.getRed() + averageDiff;
        int newGreen = currentPixel.getGreen() + averageDiff;
        int newBlue = currentPixel.getBlue() + averageDiff;

        if (newRed > 255) {
          newRed = 255;
        }

        if (newGreen > 255) {
          newGreen = 255;
        }

        if (newBlue > 255) {
          newBlue = 255;
        }

        currentPixel.setRed(newRed);
        currentPixel.setGreen(newGreen);
        currentPixel.setBlue(newBlue);
      }
    }

    
  }
  
}