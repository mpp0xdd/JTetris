import java.awt.Graphics;

public abstract class Tetrimino {
  private static final int LENGTH = 4;
  protected IBlock[][] blocks;

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

  public void rotateLeft(IField field, int x, int y) {
    IBlock[][] newBlocks = new IBlock[LENGTH][LENGTH];

    for (int i = 0; i < LENGTH; i++) {
      for (int j = 0; j < LENGTH; j++) {
        newBlocks[LENGTH - 1 - j][i] = this.blocks[i][j];
      }
    }
    if (field.isSettable(newBlocks, x, y)) {
      this.blocks = newBlocks;
    }
  }

  public void rotateRight(IField field, int x, int y) {
    IBlock[][] newBlocks = new IBlock[LENGTH][LENGTH];

    for (int i = 0; i < LENGTH; i++) {
      for (int j = 0; j < LENGTH; j++) {
        newBlocks[j][LENGTH - 1 - i] = this.blocks[i][j];
      }
    }
    if (field.isSettable(newBlocks, x, y)) {
      this.blocks = newBlocks;
    }
  }
}
