package ScreenLogic;

import processing.core.*;

public class Bomb {
  PApplet p;
  PImage photo;
  int x;
  int y;
  Rocket r;

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

  public boolean hitRocket(Rocket r) {
    if (x + photo.width / 2 > r.x && x + photo.width / 2 < r.x + r.photo.width && y + photo.height > r.y
        && y + photo.height < r.y + r.photo.height) {
      return true;
    } else {
      return false;
    }
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }
}