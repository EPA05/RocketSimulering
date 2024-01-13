package ScreenLogic;

import ScreenLogic.Screens.StartScreen;
import processing.core.*;

public class ScreenManager {
  PApplet p;
  Screen currentScreen;
  private int coinCount;
  private int massUpgradeCount;
  private int fuelUpgradeCount;
  private int thrustUpgradeCount;
  private int dragUpgradeCount;

  public ScreenManager(PApplet p) {
    this.p = p;
    currentScreen = new StartScreen(this.p, this);
    coinCount = 0;
    massUpgradeCount = 0;
  }

  public void show() {
    p.background(0);
    currentScreen.show();
    currentScreen.update();
  }

  public void changeScreen(Screen screen) {
    currentScreen = screen;
  }

  public int getCoinCount() {
    return coinCount;
  }

  public void addCoin(int amount) {
    coinCount += amount;
  }

  public void subtractCoin(int amount) {
    coinCount -= amount;
  }

  public int fuelUpgradeCount() {
    return massUpgradeCount;
  }

  public void addFuelUpgradeCount() {
    massUpgradeCount++;
  }

  public int massUpgradeCount() {
    return massUpgradeCount;
  }

  public void addMassUpgradeCount() {
    massUpgradeCount++;
  }

  public int thrustUpgradeCount() {
    return thrustUpgradeCount;
  }

  public void addThrustUpgradeCount() {
    thrustUpgradeCount++;
  }

  public int dragUpgradeCount() {
    return dragUpgradeCount;
  }

  public void addDragUpgradeCount() {
    dragUpgradeCount++;
  }
}
