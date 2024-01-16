package ScreenLogic;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * The Cloud class represents a cloud object in the simulation.
 */
public class Cloud {

  PApplet p;
  PImage cloud; // The image of the cloud
  float x, y; // The position of the cloud
  int resizeFactor; // The resize factor of the cloud

  public Cloud(PApplet p) {
    this.p = p;
    this.cloud = this.p.loadImage("Cloud.png");

    x = (float) p.random(0, p.width);
    y = -50;
    resizeFactor = (int) p.random(50, 150);

    cloud.resize(resizeFactor, resizeFactor);
  }

  /**
   * Displays the cloud on the screen.
   */
  void showCloud() {
    p.image(cloud, x, y);
  }

  /**
   * Updates the y-coordinate of the cloud.
   */
  void updateY() {
    y += 20;
  }

  /**
   * Returns the current y-coordinate of the cloud.
   */
  float getY() {
    return y;
  }

  /**
   * Returns the height of the cloud image.
   */
  int getCloudHeight() {
    return cloud.height;
  }
}
