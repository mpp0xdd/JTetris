package jtetris.common;

import java.awt.Graphics;

public interface IField {

  IBlock wall();

  IBlock empty();

  void draw(Graphics g, int x, int y);

  boolean isSettable(IBlock[][] blocks, int x, int y);

  void set(IBlock[][] blocks, int x, int y);

  int clearLine();
}
