package ScreenLogic;

import ScreenLogic.Screens.StartScreen;
import processing.core.*;

/**
 * The ScreenManager class is responsible for managing the screens in the
 * application.
 * It keeps track of the current screen, coin count, and various upgrade counts.
 */
public class ScreenManager {
  PApplet p;
  Screen currentScreen; // The current screen
  private int coinCount; // The current coin count
  private int massUpgradeCount; // The current mass upgrade count
  private int fuelUpgradeCount; // The current fuel upgrade count
  private int thrustUpgradeCount; // The current thrust upgrade count
  private int dragUpgradeCount; // The current drag upgrade count

  public ScreenManager(PApplet p) {
    this.p = p;
    currentScreen = new StartScreen(this.p, this);
    coinCount = 0;
    massUpgradeCount = 0;
  }

  /**
   * Displays the current screen.
   */
  public void show() {
    p.background(0);
    currentScreen.show();
    currentScreen.update();
  }

  /**
   * Changes the current screen to the specified screen.
   */
  public void changeScreen(Screen screen) {
    currentScreen = screen;
  }

  /**
   * Returns the current coin count.
   */
  public int getCoinCount() {
    return coinCount;
  }

  /**
   * Adds the specified amount of coins to the coin count.
   */
  public void addCoin(int amount) {
    coinCount += amount;
  }

  /**
   * Subtracts the specified amount of coins from the coin count.
   */
  public void subtractCoin(int amount) {
    coinCount -= amount;
  }

  /**
   * Returns the current fuel upgrade count.
   */
  public int fuelUpgradeCount() {
    return fuelUpgradeCount;
  }

  /**
   * Increases the fuel upgrade count by 1.
   */
  public void addFuelUpgradeCount() {
    fuelUpgradeCount++;
  }

  /**
   * Returns the current mass upgrade count.
   */
  public int massUpgradeCount() {
    return massUpgradeCount;
  }

  /**
   * Increases the mass upgrade count by 1.
   */
  public void addMassUpgradeCount() {
    massUpgradeCount++;
  }

  /**
   * Returns the current thrust upgrade count.
   */
  public int thrustUpgradeCount() {
    return thrustUpgradeCount;
  }

  /**
   * Increases the thrust upgrade count by 1.
   */
  public void addThrustUpgradeCount() {
    thrustUpgradeCount++;
  }

  /**
   * Returns the current drag upgrade count.
   */
  public int dragUpgradeCount() {
    return dragUpgradeCount;
  }

  /**
   * Increases the drag upgrade count by 1.
   */
  public void addDragUpgradeCount() {
    dragUpgradeCount++;
  }
}
