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
}
