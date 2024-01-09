package ScreenLogic;

import processing.core.*;

public class Bomb {
  PApplet p;
  PImage photo;
  int x;
  int y;

  public Bomb(PApplet p) {
    this.p = p;
    photo = this.p.loadImage("Bomb.png");
    x = 0;
    y = -50;

  }

  public void show() {
    if (x == 0) {
      x = (int) (Math.random() * p.width);
    }
    y = y + 3;
    p.image(photo, x, y);
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }
}