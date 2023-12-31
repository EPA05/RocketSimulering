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
  double T;
  double pressure;

  RocketLogic(PApplet p) {
    this.p = p;
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
    airDensity();
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

  void airDensity() {

    if (h < 11000) {
      T = 15.04 - 0.0649 * h;
      pressure = 101.29 * Math.pow((T + 273.1) / 288.08, 5.256);
      ρ = pressure / (0.2869 * (T + 273.1));
    }

    else if (11000 < h || h < 25000) {
      T = -56.46;
      pressure = 22.65 * Math.exp(1.73 - 0.000157 * h);
      ρ = pressure / (0.2869 * (T + 273.1));
    }

    else {
      T = -131.21 + 0.00299 * h;
      pressure = 2.488 * Math.pow((T + 273.1) / 216.6, -11.388);
      ρ = pressure / (0.2869 * (T + 273.1));

    }
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
