package jtetris.screen;

import static jtetris.common.Constants.GAME_LOOP_INTERVAL;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import jglib.component.GameScreen;
import jglib.util.GameUtilities;
import jtetris.common.Field;
import jtetris.common.Tetrimino;
import jtetris.common.TetriminoSupplier;
import jtetris.component.FieldFactory;
import jtetris.component.TetriminoSupplierFactory;
import jtetris.resource.SoundFactory;

public class MainScreen extends GameScreen implements KeyListener {

  private final Field field = FieldFactory.create();
  private final TetriminoSupplier tetriminoSupplier = TetriminoSupplierFactory.create(field);
  private Tetrimino tetrimino = tetriminoSupplier.get();

  public MainScreen() {
    setScreenSize(field.width(), field.height());
    setGameLoopInterval(GAME_LOOP_INTERVAL);
    setFocusable(true);
    addKeyListener(this);
  }

  public void playBGM() {
    SoundFactory.mainScreenBgmClip().ifPresent(GameUtilities::repeatClip);
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    field.draw(g);
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
      tetrimino = tetriminoSupplier.get();
    }
  }
}
