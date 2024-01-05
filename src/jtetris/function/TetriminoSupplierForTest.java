package jtetris.function;

import jtetris.common.IField;
import jtetris.common.ITetrimino;
import jtetris.component.ColorBlock;
import jtetris.component.Tetrimino;

class TetriminoSupplierForTest extends TetriminoSupplierBase {

  public TetriminoSupplierForTest(IField field) {
    super(field);
  }

  @Override
  public ITetrimino get() {
    return switch (rnd.nextInt(2)) {
      case 0 -> Tetrimino.newITetrimino(field, ColorBlock.LIGHT_BLUE);
      case 1 -> Tetrimino.newOTetrimino(field, ColorBlock.YELLOW);
      default -> throw (new IllegalStateException("Failed to supply tetriminos"));
    };
  }
}
