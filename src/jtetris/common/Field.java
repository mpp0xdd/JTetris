package jtetris.common;

import static jtetris.common.Constants.BLOCK_SIZE;
import java.awt.Graphics;
import java.awt.Point;

public interface Field {

  int rows();

  int columns();

  default int width() {
    return columns() * BLOCK_SIZE;
  }

  default int height() {
    return rows() * BLOCK_SIZE;
  }

  Block wall();

  Block empty();

  Point getLocation();

  void draw(Graphics g);

  boolean isSettable(Block[][] blocks, int x, int y);

  void set(Block[][] blocks, int x, int y);

  int clearLine();
}
