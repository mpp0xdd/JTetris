import java.awt.Color;
import java.awt.Graphics;
import java.util.Objects;

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
    g.fill3DRect(x, y, SIZE, SIZE, false);
  }
}
