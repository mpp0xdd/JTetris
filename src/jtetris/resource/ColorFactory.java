package jtetris.resource;

import java.awt.Color;

public final class ColorFactory {

  private ColorFactory() {
    // restrict instantiation
  }

  public static Color gray() {
    return new Color(119, 119, 119);
  }

  public static Color black() {
    return new Color(0, 0, 0);
  }

  public static Color lightBlue() {
    return new Color(0, 204, 204);
  }

  public static Color yellow() {
    return new Color(204, 204, 0);
  }

  public static Color green() {
    return new Color(0, 204, 0);
  }

  public static Color red() {
    return new Color(204, 0, 0);
  }

  public static Color blue() {
    return new Color(0, 0, 204);
  }

  public static Color orange() {
    return new Color(204, 102, 0);
  }

  public static Color purple() {
    return new Color(153, 0, 204);
  }
}
