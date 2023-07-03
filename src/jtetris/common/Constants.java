package jtetris.common;

public final class Constants {

  private Constants() {
    // restrict instantiation
  }

  public static final int BLOCK_SIZE = 30;
  public static final int TETRIMINO_LENGTH = 4;
  public static final int FIELD_ROWS = 20 + 1;
  public static final int FIELD_COLUMNS = 10 + 2;
  public static final int FIELD_WIDTH = FIELD_COLUMNS * BLOCK_SIZE;
  public static final int FIELD_HEIGHT = FIELD_ROWS * BLOCK_SIZE;
}
