package jtetris.component;

import static jtetris.common.Constants.BLOCK_SIZE;
import static jtetris.common.Constants.TETRIMINO_LENGTH;
import java.awt.Graphics;
import java.util.Objects;
import jtetris.common.IBlock;
import jtetris.common.IField;
import jtetris.common.ITetrimino;

public class Tetrimino implements ITetrimino {

  public static Tetrimino newITetrimino(IField field, IBlock block) {
    Objects.requireNonNull(block);
    Tetrimino i = new Tetrimino(field);
    i.blocks[0][1] = block;
    i.blocks[1][1] = block;
    i.blocks[2][1] = block;
    i.blocks[3][1] = block;
    return i;
  }

  public static Tetrimino newOTetrimino(IField field, IBlock block) {
    Objects.requireNonNull(block);
    Tetrimino o = new Tetrimino(field);
    o.blocks[1][1] = block;
    o.blocks[1][2] = block;
    o.blocks[2][1] = block;
    o.blocks[2][2] = block;
    return o;
  }

  public static Tetrimino newSTetrimino(IField field, IBlock block) {
    Objects.requireNonNull(block);
    Tetrimino s = new Tetrimino(field);
    s.blocks[0][1] = block;
    s.blocks[1][1] = block;
    s.blocks[1][2] = block;
    s.blocks[2][2] = block;
    return s;
  }

  public static Tetrimino newZTetrimino(IField field, IBlock block) {
    Objects.requireNonNull(block);
    Tetrimino z = new Tetrimino(field);
    z.blocks[0][2] = block;
    z.blocks[1][2] = block;
    z.blocks[1][1] = block;
    z.blocks[2][1] = block;
    return z;
  }

  public static Tetrimino newJTetrimino(IField field, IBlock block) {
    Objects.requireNonNull(block);
    Tetrimino j = new Tetrimino(field);
    j.blocks[0][2] = block;
    j.blocks[1][2] = block;
    j.blocks[2][2] = block;
    j.blocks[2][1] = block;
    return j;
  }

  public static Tetrimino newLTetrimino(IField field, IBlock block) {
    Objects.requireNonNull(block);
    Tetrimino l = new Tetrimino(field);
    l.blocks[0][1] = block;
    l.blocks[1][1] = block;
    l.blocks[2][1] = block;
    l.blocks[2][2] = block;
    return l;
  }

  public static Tetrimino newTTetrimino(IField field, IBlock block) {
    Objects.requireNonNull(block);
    Tetrimino t = new Tetrimino(field);
    t.blocks[0][1] = block;
    t.blocks[1][1] = block;
    t.blocks[1][2] = block;
    t.blocks[2][1] = block;
    return t;
  }

  private final IField field;
  private IBlock[][] blocks;

  private Tetrimino(IField field) {
    this.field = Objects.requireNonNull(field);
    this.blocks = new IBlock[TETRIMINO_LENGTH][TETRIMINO_LENGTH];

    for (int i = 0; i < TETRIMINO_LENGTH; i++) {
      for (int j = 0; j < TETRIMINO_LENGTH; j++) {
        this.blocks[i][j] = field.empty();
      }
    }
  }

  @Override
  public void draw(Graphics g, int x, int y) {
    for (int i = 0; i < TETRIMINO_LENGTH; i++) {
      for (int j = 0; j < TETRIMINO_LENGTH; j++) {
        IBlock block = this.blocks[i][j];
        if (!block.equals(field.empty())) {
          block.draw(g, (x + j) * BLOCK_SIZE, (y + i) * BLOCK_SIZE);
        }
      }
    }
  }

  @Override
  public void rotateLeft(int x, int y) {
    IBlock[][] newBlocks = new IBlock[TETRIMINO_LENGTH][TETRIMINO_LENGTH];

    for (int i = 0; i < TETRIMINO_LENGTH; i++) {
      for (int j = 0; j < TETRIMINO_LENGTH; j++) {
        newBlocks[TETRIMINO_LENGTH - 1 - j][i] = this.blocks[i][j];
      }
    }
    if (field.isSettable(newBlocks, x, y)) {
      this.blocks = newBlocks;
    }
  }

  @Override
  public void rotateRight(int x, int y) {
    IBlock[][] newBlocks = new IBlock[TETRIMINO_LENGTH][TETRIMINO_LENGTH];

    for (int i = 0; i < TETRIMINO_LENGTH; i++) {
      for (int j = 0; j < TETRIMINO_LENGTH; j++) {
        newBlocks[j][TETRIMINO_LENGTH - 1 - i] = this.blocks[i][j];
      }
    }
    if (field.isSettable(newBlocks, x, y)) {
      this.blocks = newBlocks;
    }
  }

  @Override
  public boolean isSettable(int x, int y) {
    return field.isSettable(this.blocks, x, y);
  }

  @Override
  public void set(int x, int y) {
    field.set(this.blocks, x, y);
  }
}
