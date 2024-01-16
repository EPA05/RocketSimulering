package ScreenLogic;

import processing.core.*;

/**
 * The Bomb class represents a bomb object in the rocket simulation.
 * It is responsible for displaying the bomb on the screen, checking if it hits
 * the rocket, and providing its position.
 */
public class Bomb {
  PApplet p;
  PImage photo; // The image of the bomb
  int x; // The x-coordinate of the bomb
  int y; // The y-coordinate of the bomb
  Rocket r; // The rocket object

  public Bomb(PApplet p) {
    this.p = p;
    photo = this.p.loadImage("Bomb.png");
    x = 0;
    y = -50;
  }

  /**
   * Displays the bomb on the screen.
   */
  public void show() {
    if (x == 0) {
      x = (int) (Math.random() * p.width);
    }
    y = y + 10;
    p.image(photo, x, y);
  }

  /**
   * Checks if the bomb hits the rocket returns true if hit otherwise false.
   */
  public boolean hitRocket(Rocket r) {
    if (x + photo.width / 2 > r.x && x + photo.width / 2 < r.x + r.photo.width && y + photo.height > r.y
        && y + photo.height < r.y + r.photo.height) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Gets the x-coordinate of the bomb and returns it.
   */
  public int getX() {
    return x;
  }

  /**
   * Gets the y-coordinate of the bomb and returns it.
   */
  public int getY() {
    return y;
  }
}