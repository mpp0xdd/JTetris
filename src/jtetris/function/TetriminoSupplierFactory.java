package jtetris.function;

import jtetris.common.IField;
import jtetris.common.TetriminoSupplier;

public final class TetriminoSupplierFactory {

  private TetriminoSupplierFactory() {
    // restrict instantiation
  }

  public static TetriminoSupplier create(IField field) {
    return new ColorTetriminoSupplier(field);
  }
}
