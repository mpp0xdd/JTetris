package jtetris.screen;

import static jtetris.common.Constants.FIELD_COLUMNS;
import static jtetris.common.Constants.FIELD_HEIGHT;
import static jtetris.common.Constants.FIELD_WIDTH;
import static jtetris.common.Constants.TETRIMINO_LENGTH;
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
import jtetris.function.ColorTetriminoSupplier;

public class MainScreen extends GameScreen implements KeyListener {

  private final Optional<Clip> bgmClip =
      GameUtilities.loadClip(MainScreen.class.getResource("sounds/bgm.wav"));

  private final IField field = new Field();
  private Supplier<ITetrimino> supplier = new ColorTetriminoSupplier(field);
  private ITetrimino tetrimino = supplier.get();
  private final int ix = FIELD_COLUMNS / 2 - TETRIMINO_LENGTH / 2;
  private final int iy = -TETRIMINO_LENGTH;
  private final Point tp = new Point(ix, iy);

  public MainScreen() {
    super(FIELD_WIDTH, FIELD_HEIGHT);
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
    if (tetrimino.isSettable(tp.x, tp.y + 1)) {
      tp.translate(0, 1);
    } else {
      tetrimino.set(tp.x, tp.y);
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
        if (tetrimino.isSettable(tp.x - 1, tp.y)) {
          tp.translate(-1, 0);
        }
      }
      case KeyEvent.VK_RIGHT -> {
        if (tetrimino.isSettable(tp.x + 1, tp.y)) {
          tp.translate(1, 0);
        }
      }
      case KeyEvent.VK_UP -> {
        if (tetrimino.isSettable(tp.x, tp.y - 1)) {
          tp.translate(0, -1);
        }
      }
      case KeyEvent.VK_DOWN -> {
        if (tetrimino.isSettable(tp.x, tp.y + 1)) {
          tp.translate(0, 1);
        } else {
          tetrimino.set(tp.x, tp.y);
          tp.setLocation(ix, iy);
          tetrimino = supplier.get();
        }
      }
      case KeyEvent.VK_A -> tetrimino.rotateLeft(tp.x, tp.y);
      case KeyEvent.VK_D -> tetrimino.rotateRight(tp.x, tp.y);
    }
    repaint();
  }

  @Override
  public void keyReleased(KeyEvent e) {}

  @Override
  public void keyTyped(KeyEvent e) {}
}
