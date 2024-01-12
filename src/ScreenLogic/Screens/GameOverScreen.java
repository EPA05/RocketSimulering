package ScreenLogic.Screens;

import processing.core.*;
import ScreenLogic.Rocket;
import ScreenLogic.Screen;
import ScreenLogic.ScreenManager;

public class GameOverScreen extends Screen {
  PApplet p;
  int maxHeight;
  ScreenManager sm;
  Screen screen;

  public GameOverScreen(PApplet p, ScreenManager sm, int mh) {
    this.p = p;
    this.sm = sm;
    maxHeight = mh;

  }

  public void show() {
    p.background(0);
    p.textSize(32);
    p.fill(255);
    p.text("GameOver", 100, 100);
    p.text("Your max height was: " + maxHeight + "meters", 100, 150);
    p.text("Press Enter to restart", 100, 200);

    if (p.keyPressed == true && p.key == PConstants.ENTER) {
      sm.changeScreen(new StartScreen(this.p, sm));
    }
  }
}
