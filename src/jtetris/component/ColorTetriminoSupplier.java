package jtetris.component;

import jtetris.common.Field;
import jtetris.common.Tetrimino;

class ColorTetriminoSupplier extends TetriminoSupplierBase {

  public ColorTetriminoSupplier(Field field) {
    super(field);
  }

  @Override
  public Tetrimino get() {
    return switch (rnd.nextInt(7)) {
      case 0 -> DefaultTetrimino.newITetrimino(field, ColorBlock.LIGHT_BLUE);
      case 1 -> DefaultTetrimino.newOTetrimino(field, ColorBlock.YELLOW);
      case 2 -> DefaultTetrimino.newSTetrimino(field, ColorBlock.GREEN);
      case 3 -> DefaultTetrimino.newZTetrimino(field, ColorBlock.RED);
      case 4 -> DefaultTetrimino.newJTetrimino(field, ColorBlock.BLUE);
      case 5 -> DefaultTetrimino.newLTetrimino(field, ColorBlock.ORANGE);
      case 6 -> DefaultTetrimino.newTTetrimino(field, ColorBlock.PURPLE);
      default -> throw (new IllegalStateException("Failed to supply tetriminos"));
    };
  }
}
