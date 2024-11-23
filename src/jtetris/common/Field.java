package jtetris.common;

import java.awt.Graphics;
import java.awt.Point;

public interface Field {

  int rows();

  int columns();

  int width();

  int height();

  Block wall();

  Block empty();

  Point getLocation();

  void draw(Graphics g);

  boolean isSettable(Block[][] blocks, int x, int y);

  void set(Block[][] blocks, int x, int y);

  int clearLine();
}
