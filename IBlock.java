import java.awt.Graphics;

public interface IBlock {
  static final int SIZE = 30;

  void draw(Graphics g, int x, int y);
}
