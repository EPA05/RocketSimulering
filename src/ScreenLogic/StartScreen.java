package ScreenLogic;

import processing.core.PApplet;
import processing.core.PConstants;

public class StartScreen extends Screen {

  PApplet p;
  ScreenManager sm;

  public StartScreen(PApplet p, ScreenManager sm) {
    this.p = p;
    this.sm = sm;
  }

  public void show() {
    p.background(0);
    p.textSize(32);
    p.fill(255);
    p.text("Press Enter to start", 100, 100);
    if (p.keyCode == PConstants.ENTER) {
      sm.changeScreen(new Rocket(this.p));
    }
  }
}
