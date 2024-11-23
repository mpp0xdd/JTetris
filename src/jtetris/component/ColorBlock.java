package jtetris.component;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Objects;
import jtetris.common.Block;
import jtetris.resource.ColorFactory;

public class ColorBlock implements Block {
  public static final Block GRAY = new ColorBlock(ColorFactory.gray());
  public static final Block BLACK = new ColorBlock(ColorFactory.black());
  public static final Block LIGHT_BLUE = new ColorBlock(ColorFactory.lightBlue());
  public static final Block YELLOW = new ColorBlock(ColorFactory.yellow());
  public static final Block GREEN = new ColorBlock(ColorFactory.green());
  public static final Block RED = new ColorBlock(ColorFactory.red());
  public static final Block BLUE = new ColorBlock(ColorFactory.blue());
  public static final Block ORANGE = new ColorBlock(ColorFactory.orange());
  public static final Block PURPLE = new ColorBlock(ColorFactory.purple());

  private final Color color;

  public ColorBlock(Color color) {
    this.color = Objects.requireNonNull(color);
  }

  @Override
  public void draw(Graphics g, int x, int y) {
    g.setColor(this.color);
    g.fill3DRect(x, y, size(), size(), false);
  }

  @Override
  public int hashCode() {
    return Objects.hash(color);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    ColorBlock other = (ColorBlock) obj;
    return Objects.equals(color, other.color);
  }
}
