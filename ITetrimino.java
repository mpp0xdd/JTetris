import java.awt.Color;

public class ITetrimino extends Tetrimino {
  private static final IBlock block = new ColorBlock(new Color(0, 204, 204));

  public ITetrimino() {
    this.blocks[0][0] = block;
    this.blocks[1][0] = block;
    this.blocks[2][0] = block;
    this.blocks[3][0] = block;
  }
}
