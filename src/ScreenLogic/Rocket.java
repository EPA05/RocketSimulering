package ScreenLogic;

import java.util.ArrayList;

import ScreenLogic.Screens.GameOverScreen;
import SimulationLogic.LogicManager;
import processing.core.*;
import ScreenLogic.Screens.StartScreen;

/**
 * The Rocket class represents a rocket in the simulation.
 * It extends the Screen class and contains methods for updating and displaying
 * the rocket.
 */
public class Rocket extends Screen {

  PApplet p; // The PApplet object for rendering.
  PImage photo; // The image of the rocket
  LogicManager lm; // The LogicManager object for performing logic calculations.
  StartScreen ss; // The StartScreen object for starting the game.
  double h, t, v; // The height, time, and velocity of the rocket.
  int maxHeight; // The max height the rocket reached before dying.
  Background bg; // The Background object for displaying the background.
  int x; // The x-coordinate of the rocket.
  int y; // The y-coordinate of the rocket.
  ArrayList<Bomb> bombs; // The ArrayList of bombs.
  ArrayList<Coin> coins; // The ArrayList of coins.
  ScreenManager sm; // The ScreenManager object for managing screens.
  int coinCounter; // The number of collected coins.

  public Rocket(PApplet p, ScreenManager sm, StartScreen ss) {
    this.p = p;
    this.ss = ss;
    photo = this.p.loadImage("Rocket.png");
    lm = new LogicManager(this.p, sm);
    bg = new Background(this.p);
    bombs = new ArrayList<Bomb>();
    coins = new ArrayList<Coin>();
    this.sm = sm;
    x = 300;
    y = 300;
  }

  /**
   * Updates the rocket's properties and performs logic calculations.
   */
  void update() {
    h = lm.getRocketLogic().getH();
    t = lm.getRocketLogic().getT();
    v = lm.getRocketLogic().getV();
    x = lm.getRocketMovement().getX();
    maxHeight = lm.getRocketLogic().getMaxHeight();
    lm.logic();
  }

  /**
   * Displays the rocket and other game elements on the screen.
   */
  public void show() {
    bg.showBackground(h);
    bg.cloudLogic();
    bg.displayCloud();
    bomb();
    gameOver();
    coin();
    coinCounter();

    p.image(photo, x, y);

    // Randomizes the rocket image to create a little animation.
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

  /**
   * Creates and displays bombs on the screen.
   * Removes bombs that have fallen off the screen.
   * Ends the game if a bomb hits the rocket.
   */
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
        sm.changeScreen(new GameOverScreen(p, sm, maxHeight));
      }
    }
  }

  /**
   * Ends the game if the rocket's velocity becomes negative.
   */
  void gameOver() {
    if (v < 0) {
      sm.changeScreen(new GameOverScreen(p, sm, maxHeight));
    }
  }

  /**
   * Creates and displays coins on the screen.
   * Removes coins that have fallen off the screen or hit the rocket.
   * Increases the coin count if a coin is collected.
   */
  public void coin() {
    if (coins.size() < 7 && p.frameCount % 30 == 0) {
      coins.add(new Coin(p));
    }

    for (Coin coin : coins) {
      coin.show();
      if (coin.getY() > (p.height) || coin.hitRocket(this)) {
        coins.remove(coin);
      }
      if (coin.hitRocket(this)) {
        if (h < 1000)
          sm.addCoin(1);
      } else if (h > 1000) {
        sm.addCoin(2);
      }
    }
  }

  /**
   * Displays the current coin count on the screen.
   */
  void coinCounter() {
    p.textSize(32);
    p.fill(255);
    p.text("Coins: " + sm.getCoinCount(), p.width - 150, 30);
  }
}
