import java.util.Random;

public class TetriminoSupplierForTest extends TetriminoSupplier {
  private Random rnd = new Random();

  @Override
  public Tetrimino get() {
    return switch (rnd.nextInt(2)) {
      case 0 -> Tetrimino.newITetrimino();
      case 1 -> Tetrimino.newOTetrimino();
      default -> throw (new IllegalStateException("Failed to supply tetriminos"));
    };
  }
}
