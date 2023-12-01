package SimulationLogic;

import java.lang.Math;
import processing.core.*;

public class RocketLogic {

  PApplet p;
  double β;
  double v;
  double A;
  double c_w;
  double ρ;
  double m_1;
  double m_2;
  double a;
  double u;
  double t;
  double g;
  double m;
  private double h;
  double dm;
  double time;

  RocketLogic(PApplet p) {
    this.p = p;
    ρ = 1.2041;
    v = 0;
    A = 0.007088218;
    c_w = 0.04;
    m_1 = 0.885;
    m_2 = 0.215;
    m = 0.885;
    a = 0;
    u = -34;
    t = 1 / 24.0;
    g = 9.82;
    h = 0;
    dm = (Math.log(m_1 / m_2)) - g * t;
  }

  public void logic() {
    β = 1 / 2 * ρ * A * c_w;
    m = m - (dm) * t;

    if (m < 0.215) {
      m = 0.215;
      dm = 0;
      u = 0;
    }
    v = v + (((-u * dm) - (m * g) - (β * v * Math.abs(v))) / (m)) * t;
    h = h + v * t;
    time = time + t;
  }

  void textDisplay() {
    p.textSize(20);
    p.text("Time: " + time, 10, 30);
    p.text("Height: " + h, 10, 60);
    p.text("Velocity: " + v, 10, 90);
  }

  public double getH() {
    return h;
  }

  public double getV() {
    return v;
  }

  public double getT() {
    return time; 
  }
}
