import java.awt.Graphics;

public class MainScreen extends GameScreen {

  private final IField field = new Field();

  public MainScreen() {
    super(IField.WIDTH, IField.HEIGHT);
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    field.draw(g, 0, 0);
  }

  @Override
  protected void runGameLoop() {}
}
