package ScreenLogic.Screens;

import ScreenLogic.Rocket;
import ScreenLogic.Screen;
import ScreenLogic.ScreenManager;
import processing.core.*;

public class StartScreen extends Screen {

  PApplet p;
  ScreenManager sm;
  Screen screen;
  boolean isEnterPressed;

  public StartScreen(PApplet p, ScreenManager sm) {
    this.p = p;
    this.sm = sm;
    isEnterPressed = false;
  }

  public void show() {
    p.background(0);
    p.textSize(32);
    p.fill(255);
    p.text("Press Enter to start", 100, 100);

    if (p.keyPressed && p.key == PConstants.ENTER) {
      sm.changeScreen(new Rocket(this.p, sm));
    }
  }
}
