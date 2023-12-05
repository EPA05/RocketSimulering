package SimulationLogic;

import processing.core.PApplet;

public class LogicManager {

  PApplet p;
  RocketLogic rl;
  RocketMovement rm;

  public LogicManager(PApplet p) {
    this.p = p;
    rl = new RocketLogic(p);
    rm = new RocketMovement(p);
  }

  public void logic() {
    rl.logic();
    rm.movement();
  }

  public void show() {
    rl.textDisplay();
  }

  public RocketLogic getRocketLogic() {
    return rl;
  }

  public RocketMovement getRocketMovement() {
    return rm;
  }
}
