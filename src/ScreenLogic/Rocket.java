package ScreenLogic;

import SimulationLogic.LogicManager;
import processing.core.*;

public class Rocket extends Screen {

  PApplet p;
  PImage photo;
  LogicManager lm;
  double h, t, v;
  Background bg;
  int x;
  int y;

  public Rocket(PApplet p) {
    this.p = p;
    photo = this.p.loadImage("Rocket.png");
    lm = new LogicManager(this.p);
    bg = new Background(this.p);
    y = 300;
  }

  void update() {
    h = lm.getRocketLogic().getH();
    t = lm.getRocketLogic().getT();
    v = lm.getRocketLogic().getV();
    x = lm.getRocketMovement().getX();
    lm.logic();
  }

  public void show() {
    bg.showBackground(h);
    p.image(photo, x, y);

    switch ((int) (Math.random() * 3)) {
      case 0:
        photo = p.loadImage("Raket1.png");
        break;
      case 1:
        photo = p.loadImage("Raket2.png");
        break;
      case 2:
        photo = p.loadImage("Raket3.png");
        break;
    }

    p.fill(0);
    p.textSize(20);
    p.rect(6, 10, 10 + p.textWidth("Velocity: " + (int) v + " m/s"), 90);
    p.fill(255);
    p.text("Height: " + (int) h + " m", 10, 30);
    p.text("Time: " + (int) t + " s", 10, 60);
    p.text("Velocity: " + (int) v + " m/s", 10, 90);
  }

}
