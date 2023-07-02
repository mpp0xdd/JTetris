package jtetris.common;

import java.awt.Graphics;

public interface IField {
  int ROWS = 20 + 1;
  int COLUMNS = 10 + 2;
  int WIDTH = COLUMNS * IBlock.SIZE;
  int HEIGHT = ROWS * IBlock.SIZE;

  IBlock wall();

  IBlock empty();

  void draw(Graphics g, int x, int y);

  boolean isSettable(IBlock[][] blocks, int x, int y);

  void set(IBlock[][] blocks, int x, int y);

  int clearLine();
}
