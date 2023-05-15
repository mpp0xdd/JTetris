public class JTetris {
  public static void main(String[] args) {
    GameWindow window = new JTetrisWindow();
    GameScreen screen = new MainScreen();

    window.switchGameScreen(screen);
    window.setVisible(true);
    screen.startGameLoop();
  }
}
