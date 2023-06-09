package jtetris.function;

import java.util.Objects;
import java.util.Random;
import java.util.function.Supplier;
import jtetris.common.IField;
import jtetris.common.ITetrimino;
import jtetris.component.ImageBlock;
import jtetris.component.Tetrimino;

public class ImageTetriminoSupplier implements Supplier<ITetrimino> {
  private IField field;
  private Random rnd = new Random();

  public ImageTetriminoSupplier(IField field) {
    this.field = Objects.requireNonNull(field);
  }

  @Override
  public ITetrimino get() {
    return switch (rnd.nextInt(7)) {
      case 0 -> Tetrimino.newITetrimino(field, ImageBlock.LIGHT_BLUE);
      case 1 -> Tetrimino.newOTetrimino(field, ImageBlock.YELLOW);
      case 2 -> Tetrimino.newSTetrimino(field, ImageBlock.GREEN);
      case 3 -> Tetrimino.newZTetrimino(field, ImageBlock.RED);
      case 4 -> Tetrimino.newJTetrimino(field, ImageBlock.BLUE);
      case 5 -> Tetrimino.newLTetrimino(field, ImageBlock.ORANGE);
      case 6 -> Tetrimino.newTTetrimino(field, ImageBlock.PURPLE);
      default -> throw (new IllegalStateException("Failed to supply tetriminos"));
    };
  }
}
