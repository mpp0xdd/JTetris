package jtetris.common;

import java.util.function.Supplier;

@FunctionalInterface
public interface TetriminoSupplier extends Supplier<Tetrimino> {

  @Override
  Tetrimino get();
}
