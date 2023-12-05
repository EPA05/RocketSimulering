package ScreenLogic;

import processing.core.*;

public class Rocket {
  PApplet p;
  PImage photo;

  Rocket(PApplet p) {
    this.p = p;
    photo = p.loadImage("Rocket.png");
  }

  public void show() {
    p.image(photo, 0, 0);
  }

}
