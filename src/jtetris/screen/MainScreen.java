package jtetris.screen;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Optional;
import java.util.function.Supplier;
import javax.sound.sampled.Clip;
import jglib.component.GameScreen;
import jglib.util.GameUtilities;
import jtetris.common.IField;
import jtetris.common.ITetrimino;
import jtetris.component.Field;
import jtetris.component.Tetrimino;
import jtetris.function.ColorTetriminoSupplier;

public class MainScreen extends GameScreen implements KeyListener {

  private final Optional<Clip> bgmClip =
      GameUtilities.loadClip(MainScreen.class.getResource("sounds/bgm.wav"));

  private final IField field = new Field();
  private Supplier<ITetrimino> supplier = new ColorTetriminoSupplier(field);
  private ITetrimino tetrimino = supplier.get();
  private final int ix = IField.COLUMNS / 2 - Tetrimino.LENGTH / 2;
  private final int iy = -Tetrimino.LENGTH;
  private final Point tp = new Point(ix, iy);

  public MainScreen() {
    super(IField.WIDTH, IField.HEIGHT);
    setGameLoopInterval(250);
    setFocusable(true);
    addKeyListener(this);
  }

  public void playBGM() {
    bgmClip.ifPresent(GameUtilities::repeatClip);
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    field.draw(g, 0, 0);
    tetrimino.draw(g, tp.x, tp.y);
  }

  @Override
  protected void runGameLoop() {
    if (tetrimino.isSettable(field, tp.x, tp.y + 1)) {
      tp.translate(0, 1);
    } else {
      tetrimino.set(field, tp.x, tp.y);
      tp.setLocation(ix, iy);
      tetrimino = supplier.get();
    }

    field.clearLine();

    repaint();
  }

  @Override
  public void keyPressed(KeyEvent e) {
    switch (e.getKeyCode()) {
      case KeyEvent.VK_LEFT -> {
        if (tetrimino.isSettable(field, tp.x - 1, tp.y)) {
          tp.translate(-1, 0);
        }
      }
      case KeyEvent.VK_RIGHT -> {
        if (tetrimino.isSettable(field, tp.x + 1, tp.y)) {
          tp.translate(1, 0);
        }
      }
      case KeyEvent.VK_UP -> {
        if (tetrimino.isSettable(field, tp.x, tp.y - 1)) {
          tp.translate(0, -1);
        }
      }
      case KeyEvent.VK_DOWN -> {
        if (tetrimino.isSettable(field, tp.x, tp.y + 1)) {
          tp.translate(0, 1);
        } else {
          tetrimino.set(field, tp.x, tp.y);
          tp.setLocation(ix, iy);
          tetrimino = supplier.get();
        }
      }
      case KeyEvent.VK_A -> tetrimino.rotateLeft(field, tp.x, tp.y);
      case KeyEvent.VK_D -> tetrimino.rotateRight(field, tp.x, tp.y);
    }
    repaint();
  }

  @Override
  public void keyReleased(KeyEvent e) {}

  @Override
  public void keyTyped(KeyEvent e) {}
}
