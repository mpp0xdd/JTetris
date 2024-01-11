package jtetris.resource;

import java.util.Optional;
import javax.sound.sampled.Clip;
import jglib.util.GameUtilities;

public final class SoundFactory {

  private SoundFactory() {
    // restrict instantiation
  }

  private static final Clip MAIN_SCREEN_BGM;

  static {
    Optional<Clip> clip = GameUtilities.loadClip(SoundFactory.class.getResource("sounds/bgm.wav"));
    clip.ifPresent(c -> GameUtilities.setVolume(c, 0.7f));
    MAIN_SCREEN_BGM = clip.orElse(null);
  }

  public static Optional<Clip> mainScreenBgmClip() {
    return Optional.ofNullable(MAIN_SCREEN_BGM);
  }
}
