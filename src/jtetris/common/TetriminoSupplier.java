package jtetris.common;

import java.util.function.Supplier;

@FunctionalInterface
public interface TetriminoSupplier extends Supplier<ITetrimino> {

  @Override
  ITetrimino get();
}
