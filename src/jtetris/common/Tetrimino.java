package jtetris.common;

import java.awt.Graphics;

public interface Tetrimino {

  default int length() {
    return 4;
  }

  void draw(Graphics g);

  void drawGhost(Graphics g);

  void moveLeft();

  void moveRight();

  boolean moveDown();

  void rotateLeft();

  void rotateRight();

  boolean isFixed();

  void fix();
}
