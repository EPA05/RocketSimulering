package SimulationLogic;

import processing.core.PApplet;
import ScreenLogic.ScreenManager;

public class LogicManager {

  PApplet p;
  RocketLogic rl;
  RocketMovement rm;
  ScreenManager sm;

  public LogicManager(PApplet p, ScreenManager sm) {
    this.p = p;
    this.sm = sm;
    rl = new RocketLogic(p, sm);
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
