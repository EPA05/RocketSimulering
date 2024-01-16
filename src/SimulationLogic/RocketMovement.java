package SimulationLogic;

import processing.core.*;

/**
 * The RocketMovement class handles the movement of a rocket in a simulation.
 */
public class RocketMovement {
  PApplet p;
  int x; // The x-coordinate of the rocket

  RocketMovement(PApplet p) {
    this.p = p;
    x = (p.width / 2) - 37;
  }

  /**
   * Handles the movement of the rocket based on user input.
   */
  public void movement() {
    if (p.keyPressed) {
      if (p.key == 'a' || p.key == 'A' || p.keyCode == PConstants.LEFT) {
        x -= 5;
      } else if (p.key == 'd' || p.key == 'D' || p.keyCode == PConstants.RIGHT) {
        x += 5;
      }
    }

    // Check if the rocket is out of the canvas
    if (x < 0) {
      x = 0;
    } else if (x > p.width - 75) {
      x = p.width - 75;
    }
  }

  /**
   * Gets the x-coordinate of the rocket.
   */
  public int getX() {
    return x;
  }
}
