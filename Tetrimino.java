import java.awt.Graphics;
import java.util.Objects;

public class Tetrimino implements ITetrimino {

  public static Tetrimino newITetrimino(IBlock block) {
    Objects.requireNonNull(block);
    Tetrimino i = new Tetrimino();
    i.blocks[0][1] = block;
    i.blocks[1][1] = block;
    i.blocks[2][1] = block;
    i.blocks[3][1] = block;
    return i;
  }

  public static Tetrimino newITetrimino() {
    return newITetrimino(ColorBlock.LIGHT_BLUE);
  }

  public static Tetrimino newOTetrimino(IBlock block) {
    Objects.requireNonNull(block);
    Tetrimino o = new Tetrimino();
    o.blocks[1][1] = block;
    o.blocks[1][2] = block;
    o.blocks[2][1] = block;
    o.blocks[2][2] = block;
    return o;
  }

  public static Tetrimino newOTetrimino() {
    return newOTetrimino(ColorBlock.YELLOW);
  }

  public static Tetrimino newSTetrimino(IBlock block) {
    Objects.requireNonNull(block);
    Tetrimino s = new Tetrimino();
    s.blocks[0][1] = block;
    s.blocks[1][1] = block;
    s.blocks[1][2] = block;
    s.blocks[2][2] = block;
    return s;
  }

  public static Tetrimino newSTetrimino() {
    return newSTetrimino(ColorBlock.GREEN);
  }

  public static Tetrimino newZTetrimino(IBlock block) {
    Objects.requireNonNull(block);
    Tetrimino z = new Tetrimino();
    z.blocks[0][2] = block;
    z.blocks[1][2] = block;
    z.blocks[1][1] = block;
    z.blocks[2][1] = block;
    return z;
  }

  public static Tetrimino newZTetrimino() {
    return newZTetrimino(ColorBlock.RED);
  }

  public static Tetrimino newJTetrimino(IBlock block) {
    Objects.requireNonNull(block);
    Tetrimino j = new Tetrimino();
    j.blocks[0][2] = block;
    j.blocks[1][2] = block;
    j.blocks[2][2] = block;
    j.blocks[2][1] = block;
    return j;
  }

  public static Tetrimino newJTetrimino() {
    return newJTetrimino(ColorBlock.BLUE);
  }

  public static Tetrimino newLTetrimino(IBlock block) {
    Objects.requireNonNull(block);
    Tetrimino l = new Tetrimino();
    l.blocks[0][1] = block;
    l.blocks[1][1] = block;
    l.blocks[2][1] = block;
    l.blocks[2][2] = block;
    return l;
  }

  public static Tetrimino newLTetrimino() {
    return newLTetrimino(ColorBlock.ORANGE);
  }

  public static Tetrimino newTTetrimino(IBlock block) {
    Objects.requireNonNull(block);
    Tetrimino t = new Tetrimino();
    t.blocks[0][1] = block;
    t.blocks[1][1] = block;
    t.blocks[1][2] = block;
    t.blocks[2][1] = block;
    return t;
  }

  public static Tetrimino newTTetrimino() {
    return newTTetrimino(ColorBlock.PURPLE);
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

  @Override
  public void set(IField field, int x, int y) {
    field.set(this.blocks, x, y);
  }
}
