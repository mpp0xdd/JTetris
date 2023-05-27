package jtetris.interfaces;
import java.awt.Graphics;

public interface ITetrimino {
  int LENGTH = 4;

  void draw(Graphics g, int x, int y);

  void rotateLeft(IField field, int x, int y);

  void rotateRight(IField field, int x, int y);

  boolean isSettable(IField field, int x, int y);

  void set(IField field, int x, int y);
}
