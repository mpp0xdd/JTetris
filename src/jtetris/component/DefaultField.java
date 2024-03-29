package jtetris.component;

import static jtetris.common.Constants.BLOCK_SIZE;
import java.awt.Graphics;
import java.awt.Point;
import jtetris.common.Block;
import jtetris.common.Field;

class DefaultField implements Field {
  private final Point point;
  private final Block[][] field;

  public DefaultField(int x, int y) {
    this.point = new Point(x, y);
    this.field = new Block[rows()][columns()];
    for (int i = 0; i < rows(); i++) {
      for (int j = 0; j < columns(); j++) {
        if (i == rows() - 1 || j == 0 || j == columns() - 1) {
          this.field[i][j] = wall();
        } else {
          this.field[i][j] = empty();
        }
      }
    }
  }

  public DefaultField() {
    this(0, 0);
  }

  @Override
  public int rows() {
    return 20 + 1;
  }

  @Override
  public int columns() {
    return 10 + 2;
  }

  @Override
  public Block wall() {
    return ColorBlock.GRAY;
  }

  @Override
  public Block empty() {
    return ColorBlock.BLACK;
  }

  @Override
  public Point getLocation() {
    return point.getLocation();
  }

  @Override
  public void draw(Graphics g) {
    for (int i = 0; i < rows(); i++) {
      for (int j = 0; j < columns(); j++) {
        Block block = this.field[i][j];
        block.draw(g, point.x + j * BLOCK_SIZE, point.y + i * BLOCK_SIZE);
      }
    }
  }

  @Override
  public boolean isSettable(Block[][] blocks, int x, int y) {
    for (int i = 0; i < blocks.length; i++) {
      for (int j = 0; j < blocks[i].length; j++) {
        if (blocks[i][j].equals(empty())) {
          continue;
        }
        try {
          if (!this.field[i + y][j + x].equals(empty())) {
            return false;
          }
        } catch (ArrayIndexOutOfBoundsException e) {
          // nop
        }
      }
    }
    return true;
  }

  @Override
  public void set(Block[][] blocks, int x, int y) {
    if (!isSettable(blocks, x, y)) return;

    for (int i = 0; i < blocks.length; i++) {
      for (int j = 0; j < blocks[i].length; j++) {
        if (blocks[i][j].equals(empty())) {
          continue;
        }
        try {
          this.field[i + y][j + x] = blocks[i][j];
        } catch (ArrayIndexOutOfBoundsException e) {
          // nop
        }
      }
    }
  }

  @Override
  public int clearLine() {
    int numOfLinesCleared = 0;
    rowLoop:
    for (int i = 0; i < rows() - 1; i++) {
      for (int j = 1; j < columns() - 1; j++) {
        if (field[i][j].equals(empty())) {
          continue rowLoop;
        }
      }
      for (int i2 = i; i2 > 0; i2--) {
        for (int j = 1; j < columns() - 1; j++) {
          field[i2][j] = field[i2 - 1][j];
        }
      }
      numOfLinesCleared++;
    }
    return numOfLinesCleared;
  }
}
