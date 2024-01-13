package ScreenLogic;

import java.util.ArrayList;
import processing.core.*;

public class Background {

  PApplet p;
  ArrayList<Cloud> clouds;

  Background(PApplet p) {
    this.p = p;
    clouds = new ArrayList<Cloud>();
  }

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

  void cloudLogic() {
    if (clouds.size() < 10 && p.frameCount % 10 == 0) {
      clouds.add(new Cloud(p));
    }

    for (int i = 0; i < clouds.size(); i++) {
      if (clouds.get(i).getY() > (p.height + clouds.get(i).getCloudHeight())) {
        clouds.remove(i);
      }
    }
  }

  void displayCloud() {
    for (int i = 0; i < clouds.size(); i++) {
      clouds.get(i).updateY();
      clouds.get(i).showCloud();
    }
  }
}
