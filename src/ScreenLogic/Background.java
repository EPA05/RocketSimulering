package ScreenLogic;

import java.util.ArrayList;
import processing.core.*;

/**
 * The Background class represents the background of the simulation.
 * It handles the display of the background color and the clouds.
 */
public class Background {

  PApplet p;
  ArrayList<Cloud> clouds;

  Background(PApplet p) {
    this.p = p;
    clouds = new ArrayList<Cloud>();
  }

  /**
   * Displays the background color based on the given height value.
   */
  void showBackground(double hIn) {
    int tempH = (int) hIn;

    int R = (int) PApplet.map(tempH, 0, 1000, 205, 0);
    R = PApplet.constrain(R, 0, 255);
    int G = (int) PApplet.map(tempH, 0, 1000, 255, 0);
    G = PApplet.constrain(G, 0, 255);
    int B = (int) PApplet.map(tempH, 0, 1500, 255, 0);
    B = PApplet.constrain(B, 0, 255);

    p.background(R, G, B);
  }

  /**
   * Handles the logic for creating and removing clouds.
   */
  void cloudLogic() {
    if (clouds.size() < 10 && p.frameCount % 10 == 0) {
      clouds.add(new Cloud(p));
    }
    for (int i = 0; i < clouds.size(); i++) {
      if (clouds.get(i).getY() > (p.height + clouds.get(i).getCloudHeight())) {
        clouds.remove(i); // Remove the cloud if it is off the screen
      }
    }
  }

  /**
   * Displays the clouds on the screen.
   */
  void displayCloud() {
    for (int i = 0; i < clouds.size(); i++) {
      clouds.get(i).updateY();
      clouds.get(i).showCloud();
    }
  }
}
