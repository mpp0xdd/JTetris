package jtetris.component;

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
    this.blocks = new IBlock[LENGTH][LENGTH];

    for (int i = 0; i < LENGTH; i++) {
      for (int j = 0; j < LENGTH; j++) {
        this.blocks[i][j] = field.empty();
      }
    }
  }

  @Override
  public void draw(Graphics g, int x, int y) {
    for (int i = 0; i < LENGTH; i++) {
      for (int j = 0; j < LENGTH; j++) {
        IBlock block = this.blocks[i][j];
        if (!block.equals(field.empty())) {
          block.draw(g, (x + j) * IBlock.SIZE, (y + i) * IBlock.SIZE);
        }
      }
    }
  }

  @Override
  public void rotateLeft(IField field, int x, int y) {
    IBlock[][] newBlocks = new IBlock[LENGTH][LENGTH];

    for (int i = 0; i < LENGTH; i++) {
      for (int j = 0; j < LENGTH; j++) {
        newBlocks[LENGTH - 1 - j][i] = this.blocks[i][j];
      }
    }
    if (field.isSettable(newBlocks, x, y)) {
      this.blocks = newBlocks;
    }
  }

  @Override
  public void rotateRight(IField field, int x, int y) {
    IBlock[][] newBlocks = new IBlock[LENGTH][LENGTH];

    for (int i = 0; i < LENGTH; i++) {
      for (int j = 0; j < LENGTH; j++) {
        newBlocks[j][LENGTH - 1 - i] = this.blocks[i][j];
      }
    }
    if (field.isSettable(newBlocks, x, y)) {
      this.blocks = newBlocks;
    }
  }

  @Override
  public boolean isSettable(IField field, int x, int y) {
    return field.isSettable(this.blocks, x, y);
  }

  @Override
  public void set(IField field, int x, int y) {
    field.set(this.blocks, x, y);
  }
}
