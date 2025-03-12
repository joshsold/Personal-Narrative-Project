import org.code.theater.*;
import org.code.media.*;
/*
 * TheaterRunner Class
 */
public class TheaterRunner {
  public static void main(String[] args) {
/*
 * Creating 2d array that stores text for types of sets
 */
    String[][] sets = {
      {"outside", "GO: called BLACK in the diagram"},
      {"middle", "SHOOT"},
      {"opposite", "RED"}
    };
    /*
 * represents 2d array for text elements
 */
        String[][] text = {
      {"Hi! I am going to explain what a perfect "+ "\n" + "sideout in volleyball is.", "A sideout in volleyball is a quick point earned when receiving.", null, null},
      {"The opponent serves a strong ball!", "then, it is the passers job to pass the ball.", "he gets a great pass!", null},
      {"Now, it is the setter's job to set the ball to one of three primary hitters:", "the outside(left side), the middle(middle), and opposite(right side).", "there are many different types of sets, here is a diagram to show a few.", "he ends up setting a SHOOT ball to the middle blocker"},
      {"Now its the middle's job to try and get a kill, or a point from his attack.", "The ball hits the ground, the middle gets a great kill!", "Now, the team celebrates!", null}
    };
/*
 * runs the scenes
 */
    MyStory sideOut = new MyStory(sets, text);
sideOut.drawScene();
Theater.playScenes(sideOut);
    

    
    
  }
}