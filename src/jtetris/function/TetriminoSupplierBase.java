package jtetris.function;

import java.util.Objects;
import jtetris.common.IField;

abstract class TetriminoSupplierBase implements TetriminoSupplier {
  final IField field;

  TetriminoSupplierBase(IField field) {
    this.field = Objects.requireNonNull(field);
  }
}
