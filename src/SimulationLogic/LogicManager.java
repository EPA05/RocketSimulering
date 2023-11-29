package SimulationLogic;

import processing.core.PApplet;

public class LogicManager {
  PApplet p;
  RocketLogic rl;

  public LogicManager(PApplet p) {
    this.p = p;
    rl = new RocketLogic(p);
  }

  public void logic() {
    rl.logic();
    rl.textDisplay();
  }

}
