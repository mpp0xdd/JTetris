package jtetris.component;

import static jtetris.common.Constants.BLOCK_SIZE;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Objects;
import jtetris.common.IBlock;

public class ColorBlock implements IBlock {
  public static final IBlock GRAY = new ColorBlock(new Color(119, 119, 119));
  public static final IBlock BLACK = new ColorBlock(new Color(0, 0, 0));
  public static final IBlock LIGHT_BLUE = new ColorBlock(new Color(0, 204, 204));
  public static final IBlock YELLOW = new ColorBlock(new Color(204, 204, 0));
  public static final IBlock GREEN = new ColorBlock(new Color(0, 204, 0));
  public static final IBlock RED = new ColorBlock(new Color(204, 0, 0));
  public static final IBlock BLUE = new ColorBlock(new Color(0, 0, 204));
  public static final IBlock ORANGE = new ColorBlock(new Color(204, 102, 0));
  public static final IBlock PURPLE = new ColorBlock(new Color(153, 0, 204));

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
