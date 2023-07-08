package jtetris.screen;

import static jtetris.common.Constants.GAME_LOOP_INTERVAL;
import java.awt.Graphics;
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

  public MainScreen() {
    setScreenSize(field.width(), field.height());
    setGameLoopInterval(GAME_LOOP_INTERVAL);
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
    tetrimino.draw(g);
    tetrimino.drawGhost(g);
  }

  @Override
  protected void runGameLoop() {
    moveDownTetrimino();
    field.clearLine();
    repaint();
  }

  @Override
  public void keyPressed(KeyEvent e) {
    switch (e.getKeyCode()) {
      case KeyEvent.VK_LEFT -> tetrimino.moveLeft();
      case KeyEvent.VK_RIGHT -> tetrimino.moveRight();
      case KeyEvent.VK_UP -> tetrimino.moveUp();
      case KeyEvent.VK_DOWN -> moveDownTetrimino();
      case KeyEvent.VK_A -> tetrimino.rotateLeft();
      case KeyEvent.VK_D -> tetrimino.rotateRight();
    }
    repaint();
  }

  @Override
  public void keyReleased(KeyEvent e) {}

  @Override
  public void keyTyped(KeyEvent e) {}

  private void moveDownTetrimino() {
    if (!tetrimino.moveDown()) {
      tetrimino.fix();
      tetrimino = supplier.get();
    }
  }
}
