package jtetris;

import jglib.base.Game;
import jglib.component.GameWindow;
import jtetris.screen.MainScreen;

public class JTetris extends Game {

  public static void main(String[] args) {
    launch(JTetris.class);
  }

  @Override
  protected void start() {
    GameWindow window = new GameWindow("JTetris");
    MainScreen screen = new MainScreen();

    window.switchGameScreen(screen);
    window.setVisible(true);
    screen.startGameLoop();
    screen.playBGM();
  }
}
