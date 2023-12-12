import ScreenLogic.ScreenManager;
import processing.core.*;

public class App extends PApplet {

  ScreenManager sm;

  public static void main(String[] args) {
    PApplet.main("App"); // This is the line that starts the program
  }

  public void settings() {
    sm = new ScreenManager(this);
    size(620, 480, P2D);
    smooth(8);
  }

  public void setup() {
    frameRate(24);
  }

  public void draw() {
    sm.show();
  }
}
