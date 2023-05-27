package jtetris;

import jglib.component.GameWindow;
import jtetris.screen.MainScreen;

public class JTetris {
  public static void main(String[] args) {
    GameWindow window = new JTetrisWindow();
    MainScreen screen = new MainScreen();

    window.switchGameScreen(screen);
    window.setVisible(true);
    screen.startGameLoop();
    screen.playBGM();
  }
}
