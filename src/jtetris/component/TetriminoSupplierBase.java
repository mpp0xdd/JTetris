package jtetris.component;

import java.util.Objects;
import java.util.Random;
import jtetris.common.Field;
import jtetris.common.TetriminoSupplier;

abstract class TetriminoSupplierBase implements TetriminoSupplier {
  final Field field;
  final Random rnd;

  TetriminoSupplierBase(Field field) {
    this.field = Objects.requireNonNull(field);
    this.rnd = new Random();
  }
}
