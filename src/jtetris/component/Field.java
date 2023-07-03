package jtetris.component;

import static jtetris.common.Constants.BLOCK_SIZE;
import static jtetris.common.Constants.FIELD_COLUMNS;
import static jtetris.common.Constants.FIELD_ROWS;
import java.awt.Graphics;
import jtetris.common.IBlock;
import jtetris.common.IField;

public class Field implements IField {
  private final IBlock[][] field;

  public Field() {
    this.field = new IBlock[FIELD_ROWS][FIELD_COLUMNS];
    for (int i = 0; i < FIELD_ROWS; i++) {
      for (int j = 0; j < FIELD_COLUMNS; j++) {
        if (i == FIELD_ROWS - 1 || j == 0 || j == FIELD_COLUMNS - 1) {
          this.field[i][j] = wall();
        } else {
          this.field[i][j] = empty();
        }
      }
    }
  }

  @Override
  public IBlock wall() {
    return ColorBlock.GRAY;
  }

  @Override
  public IBlock empty() {
    return ColorBlock.BLACK;
  }

  @Override
  public void draw(Graphics g, int x, int y) {
    for (int i = 0; i < FIELD_ROWS; i++) {
      for (int j = 0; j < FIELD_COLUMNS; j++) {
        IBlock block = this.field[i][j];
        block.draw(g, x + j * BLOCK_SIZE, y + i * BLOCK_SIZE);
      }
    }
  }

  @Override
  public boolean isSettable(IBlock[][] blocks, int x, int y) {
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
  public void set(IBlock[][] blocks, int x, int y) {
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
    for (int i = 0; i < FIELD_ROWS - 1; i++) {
      for (int j = 1; j < FIELD_COLUMNS - 1; j++) {
        if (field[i][j].equals(empty())) {
          continue rowLoop;
        }
      }
      for (int i2 = i; i2 > 0; i2--) {
        for (int j = 1; j < FIELD_COLUMNS - 1; j++) {
          field[i2][j] = field[i2 - 1][j];
        }
      }
      numOfLinesCleared++;
    }
    return numOfLinesCleared;
  }
}
