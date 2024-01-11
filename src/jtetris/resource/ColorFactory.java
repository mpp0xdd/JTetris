package jtetris.resource;

import java.awt.Color;

public final class ColorFactory {

  private ColorFactory() {
    // restrict instantiation
  }

  private static final Color GRAY = new Color(119, 119, 119);
  private static final Color BLACK = new Color(0, 0, 0);
  private static final Color LIGHT_BLUE = new Color(0, 204, 204);
  private static final Color YELLOW = new Color(204, 204, 0);
  private static final Color GREEN = new Color(0, 204, 0);
  private static final Color RED = new Color(204, 0, 0);
  private static final Color BLUE = new Color(0, 0, 204);
  private static final Color ORANGE = new Color(204, 102, 0);
  private static final Color PURPLE = new Color(153, 0, 204);

  public static Color gray() {
    return GRAY;
  }

  public static Color black() {
    return BLACK;
  }

  public static Color lightBlue() {
    return LIGHT_BLUE;
  }

  public static Color yellow() {
    return YELLOW;
  }

  public static Color green() {
    return GREEN;
  }

  public static Color red() {
    return RED;
  }

  public static Color blue() {
    return BLUE;
  }

  public static Color orange() {
    return ORANGE;
  }

  public static Color purple() {
    return PURPLE;
  }
}
