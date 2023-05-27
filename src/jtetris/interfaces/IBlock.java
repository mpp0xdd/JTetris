package jtetris.interfaces;
import java.awt.Graphics;

public interface IBlock {
  int SIZE = 30;

  void draw(Graphics g, int x, int y);
}
