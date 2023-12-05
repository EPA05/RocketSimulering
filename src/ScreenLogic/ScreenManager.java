package ScreenLogic;

import ScreenLogic.Screens.StartScreen;
import processing.core.*;

public class ScreenManager {

  PApplet p;
  Screen currentScreen;

  public ScreenManager(PApplet p) {
    this.p = p;
    currentScreen = new StartScreen(this.p, this);
  }

  public void show() {
    p.background(0);
    currentScreen.update();
    currentScreen.show();
  }

  public void changeScreen(Screen screen) {
    currentScreen = screen;
  }
}
