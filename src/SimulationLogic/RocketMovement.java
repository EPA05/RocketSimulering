package SimulationLogic;

import processing.core.*;

public class RocketMovement {
  PApplet p;
  int x;

  RocketMovement(PApplet p) {
    this.p = p;
    x = (p.width / 2) - 37;
  }

  public void movement() {
    if (p.keyPressed) {
      if (p.key == 'a' || p.key == 'A') {
        x -= 5;
      } else if (p.key == 'd' || p.key == 'D') {
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

  public int getX() {
    return x;
  }
}
