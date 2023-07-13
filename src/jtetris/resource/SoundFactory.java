package jtetris.resource;

import java.util.Optional;
import javax.sound.sampled.Clip;
import jglib.util.GameUtilities;

public final class SoundFactory {

  private SoundFactory() {
    // restrict instantiation
  }

  public static Optional<Clip> mainScreenBgmClip() {
    Optional<Clip> clip = GameUtilities.loadClip(SoundFactory.class.getResource("sounds/bgm.wav"));
    clip.ifPresent(c -> GameUtilities.setVolume(c, 0.7f));
    return clip;
  }
}
