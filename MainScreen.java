import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainScreen extends GameScreen implements KeyListener {

  private final IField field = new Field();
  private ITetrimino tetrimino = Tetrimino.newITetrimino();
  private final int ix = IField.COLUMNS / 2 - Tetrimino.LENGTH / 2;
  private final int iy = -Tetrimino.LENGTH;
  private final Point tloc = new Point(ix, iy);

  public MainScreen() {
    super(IField.WIDTH, IField.HEIGHT);
    setGameLoopInterval(250);
    setFocusable(true);
    addKeyListener(this);
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    field.draw(g, 0, 0);
    tetrimino.draw(g, tloc.x, tloc.y);
  }

  @Override
  protected void runGameLoop() {
    if (tetrimino.isSettable(field, tloc.x, tloc.y + 1)) {
      tloc.translate(0, 1);
    }
    repaint();
  }

  @Override
  public void keyPressed(KeyEvent e) {
    switch (e.getKeyCode()) {
      case KeyEvent.VK_LEFT -> {
        if (tetrimino.isSettable(field, tloc.x - 1, tloc.y)) {
          tloc.translate(-1, 0);
        }
      }
      case KeyEvent.VK_RIGHT -> {
        if (tetrimino.isSettable(field, tloc.x + 1, tloc.y)) {
          tloc.translate(1, 0);
        }
      }
      case KeyEvent.VK_UP -> {
        if (tetrimino.isSettable(field, tloc.x, tloc.y - 1)) {
          tloc.translate(0, -1);
        }
      }
      case KeyEvent.VK_DOWN -> {
        if (tetrimino.isSettable(field, tloc.x, tloc.y + 1)) {
          tloc.translate(0, 1);
        }
      }
      case KeyEvent.VK_A -> tetrimino.rotateLeft(field, tloc.x, tloc.y);
      case KeyEvent.VK_D -> tetrimino.rotateRight(field, tloc.x, tloc.y);
    }
    repaint();
  }

  @Override
  public void keyReleased(KeyEvent e) {}

  @Override
  public void keyTyped(KeyEvent e) {}
}
