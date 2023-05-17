import java.util.Random;
import java.util.function.Supplier;

public class TetriminoSupplierForTest implements Supplier<ITetrimino> {
  private Random rnd = new Random();

  @Override
  public ITetrimino get() {
    return switch (rnd.nextInt(2)) {
      case 0 -> Tetrimino.newITetrimino(ColorBlock.LIGHT_BLUE);
      case 1 -> Tetrimino.newOTetrimino(ColorBlock.YELLOW);
      default -> throw (new IllegalStateException("Failed to supply tetriminos"));
    };
  }
}
