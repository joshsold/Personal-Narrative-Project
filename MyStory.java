import org.code.theater.*;
import org.code.media.*;

public class MyStory extends Scene {

String[][] sets;
String[][] text;

  public MyStory (String[][] sets, String[][] text){
    this.sets = sets;
    this.text = text;
  }



public void drawScene() {
  drawIntro();
  drawServePassScene();
  drawSetScene();
    drawHitScene();

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
  public void drawServePassScene() {
    clear("white");
    String image = null;
    for(int i = 1; i < 4; i++){
      image = "myStory-" + i + ".png";
      drawImage(image, 0, 100, 400);
      drawText(text[1][i - 1], 10, 350);
      pause(3);
    clear("white");
    }

  }
  public void drawSetScene() {
 clear("white");
    String image = null;
    for(int i = 4; i < 8; i++){
      image = "myStory-" + i + ".png";
      drawImage(image, 0, 100, 400);
     if(image.equals("myStory-6.png")){
        for (int row = 0; row < sets.length; row++) {
              drawText(("for the " + sets[row][0] + ","), 60, 340);
              drawText(("A common set is called a " + sets[row][1] + "."), 30, 370);
              pause(3);
              clear("white");
              drawImage(image, 0, 100, 400);
     }} else {
            drawText(text[2][i - 4], 10, 350);
     }
  }
  }
  public void drawHitScene() {
        clear("white");
    String image = null;
for(int i = 8; i < 11; i++){
      image = "myStory-" + i + ".png";
      drawImage(image, 0, 100, 400);
       drawText(text[3][i - 8], 10, 350);

      pause(3);
    clear("white");
}
  }
}