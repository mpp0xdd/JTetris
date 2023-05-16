import java.util.Random;
import java.util.function.Supplier;

public class ImageTetriminoSupplier implements Supplier<ITetrimino> {
  private Random rnd = new Random();

  @Override
  public ITetrimino get() {
    return switch (rnd.nextInt(7)) {
      case 0 -> Tetrimino.newITetrimino(ImageBlock.LIGHT_BLUE);
      case 1 -> Tetrimino.newOTetrimino(ImageBlock.YELLOW);
      case 2 -> Tetrimino.newSTetrimino(ImageBlock.GREEN);
      case 3 -> Tetrimino.newZTetrimino(ImageBlock.RED);
      case 4 -> Tetrimino.newJTetrimino(ImageBlock.BLUE);
      case 5 -> Tetrimino.newLTetrimino(ImageBlock.ORANGE);
      case 6 -> Tetrimino.newTTetrimino(ImageBlock.PURPLE);
      default -> throw (new IllegalStateException("Failed to supply tetriminos"));
    };
  }
}
