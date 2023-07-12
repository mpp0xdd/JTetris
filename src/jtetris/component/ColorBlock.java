package jtetris.component;

import static jtetris.common.Constants.BLOCK_SIZE;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Objects;
import jtetris.common.IBlock;
import jtetris.factory.ColorFactory;

public class ColorBlock implements IBlock {
  public static final IBlock GRAY = new ColorBlock(ColorFactory.gray());
  public static final IBlock BLACK = new ColorBlock(ColorFactory.black());
  public static final IBlock LIGHT_BLUE = new ColorBlock(ColorFactory.lightBlue());
  public static final IBlock YELLOW = new ColorBlock(ColorFactory.yellow());
  public static final IBlock GREEN = new ColorBlock(ColorFactory.green());
  public static final IBlock RED = new ColorBlock(ColorFactory.red());
  public static final IBlock BLUE = new ColorBlock(ColorFactory.blue());
  public static final IBlock ORANGE = new ColorBlock(ColorFactory.orange());
  public static final IBlock PURPLE = new ColorBlock(ColorFactory.purple());

  private final Color color;

  public ColorBlock(Color color) {
    this.color = Objects.requireNonNull(color);
  }

  @Override
  public void draw(Graphics g, int x, int y) {
    g.setColor(this.color);
    g.fill3DRect(x, y, BLOCK_SIZE, BLOCK_SIZE, false);
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
