package ScreenLogic.Screens;

import ScreenLogic.Rocket;
import ScreenLogic.Screen;
import ScreenLogic.ScreenManager;
import processing.core.*;

/**
 * The StartScreen class represents the screen where the game starts and players
 * can buy upgrades.
 * It extends the Screen class and contains methods for displaying the screen
 * and handling user interactions.
 */
public class StartScreen extends Screen {

  PApplet p;
  ScreenManager sm;
  Screen screen;
  Rocket r;
  int coins;
  int fuelCost;
  int massCost;
  int thrustCost;
  int dragCost;

  public StartScreen(PApplet p, ScreenManager sm) {
    this.p = p;
    this.sm = sm;
    r = new Rocket(this.p, sm, this);
    fuelCost = sm.fuelUpgradeCount() + 1;
    massCost = sm.massUpgradeCount() + 1;
    thrustCost = sm.thrustUpgradeCount() + 1;
    dragCost = sm.dragUpgradeCount() + 1;
  }

  /**
   * Displays the StartScreen.
   * This method is called by the ScreenManager to show the screen.
   */
  public void show() {
    p.background(0);
    p.textSize(32);
    p.fill(255);
    p.text("You can buy upgrades here", 20, 50);
    p.text("Press Enter to start", 20, 100);
    p.noFill();

    if (p.keyPressed && p.key == PConstants.ENTER) {
      sm.changeScreen(r);
    }
    shop();
  }

  /**
   * Displays the shop section of the StartScreen.
   * This method is responsible for rendering the shop interface and handling user
   * interactions.
   */
  void shop() {

    // Fuel shop
    p.fill(0);
    p.stroke(255);
    p.rect(430, 70, 150, 80);
    p.noStroke();
    p.noFill();
    p.textSize(20);
    p.fill(255);
    p.text("Avaliable coins: " + sm.getCoinCount(), 430, 50);
    p.text("Buy more fuel", 440, 100);
    p.text("Costs: " + fuelCost + " coins", 440, 125);
    p.noFill();

    // Buy more fuel
    if (p.frameCount % 3 == 0) {
      if (p.mousePressed && p.mouseX > 430 && p.mouseX < 580 && p.mouseY > 70 && p.mouseY < 150) {
        if (sm.getCoinCount() >= fuelCost) {
          sm.addFuelUpgradeCount();
          sm.subtractCoin(fuelCost);
          fuelCost++;
        }
      }
    }
    // Mass shop
    p.fill(0);
    p.stroke(255);
    p.rect(430, 170, 150, 80);
    p.noStroke();
    p.noFill();
    p.fill(255);
    p.text("Buy less mass", 440, 200);
    p.text("Costs: " + massCost + " coins", 440, 225);
    p.noFill();

    // Buy more mass
    if (p.frameCount % 3 == 0) {
      if (p.mousePressed && p.mouseX > 430 && p.mouseX < 580 && p.mouseY > 170 && p.mouseY < 250) {
        if (sm.getCoinCount() >= massCost) {
          sm.addMassUpgradeCount();
          sm.subtractCoin(massCost);
          massCost++;
        }
      }
    }

    // Thrust shop
    p.fill(0);
    p.stroke(255);
    p.rect(430, 270, 150, 80);
    p.noStroke();
    p.noFill();
    p.fill(255);
    p.text("Buy more thrust", 440, 300);
    p.text("Costs: " + thrustCost + " coins", 440, 325);
    p.noFill();

    // Buy more thrust
    if (p.frameCount % 3 == 0) {
      if (p.mousePressed && p.mouseX > 430 && p.mouseX < 580 && p.mouseY > 270 && p.mouseY < 350) {
        if (sm.getCoinCount() >= thrustCost) {
          sm.addThrustUpgradeCount();
          sm.subtractCoin(thrustCost);
          thrustCost++;
        }
      }
    }

    // Drag shop
    p.fill(0);
    p.stroke(255);
    p.rect(430, 370, 150, 80);
    p.noStroke();
    p.noFill();
    p.fill(255);
    p.text("Buy more drag", 440, 400);
    p.text("Costs: " + dragCost + " coins", 440, 425);
    p.noFill();

    // Buy more drag
    if (p.frameCount % 3 == 0) {
      if (p.mousePressed && p.mouseX > 430 && p.mouseX < 580 && p.mouseY > 370 && p.mouseY < 450) {
        if (sm.getCoinCount() >= dragCost) {
          sm.addDragUpgradeCount();
          sm.subtractCoin(dragCost);
          dragCost++;
        }
      }
    }
  }
}
