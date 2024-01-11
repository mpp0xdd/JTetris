package jtetris.component;

import jtetris.common.Field;

class TetriminoSupplierForTest extends TetriminoSupplierBase {

  public TetriminoSupplierForTest(Field field) {
    super(field);
  }

  @Override
  public jtetris.common.Tetrimino get() {
    return switch (rnd.nextInt(2)) {
      case 0 -> Tetrimino.newITetrimino(field, ColorBlock.LIGHT_BLUE);
      case 1 -> Tetrimino.newOTetrimino(field, ColorBlock.YELLOW);
      default -> throw (new IllegalStateException("Failed to supply tetriminos"));
    };
  }
}
