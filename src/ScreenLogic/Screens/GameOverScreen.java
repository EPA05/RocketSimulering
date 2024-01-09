package ScreenLogic.Screens;

import processing.core.*;
import ScreenLogic.ScreenManager;
import ScreenLogic.Screen;

public class GameOverScreen extends Screen {
  PApplet p;
  ScreenManager sm;

  public GameOverScreen(PApplet p, ScreenManager sm) {
    this.p = p;
    this.sm = sm;
  }

  public void show() {
    p.background(0);
    p.textSize(32);
    p.fill(255);
    p.text("GameOver", 100, 100);

  }
}
