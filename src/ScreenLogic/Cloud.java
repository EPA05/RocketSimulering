package ScreenLogic;

import processing.core.PApplet;
import processing.core.PImage;

public class Cloud {

  PApplet p;
  PImage cloud;
  float x, y;
  int resizeFactor;

  public Cloud(PApplet p) {
    this.p = p;
    this.cloud = this.p.loadImage("Cloud.png");

    x = (float) p.random(0, p.width);
    y = -50;
    resizeFactor = (int) p.random(50, 150);

    cloud.resize(resizeFactor, resizeFactor);
  }

  void showCloud() {
    p.image(cloud, x, y);
  }

  void updateY() {
    y += 20;
  }

  float getY() {
    return y;
  }

  int getCloudHeight() {
    return cloud.height;
  }
}
