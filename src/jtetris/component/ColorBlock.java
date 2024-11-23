package jtetris.component;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Objects;
import jtetris.common.Block;
import jtetris.resource.ColorFactory;

public enum ColorBlock implements Block {
  GRAY(ColorFactory.gray()),
  BLACK(ColorFactory.black()),
  LIGHT_BLUE(ColorFactory.lightBlue()),
  YELLOW(ColorFactory.yellow()),
  GREEN(ColorFactory.green()),
  RED(ColorFactory.red()),
  BLUE(ColorFactory.blue()),
  ORANGE(ColorFactory.orange()),
  PURPLE(ColorFactory.purple());

  private final Color color;

  private ColorBlock(Color color) {
    this.color = Objects.requireNonNull(color);
  }

  @Override
  public void draw(Graphics g, int x, int y) {
    g.setColor(this.color);
    g.fill3DRect(x, y, size(), size(), false);
  }
}
