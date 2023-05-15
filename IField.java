import java.awt.Color;
import java.awt.Graphics;

public interface IField {
  static final int ROWS = 20 + 1;
  static final int COLUMNS = 10 + 2;
  static final int WIDTH = COLUMNS * IBlock.SIZE;
  static final int HEIGHT = ROWS * IBlock.SIZE;

  static final IBlock WALL = new ColorBlock(new Color(119, 119, 119));
  static final IBlock EMPTY = new ColorBlock(new Color(0, 0, 0));

  void draw(Graphics g, int x, int y);

  boolean isSettable(IBlock[][] blocks, int x, int y);

  void set(IBlock[][] blocks, int x, int y);

  int clearLine();
}
