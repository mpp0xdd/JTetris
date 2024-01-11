package jtetris.resource;

import static jglib.util.GameUtilities.loadImage;
import java.awt.image.BufferedImage;

public final class ImageFactory {

  private ImageFactory() {
    // restrict instantiation
  }

  public static BufferedImage newGrayBlockImage() {
    return loadImage(ImageFactory.class.getResource("images/gray_block.png")).orElseThrow();
  }

  public static BufferedImage newBlackBlockImage() {
    return loadImage(ImageFactory.class.getResource("images/black_block.png")).orElseThrow();
  }

  public static BufferedImage newLightBlueBlockImage() {
    return loadImage(ImageFactory.class.getResource("images/light_blue_block.png")).orElseThrow();
  }

  public static BufferedImage newYellowBlockImage() {
    return loadImage(ImageFactory.class.getResource("images/yellow_block.png")).orElseThrow();
  }

  public static BufferedImage newGreenBlockImage() {
    return loadImage(ImageFactory.class.getResource("images/green_block.png")).orElseThrow();
  }

  public static BufferedImage newRedBlockImage() {
    return loadImage(ImageFactory.class.getResource("images/red_block.png")).orElseThrow();
  }

  public static BufferedImage newBlueBlockImage() {
    return loadImage(ImageFactory.class.getResource("images/blue_block.png")).orElseThrow();
  }

  public static BufferedImage newOrangeBlockImage() {
    return loadImage(ImageFactory.class.getResource("images/orange_block.png")).orElseThrow();
  }

  public static BufferedImage newPurpleBlockImage() {
    return loadImage(ImageFactory.class.getResource("images/purple_block.png")).orElseThrow();
  }
}
