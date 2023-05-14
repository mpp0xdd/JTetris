import java.awt.Color;
import java.awt.Graphics;
import java.util.Objects;

public class ColorBlock implements IBlock {
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
