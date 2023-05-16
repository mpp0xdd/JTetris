import java.util.Random;
import java.util.function.Supplier;

public class TetriminoSupplier implements Supplier<ITetrimino> {
  private Random rnd = new Random();

  @Override
  public ITetrimino get() {
    return switch (rnd.nextInt(7)) {
      case 0 -> Tetrimino.newITetrimino();
      case 1 -> Tetrimino.newOTetrimino();
      case 2 -> Tetrimino.newSTetrimino();
      case 3 -> Tetrimino.newZTetrimino();
      case 4 -> Tetrimino.newJTetrimino();
      case 5 -> Tetrimino.newLTetrimino();
      case 6 -> Tetrimino.newTTetrimino();
      default -> throw (new IllegalStateException("Failed to supply tetriminos"));
    };
  }
}
