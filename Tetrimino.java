import java.awt.Graphics;

public abstract class Tetrimino {
  private static final int LENGTH = 4;
  protected final IBlock[][] blocks;

  public Tetrimino() {
    this.blocks = new IBlock[LENGTH][LENGTH];

    for (int i = 0; i < LENGTH; i++) {
      for (int j = 0; j < LENGTH; j++) {
        this.blocks[i][j] = IField.EMPTY;
      }
    }
  }

  public void draw(Graphics g, int x, int y) {
    for (int i = 0; i < LENGTH; i++) {
      for (int j = 0; j < LENGTH; j++) {
        IBlock block = this.blocks[i][j];
        if (!block.equals(IField.EMPTY)) {
          block.draw(g, (x + j) * IBlock.SIZE, (y + i) * IBlock.SIZE);
        }
      }
    }
  }
}
