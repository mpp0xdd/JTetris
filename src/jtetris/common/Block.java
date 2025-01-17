package jtetris.common;

import java.awt.Graphics;

public interface Block {
  void draw(Graphics g, int x, int y);

  default int size() {
    return 30;
  }
}
