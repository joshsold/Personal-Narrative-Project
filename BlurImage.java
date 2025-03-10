import org.code.theater.*;
import org.code.media.*;

/*
 * Represents a blurred image
 */
public class BlurImage extends ImagePlus {

  /*
   * Calls the superclass constructor to initialize pixels
   */
  public BlurImage(String filename) {
    super(filename);
  }

  /*
   * Applies a motion blur to the image
   */
  public void motionBlur(int length, String direction) {
    /* ----------------------------------- TO DO -----------------------------------
     * ✅ Get the pixels from the image, and traverse the 2D array of Pixel objects.
     * Find the average of the red, green, and blue color values of the current
     * Pixel object and a set of neighboring Pixel objects in a line segment.
     * -----------------------------------------------------------------------------
     */

    Pixel[][] pixels = getImagePixels();

    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[0].length; col++) {
        int totalRed = 0;
        int totalGreen = 0;
        int totalBlue = 0;

        int x = col;
        int y = row;
        int count = 0;

        while (count < length && x < pixels[0].length && y < pixels.length) {
          Pixel currentPixel = pixels[y][x];
          totalRed += currentPixel.getRed();
          totalGreen += currentPixel.getGreen();
          totalBlue += currentPixel.getBlue();
          count++;

          if (direction.equals("horizontal")) {
            x++;
          }
          else if (direction.equals("vertical")) {
            y++;
          }
          else if (direction.equals("diagonal")) {
            x++;
            y++;
          }
        }

        int avgRed = totalRed / count;
        int avgGreen = totalGreen / count;
        int avgBlue = totalBlue / count;

        Pixel currentPixel = pixels[row][col];
        currentPixel.setRed(avgRed);
        currentPixel.setGreen(avgGreen);
        currentPixel.setBlue(avgBlue);
      }
    }

    
  }
  
}