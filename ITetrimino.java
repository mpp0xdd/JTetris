import java.awt.Color;

public class ITetrimino extends Tetrimino {
  private static final IBlock block = new ColorBlock(new Color(0, 204, 204));

  public ITetrimino() {
    this.blocks[0][1] = block;
    this.blocks[1][1] = block;
    this.blocks[2][1] = block;
    this.blocks[3][1] = block;
  }
}
