package jtetris.common;

import java.awt.Graphics;

public interface ITetrimino {

  void draw(Graphics g, int x, int y);

  void rotateLeft(int x, int y);

  void rotateRight(int x, int y);

  boolean isSettable(int x, int y);

  void set(int x, int y);
}
