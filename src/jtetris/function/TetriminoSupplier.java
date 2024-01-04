package jtetris.function;

import java.util.function.Supplier;
import jtetris.common.ITetrimino;

@FunctionalInterface
public interface TetriminoSupplier extends Supplier<ITetrimino> {

  @Override
  ITetrimino get();
}
