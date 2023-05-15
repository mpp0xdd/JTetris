import java.awt.Graphics;

public class Field implements IField {
  private final IBlock[][] field;

  public Field() {
    this.field = new IBlock[ROWS][COLUMNS];
    for (int i = 0; i < ROWS; i++) {
      for (int j = 0; j < COLUMNS; j++) {
        if (i == ROWS - 1 || j == 0 || j == COLUMNS - 1) {
          this.field[i][j] = WALL;
        } else {
          this.field[i][j] = EMPTY;
        }
      }
    }
  }

  @Override
  public void draw(Graphics g, int x, int y) {
    for (int i = 0; i < ROWS; i++) {
      for (int j = 0; j < COLUMNS; j++) {
        IBlock block = this.field[i][j];
        block.draw(g, x + j * IBlock.SIZE, y + i * IBlock.SIZE);
      }
    }
  }

  @Override
  public boolean isSettable(IBlock[][] blocks, int x, int y) {
    for (int i = 0; i < blocks.length; i++) {
      for (int j = 0; j < blocks[i].length; j++) {
        if (blocks[i][j].equals(IField.EMPTY)) {
          continue;
        }
        try {
          if (!this.field[i + y][j + x].equals(IField.EMPTY)) {
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
        if (blocks[i][j].equals(IField.EMPTY)) {
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
}
