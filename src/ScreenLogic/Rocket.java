package ScreenLogic;

import SimulationLogic.LogicManager;
import processing.core.*;

public class Rocket extends Screen {

  PApplet p;
  PImage photo;
  LogicManager lm;
  double h, t, v;
  Background bg;

  Rocket(PApplet p) {
    this.p = p;
    photo = this.p.loadImage("Rocket.png");
    lm = new LogicManager(this.p);
    bg = new Background(this.p);
  }

  void update() {
    h = lm.getRocketLogic().getH();
    t = lm.getRocketLogic().getT();
    v = lm.getRocketLogic().getV();
    lm.logic();
  }

  void show() {
    bg.showBackground(h);
    p.image(photo, p.width / 2 - 37, 300);
    p.fill(0);
    p.textSize(20);
    p.rect(6, 10, 10 + p.textWidth("Velocity: " + (int) v + " m/s"), 90);
    p.fill(255);
    p.text("Height: " + (int) h + " m", 10, 30);
    p.text("Time: " + (int) t + " s", 10, 60);
    p.text("Velocity: " + (int) v + " m/s", 10, 90);
  }

}
