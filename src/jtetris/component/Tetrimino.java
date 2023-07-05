package jtetris.component;

import static jtetris.common.Constants.BLOCK_SIZE;
import java.awt.Graphics;
import java.awt.Point;
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
  private final Point point;

  private Tetrimino(IField field) {
    this.field = Objects.requireNonNull(field);
    this.blocks = new IBlock[length()][length()];
    this.point = new Point(field.columns() / 2 - length() / 2, -length());

    for (int i = 0; i < length(); i++) {
      for (int j = 0; j < length(); j++) {
        this.blocks[i][j] = field.empty();
      }
    }
  }

  @Override
  public void draw(Graphics g) {
    for (int i = 0; i < length(); i++) {
      for (int j = 0; j < length(); j++) {
        IBlock block = this.blocks[i][j];
        if (!block.equals(field.empty())) {
          block.draw(g, (point.x + j) * BLOCK_SIZE, (point.y + i) * BLOCK_SIZE);
        }
      }
    }
  }

  @Override
  public boolean moveLeft() {
    if (field.isSettable(blocks, point.x - 1, 0)) {
      point.translate(-1, 0);
      return true;
    }
    return false;
  }

  @Override
  public boolean moveRight() {
    if (field.isSettable(blocks, point.x + 1, 0)) {
      point.translate(1, 0);
      return true;
    }
    return false;
  }

  @Override
  public boolean moveUp() {
    if (field.isSettable(blocks, point.x, point.y - 1)) {
      point.translate(0, -1);
      return true;
    }
    return false;
  }

  @Override
  public boolean moveDown() {
    if (field.isSettable(blocks, point.x, point.y + 1)) {
      point.translate(0, 1);
      return true;
    }
    return false;
  }

  @Override
  public void rotateLeft() {
    IBlock[][] newBlocks = new IBlock[length()][length()];

    for (int i = 0; i < length(); i++) {
      for (int j = 0; j < length(); j++) {
        newBlocks[length() - 1 - j][i] = this.blocks[i][j];
      }
    }
    if (field.isSettable(newBlocks, point.x, point.y)) {
      this.blocks = newBlocks;
    }
  }

  @Override
  public void rotateRight() {
    IBlock[][] newBlocks = new IBlock[length()][length()];

    for (int i = 0; i < length(); i++) {
      for (int j = 0; j < length(); j++) {
        newBlocks[j][length() - 1 - i] = this.blocks[i][j];
      }
    }
    if (field.isSettable(newBlocks, point.x, point.y)) {
      this.blocks = newBlocks;
    }
  }

  @Override
  public void set() {
    field.set(this.blocks, point.x, point.y);
  }
}
