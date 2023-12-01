package ScreenLogic;

import processing.core.*;

public class Background {

  PApplet p;

  Background(PApplet p) {
    this.p = p;
  }

  void showBackground(double hIn) {
    int tempH = (int) hIn;

    int R = (int) PApplet.map(tempH, 0, 100, 205, 0);
    R = PApplet.constrain(R, 0, 255);
    int G = (int) PApplet.map(tempH, 0, 100, 255, 0);
    G = PApplet.constrain(G, 0, 255);
    int B = (int) PApplet.map(tempH, 0, 150, 255, 0);
    B = PApplet.constrain(B, 0, 255);

    p.background(R, G, B);
  }
}
