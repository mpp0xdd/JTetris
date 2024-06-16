package jtetris.resource;

import static jglib.util.GameUtilities.loadImage;
import java.awt.image.BufferedImage;

public final class ImageFactory {

  private ImageFactory() {
    // restrict instantiation
  }

  public static BufferedImage newGrayBlockImage() {
    return loadImage(ImageFactory.class, "images/gray_block.png").orElseThrow();
  }

  public static BufferedImage newBlackBlockImage() {
    return loadImage(ImageFactory.class, "images/black_block.png").orElseThrow();
  }

  public static BufferedImage newLightBlueBlockImage() {
    return loadImage(ImageFactory.class, "images/light_blue_block.png").orElseThrow();
  }

  public static BufferedImage newYellowBlockImage() {
    return loadImage(ImageFactory.class, "images/yellow_block.png").orElseThrow();
  }

  public static BufferedImage newGreenBlockImage() {
    return loadImage(ImageFactory.class, "images/green_block.png").orElseThrow();
  }

  public static BufferedImage newRedBlockImage() {
    return loadImage(ImageFactory.class, "images/red_block.png").orElseThrow();
  }

  public static BufferedImage newBlueBlockImage() {
    return loadImage(ImageFactory.class, "images/blue_block.png").orElseThrow();
  }

  public static BufferedImage newOrangeBlockImage() {
    return loadImage(ImageFactory.class, "images/orange_block.png").orElseThrow();
  }

  public static BufferedImage newPurpleBlockImage() {
    return loadImage(ImageFactory.class, "images/purple_block.png").orElseThrow();
  }
}
