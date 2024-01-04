package jtetris.function;

import java.util.Random;
import jtetris.common.IField;
import jtetris.common.ITetrimino;
import jtetris.component.ColorBlock;
import jtetris.component.Tetrimino;

public class ColorTetriminoSupplier extends TetriminoSupplierBase {
  private Random rnd = new Random();

  public ColorTetriminoSupplier(IField field) {
    super(field);
  }

  @Override
  public ITetrimino get() {
    return switch (rnd.nextInt(7)) {
      case 0 -> Tetrimino.newITetrimino(field, ColorBlock.LIGHT_BLUE);
      case 1 -> Tetrimino.newOTetrimino(field, ColorBlock.YELLOW);
      case 2 -> Tetrimino.newSTetrimino(field, ColorBlock.GREEN);
      case 3 -> Tetrimino.newZTetrimino(field, ColorBlock.RED);
      case 4 -> Tetrimino.newJTetrimino(field, ColorBlock.BLUE);
      case 5 -> Tetrimino.newLTetrimino(field, ColorBlock.ORANGE);
      case 6 -> Tetrimino.newTTetrimino(field, ColorBlock.PURPLE);
      default -> throw (new IllegalStateException("Failed to supply tetriminos"));
    };
  }
}
