package jtetris.function;

import java.util.Objects;
import java.util.Random;
import jtetris.common.IField;
import jtetris.common.TetriminoSupplier;

abstract class TetriminoSupplierBase implements TetriminoSupplier {
  final IField field;
  final Random rnd;

  TetriminoSupplierBase(IField field) {
    this.field = Objects.requireNonNull(field);
    this.rnd = new Random();
  }
}
