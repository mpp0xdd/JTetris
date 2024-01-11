package jtetris.function;

import jtetris.common.Field;
import jtetris.common.Tetrimino;
import jtetris.component.ImageBlock;
import jtetris.component.DefaultTetrimino;

class ImageTetriminoSupplier extends TetriminoSupplierBase {

  public ImageTetriminoSupplier(Field field) {
    super(field);
  }

  @Override
  public Tetrimino get() {
    return switch (rnd.nextInt(7)) {
      case 0 -> DefaultTetrimino.newITetrimino(field, ImageBlock.LIGHT_BLUE);
      case 1 -> DefaultTetrimino.newOTetrimino(field, ImageBlock.YELLOW);
      case 2 -> DefaultTetrimino.newSTetrimino(field, ImageBlock.GREEN);
      case 3 -> DefaultTetrimino.newZTetrimino(field, ImageBlock.RED);
      case 4 -> DefaultTetrimino.newJTetrimino(field, ImageBlock.BLUE);
      case 5 -> DefaultTetrimino.newLTetrimino(field, ImageBlock.ORANGE);
      case 6 -> DefaultTetrimino.newTTetrimino(field, ImageBlock.PURPLE);
      default -> throw (new IllegalStateException("Failed to supply tetriminos"));
    };
  }
}
