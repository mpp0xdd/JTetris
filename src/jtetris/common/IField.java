package jtetris.common;

import static jtetris.common.Constants.BLOCK_SIZE;
import java.awt.Graphics;
import java.awt.Point;

public interface IField {

  int rows();

  int columns();

  default int width() {
    return columns() * BLOCK_SIZE;
  }

  default int height() {
    return rows() * BLOCK_SIZE;
  }

  IBlock wall();

  IBlock empty();

  Point getLocation();

  void draw(Graphics g);

  boolean isSettable(IBlock[][] blocks, int x, int y);

  void set(IBlock[][] blocks, int x, int y);

  int clearLine();
}
