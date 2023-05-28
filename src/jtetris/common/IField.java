package jtetris.common;

import java.awt.Graphics;
import jtetris.component.ColorBlock;

public interface IField {
  int ROWS = 20 + 1;
  int COLUMNS = 10 + 2;
  int WIDTH = COLUMNS * IBlock.SIZE;
  int HEIGHT = ROWS * IBlock.SIZE;

  IBlock WALL = ColorBlock.GRAY;
  IBlock EMPTY = ColorBlock.BLACK;

  void draw(Graphics g, int x, int y);

  boolean isSettable(IBlock[][] blocks, int x, int y);

  void set(IBlock[][] blocks, int x, int y);

  int clearLine();
}
