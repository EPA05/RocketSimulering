package ScreenLogic.Screens;

import processing.core.*;
import ScreenLogic.Screen;
import ScreenLogic.ScreenManager;

public class GameOverScreen extends Screen {
  // Class variables
  PApplet p;
  int maxHeight; // The max height the player reached before dying
  ScreenManager sm;
  Screen screen;

  public GameOverScreen(PApplet p, ScreenManager sm, int mh) {
    this.p = p;
    this.sm = sm;
    maxHeight = mh;
  }

  /**
   * Displays the game over screen.
   * This method is responsible for rendering the background, text, and handling
   * the restart option.
   */
  public void show() {
    p.background(0);
    p.textSize(32);
    p.fill(255);
    p.text("GameOver", 100, 100);
    p.text("Your max height was: " + maxHeight + "meters", 100, 150);
    p.text("Press Enter to restart", 100, 200);

    if (p.keyPressed == true && p.key == PConstants.ENTER) {
      sm.changeScreen(new StartScreen(this.p, sm)); // Change the screen to the start screen
    }
  }
}
