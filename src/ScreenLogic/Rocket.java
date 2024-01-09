package ScreenLogic;

import java.util.ArrayList;

import ScreenLogic.Screens.GameOverScreen;
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
  ArrayList<Bomb> bombs;
  ScreenManager sm;

  public Rocket(PApplet p, ScreenManager sm) {
    this.p = p;
    photo = this.p.loadImage("Rocket.png");
    lm = new LogicManager(this.p);
    bg = new Background(this.p);
    bombs = new ArrayList<Bomb>();
    this.sm = sm;
    x = 300;
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
    bg.cloudLogic();
    bg.displayCloud();
    bomb();

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

  public void bomb() {
    if (bombs.size() < 7 && p.frameCount % 50 == 0) {
      bombs.add(new Bomb(p));
    }
    for (int i = 0; i < bombs.size(); i++) {
      bombs.get(i).show();
    }

    for (int i = 0; i < bombs.size(); i++) {
      if (bombs.get(i).getY() > (p.height)) {
        bombs.remove(i);
      }
    }

    for (int i = 0; i < bombs.size(); i++) {
      if (bombs.get(i).hitRocket(this)) {
        sm.changeScreen(new GameOverScreen(this.p, sm));
      }
    }
  }
}
