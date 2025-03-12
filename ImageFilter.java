import org.code.theater.*;
import org.code.media.*;

/*
 * Represents a image that shows impact
 */
public class ImageFilter extends ImagePlus {

  /*
   * Constructor to create a ImpactImage
   * with the specified file name
   */
  public ImageFilter(String filename) {
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
  
  public void sharpen() {

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
    }}
  public void motionBlur(int length, String direction) {


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
    

  public void USCFilter() {
    Pixel[][] pixels = getImagePixels();

    for (int row = 0; row < pixels.length; row++) {
        for (int col = 0; col < pixels[0].length; col++) {
            Pixel currentPixel = pixels[row][col];

            // Red color
            int redRed = 153;
            int redGreen = 0;
            int redBlue = 0;

            // gold color
            int goldRed = 255;
            int goldGreen = 204;
            int goldBlue = 0;

            // current pixel values
            int currentRed = currentPixel.getRed();
            int currentGreen = currentPixel.getGreen();
            int currentBlue = currentPixel.getBlue();

            // calculate distance t
            double distanceToRed = Math.sqrt(Math.pow(currentRed - redRed, 2) + 
                                             Math.pow(currentGreen - redGreen, 2) + 
                                             Math.pow(currentBlue - redBlue, 2));

            double distanceToGold = Math.sqrt(Math.pow(currentRed - goldRed, 2) + 
                                              Math.pow(currentGreen - goldGreen, 2) + 
                                              Math.pow(currentBlue - goldBlue, 2));

            if (distanceToRed < distanceToGold) {
                // Closer to red → set pixel to red
                currentPixel.setRed(redRed);
                currentPixel.setGreen(redGreen);
                currentPixel.setBlue(redBlue);
            } else {
                // Closer to gold → set pixel to gold
                currentPixel.setRed(goldRed);
                currentPixel.setGreen(goldGreen);
                currentPixel.setBlue(goldBlue);
            }
        }
    }
}
}