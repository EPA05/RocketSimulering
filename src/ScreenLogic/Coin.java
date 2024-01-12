package ScreenLogic;

import processing.core.*;

public class Coin {
  Rocket r;
  PApplet p;
  PImage photo;
  int x, y;
  int coin;

  public Coin(PApplet p) {
    this.p = p;
    photo = p.loadImage("Gold Coin.png");
    x = 0;
    y = -50;
  }

  public void show() {

    if (x == 0) {
      x = (int) (Math.random() * p.width);
    }
    y = y + 10;
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

  void coinCounter() {
    p.textSize(32);
    p.fill(255);
    p.text("Coins: " + coin, p.width - 50, 30);
    if (hitRocket(r)) {
      coin++;

    }
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

}