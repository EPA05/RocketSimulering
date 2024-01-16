package ScreenLogic;

import processing.core.*;

/**
 * The Coin class represents a coin object in the rocket simulation.
 * It is responsible for displaying the coin, checking if it hits the rocket,
 * and keeping track of the number of collected coins.
 */
public class Coin {
  Rocket r; // Reference to the rocket object
  PApplet p; // Reference to the PApplet object
  PImage photo; // The image of the coin
  int x, y; // The position of the coin
  int coin; // The number of collected coins

  public Coin(PApplet p) {
    this.p = p;
    photo = p.loadImage("Gold Coin.png");
    x = 0;
    y = -50;
  }

  /**
   * Displays the coin on the screen.
   */
  public void show() {
    if (x == 0) {
      x = (int) (Math.random() * p.width);
    }
    y = y + 10;
    p.image(photo, x, y);
  }

  /**
   * Checks if the coin hits the rocket.
   * Returns true if hit otherwise false.
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
   * Updates the coin counter and displays the number of collected coins on the
   * screen.
   */
  void coinCounter() {
    p.textSize(32);
    p.fill(255);
    p.text("Coins: " + coin, p.width - 50, 30);
    if (hitRocket(r)) { // Checks if the coin hits the rocket
      coin++; // Updates the coin counter
    }
  }

  /**
   * Gets the x-coordinate of the coin and returns it.
   */
  public int getX() {
    return x;
  }

  /**
   * Gets the y-coordinate of the coin and returns it.
   */
  public int getY() {
    return y;
  }
}