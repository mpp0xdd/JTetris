package jtetris.common;

import java.awt.Graphics;

public interface ITetrimino {

  default int length() {
    return 4;
  }

  void draw(Graphics g);

  void moveLeft();

  void moveRight();

  void moveUp();

  boolean moveDown();

  void rotateLeft();

  void rotateRight();

  boolean isFixed();

  void fix();
}
