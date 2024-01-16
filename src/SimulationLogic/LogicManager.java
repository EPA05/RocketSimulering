package SimulationLogic;

import processing.core.PApplet;
import ScreenLogic.ScreenManager;

/**
 * The LogicManager class is responsible for managing the logic and movement of
 * the rocket simulation.
 */
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

  /**
   * Executes the logic for the rocket simulation.
   */
  public void logic() {
    rl.logic();
    rm.movement();
  }

  /**
   * Displays the text for the rocket simulation.
   */
  public void show() {
    rl.textDisplay();
  }

  /**
   * Returns the RocketLogic object used for managing rocket logic.
   */
  public RocketLogic getRocketLogic() {
    return rl;
  }

  /**
   * Returns the RocketMovement object used for managing rocket movement.
   */
  public RocketMovement getRocketMovement() {
    return rm;
  }
}
