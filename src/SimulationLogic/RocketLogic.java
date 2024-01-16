package SimulationLogic;

import java.lang.Math;
import processing.core.*;
import ScreenLogic.ScreenManager;

/**
 * The RocketLogic class represents the logic and behavior of a rocket in a
 * simulation.
 */
public class RocketLogic {

  PApplet p;
  double β; // Total air resistance
  double v; // Velocity
  double A; // Area of the rcoket
  double c_w; // Drag coefficient
  double ρ; // Air density
  double m_1; // Mass of the rocket with fuel
  double m_2; // Mass of the rocket without fuel
  double a; // Accelerationof the rocket
  double u; // Thrust of the rocket
  double t; // Time
  double g; // Gravitational acceleration
  double m; // Mass of the rocket
  private double h; // Height the rocket have reached
  double dm; // Rate of change of mass
  double time; // Time of the simulation
  double T; // Temperature
  double pressure; // Air pressure
  int maxHeight; // Maximum height reached by the rocket
  ScreenManager sm; // The ScreenManager object for managing screens.

  RocketLogic(PApplet p, ScreenManager sm) {
    this.p = p;
    this.sm = sm;
    v = 0;
    A = 0.007088218;
    c_w = 0.04;
    m_1 = 0.885;
    m_2 = 0.215;
    m = m_1;
    a = 0;
    u = -34;
    t = 1 / 24.0;
    g = 9.82;
    h = 0;
    dm = (Math.log(m_1 / m_2)) - g * t;
  }

  /**
   * Updates the logic of the rocket.
   */
  public void logic() {
    airDensity();
    updateUpgrades();
    β = 1 / 2 * ρ * A * c_w; // The equation for air resistance
    m = m - (dm) * t; // The equation for mass

    if (m < m_2) {
      m = m_2;
      dm = 0;
      u = 0;
    }
    v = v + (((-u * dm) - (m * g) - (β * v * Math.abs(v))) / (m)) * t; // The equation for velocity
    h = h + v * t; // The equation for height
    time = time + t;
    if (h > maxHeight) {
      maxHeight = (int) h;
    }

  }

  /**
   * Calculates the air density based on the current height.
   */
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

  /**
   * Updates the rocket's upgrades based on the current upgrade counts.
   */
  void updateUpgrades() {
    A = 0.007088218 * (1 - sm.dragUpgradeCount() * 0.1);
    m_1 = 0.885 * (1 + sm.fuelUpgradeCount() * 0.1);
    m_2 = 0.215 * (1 - sm.massUpgradeCount() * 0.1);
    u = -34 * (1 + sm.thrustUpgradeCount() * 0.1);
  }

  /**
   * Displays text information about the rocket on the screen.
   */
  void textDisplay() {
    p.textSize(20);
    p.text("Time: " + time, 10, 30);
    p.text("Height: " + h, 10, 60);
    p.text("Velocity: " + v, 10, 90);
  }

  /**
   * Returns the current height of the rocket.
   */
  public double getH() {
    return h;
  }

  /**
   * Returns the current velocity of the rocket.
   */
  public double getV() {
    return v;
  }

  /**
   * Returns the current time of the simulation.
   */
  public double getT() {
    return time;
  }

  /**
   * Returns the maximum height reached by the rocket.
   */
  public int getMaxHeight() {
    return maxHeight;
  }
}