package jtetris.function;

import java.util.Objects;
import java.util.Random;
import java.util.function.Supplier;
import jtetris.common.IField;
import jtetris.common.ITetrimino;
import jtetris.component.ColorBlock;
import jtetris.component.Tetrimino;

public class TetriminoSupplierForTest implements Supplier<ITetrimino> {
  private IField field;
  private Random rnd = new Random();

  public TetriminoSupplierForTest(IField field) {
    this.field = Objects.requireNonNull(field);
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
