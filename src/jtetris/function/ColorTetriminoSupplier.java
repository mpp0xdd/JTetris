package jtetris.function;
import java.util.Random;
import java.util.function.Supplier;
import jtetris.common.ITetrimino;
import jtetris.component.ColorBlock;
import jtetris.component.Tetrimino;

public class ColorTetriminoSupplier implements Supplier<ITetrimino> {
  private Random rnd = new Random();

  @Override
  public ITetrimino get() {
    return switch (rnd.nextInt(7)) {
      case 0 -> Tetrimino.newITetrimino(ColorBlock.LIGHT_BLUE);
      case 1 -> Tetrimino.newOTetrimino(ColorBlock.YELLOW);
      case 2 -> Tetrimino.newSTetrimino(ColorBlock.GREEN);
      case 3 -> Tetrimino.newZTetrimino(ColorBlock.RED);
      case 4 -> Tetrimino.newJTetrimino(ColorBlock.BLUE);
      case 5 -> Tetrimino.newLTetrimino(ColorBlock.ORANGE);
      case 6 -> Tetrimino.newTTetrimino(ColorBlock.PURPLE);
      default -> throw (new IllegalStateException("Failed to supply tetriminos"));
    };
  }
}
