import java.awt.Graphics;

public class Tetrimino implements ITetrimino {

  public static Tetrimino newITetrimino() {
    Tetrimino i = new Tetrimino();
    IBlock block = ColorBlock.LIGHT_BLUE;
    i.blocks[0][1] = block;
    i.blocks[1][1] = block;
    i.blocks[2][1] = block;
    i.blocks[3][1] = block;
    return i;
  }

  private IBlock[][] blocks;

  private Tetrimino() {
    this.blocks = new IBlock[LENGTH][LENGTH];

    for (int i = 0; i < LENGTH; i++) {
      for (int j = 0; j < LENGTH; j++) {
        this.blocks[i][j] = IField.EMPTY;
      }
    }
  }

  @Override
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

  @Override
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

  @Override
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

  @Override
  public boolean isSettable(IField field, int x, int y) {
    return field.isSettable(this.blocks, x, y);
  }
}
