package jtetris.function;

import jtetris.common.Field;
import jtetris.common.Tetrimino;
import jtetris.component.ColorBlock;
import jtetris.component.DefaultTetrimino;

class TetriminoSupplierForTest extends TetriminoSupplierBase {

  public TetriminoSupplierForTest(Field field) {
    super(field);
  }

  @Override
  public Tetrimino get() {
    return switch (rnd.nextInt(2)) {
      case 0 -> DefaultTetrimino.newITetrimino(field, ColorBlock.LIGHT_BLUE);
      case 1 -> DefaultTetrimino.newOTetrimino(field, ColorBlock.YELLOW);
      default -> throw (new IllegalStateException("Failed to supply tetriminos"));
    };
  }
}
