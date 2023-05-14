import java.awt.Graphics;

public abstract class Tetrimino {
  protected final IBlock[][] blocks;

  public Tetrimino() {
    this.blocks = new IBlock[4][2];

    for (int i = 0; i < this.blocks.length; i++) {
      for (int j = 0; j < this.blocks[i].length; j++) {
        this.blocks[i][j] = IField.EMPTY;
      }
    }
  }

  public void draw(Graphics g, int x, int y) {
    for (int i = 0; i < this.blocks.length; i++) {
      for (int j = 0; j < this.blocks[i].length; j++) {
        IBlock block = this.blocks[i][j];
        if (!block.equals(IField.EMPTY)) {
          block.draw(g, (x + j) * IBlock.SIZE, (y + i) * IBlock.SIZE);
        }
      }
    }
  }
}
