import org.code.theater.*;
import org.code.media.*;

public class MyStory extends Scene {
/*
 * Declaring sets and text 2d arrays and constructor
 */
String[][] sets;
String[][] text;

  public MyStory (String[][] sets, String[][] text){
    this.sets = sets;
    this.text = text;
  }

/*
 * Calls all scenes
 */

public void drawScene() {
  drawIntro();
  drawServePassScene();
  
  drawSetScene();
    drawHitScene();
/*
 * First scene
  * text styles declared
   * draws first row of text from 2d array
 */
}
  public void drawIntro() {

    setTextStyle(Font.SANS, FontStyle.BOLD);
    setTextColor("black");
    setTextHeight(12);

    for(int i = 0; i < 2; i++){
           drawText(text[0][i], 10, 200);
      pause(3);
      clear("white");
    }
  }
  /*
 * 2nd scene
  * Image variable is used to display the images
   * due to names of images, we are able to traverse them with a for loop
 */
  public void drawServePassScene() {
    clear("white");

    String image = null;
    for(int i = 1; i < 4; i++){
      image = "myStory-" + i + ".png";
      drawImage(image, 0, 100, 400);
      drawText(text[1][i - 1], 10, 350);
      pause(3);
    clear("white");
/*
 * if statement to check for specific image
 * if true, then creates filter object, applies impact filter to image
 */
      if(image.equals("myStory-3.png")){
        ImageFilter photo = new ImageFilter(image);
        photo.makeImpact();
        drawImage(photo, 0, 100, 400);
        pause(3);
        clear("white");
      }
    }

  }
/*
 * 3rd scene
 * same traversal method from previous method
 * uses two string class method, first to check and display extra text on a specific image, or to continue drawing images
 * second method is used to emphasize the hitter name by making it uppercase
 */
  public void drawSetScene() {
 clear("white");
    String image = null;

    for(int i = 4; i < 8; i++){
      image = "myStory-" + i + ".png";
/*
 * checks if image is the setting diagram
 * uses sharpen image filter repeatedly
 */
if (image.equals("myStory-6.png")) {
      ImageFilter photo = new ImageFilter(image);
        drawImage(photo, 0, 100, 400);
    for (int row = 0; row < sets.length; row++) {
        drawImage(photo, 0, 100, 400);
        drawText(("for the " + sets[row][0].toUpperCase() + ","), 60, 340); // Using toUpperCase()
        drawText(("A common set is called a " + sets[row][1] + "."), 30, 370);
        pause(3);
        clear("white");
        photo.sharpen();    
    }
/*
 * Checks for specific image
 * if true, creates ImageFilter object and applies motion blur filter
 */
} else if(image.equals("myStory-7.png")) {
    ImageFilter photo = new ImageFilter(image);
    drawImage(image, 0, 100, 400);
    drawText(text[2][i - 4], 10, 350);
  pause(2);
  clear("white");
  photo.motionBlur(7, "horizontal");
        drawImage(photo, 0, 100, 400);
pause(2);
  clear("white");
     } else{
      drawImage(image, 0, 100, 400);
    drawText(text[2][i - 4], 10, 350);
  pause(3);
  clear("white");
     }
    }}
/*
 * 4th scene
 * same traversal method
 */
  public void drawHitScene() {
        clear("white");
    String image = null;

for(int i = 8; i < 11; i++){
      image = "myStory-" + i + ".png";
      drawImage(image, 0, 100, 400);
       drawText(text[3][i - 8], 10, 350);
/*
 * checks for when it is the final image
 * if true, applies USC filter
 * plays applause audio
 */
      pause(3);
    clear("white");
  if(i == 10){
        ImageFilter photo = new ImageFilter(image);
        photo.USCFilter();
        drawImage(photo, 0, 100, 400);
        drawText("Go USC!", 10, 350);
playSound("applause3.wav");
    pause(3);
    clear("white");
  }
}
  }
}
