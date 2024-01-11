package jtetris.function;

import jtetris.common.Field;
import jtetris.common.TetriminoSupplier;

public final class TetriminoSupplierFactory {

  private TetriminoSupplierFactory() {
    // restrict instantiation
  }

  public static TetriminoSupplier create(Field field) {
    return new ColorTetriminoSupplier(field);
  }
}
