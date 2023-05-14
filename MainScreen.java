import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainScreen extends GameScreen implements KeyListener {

  private final IField field = new Field();
  private Tetrimino tetrimino = new ITetrimino();
  private final Point tetriminoLocation = new Point(2, 4);

  public MainScreen() {
    super(IField.WIDTH, IField.HEIGHT);
    setFocusable(true);
    addKeyListener(this);
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    field.draw(g, 0, 0);
    tetrimino.draw(g, tetriminoLocation.x, tetriminoLocation.y);
  }

  @Override
  protected void runGameLoop() {}

  @Override
  public void keyPressed(KeyEvent e) {
    switch (e.getKeyCode()) {
      case KeyEvent.VK_LEFT -> tetriminoLocation.translate(-1, 0);
      case KeyEvent.VK_RIGHT -> tetriminoLocation.translate(1, 0);
      case KeyEvent.VK_UP -> tetriminoLocation.translate(0, -1);
      case KeyEvent.VK_DOWN -> tetriminoLocation.translate(0, 1);
    }
    repaint();
  }

  @Override
  public void keyReleased(KeyEvent e) {}

  @Override
  public void keyTyped(KeyEvent e) {}
}
