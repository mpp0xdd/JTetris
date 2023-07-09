package jtetris.factories;

import java.awt.image.BufferedImage;
import jglib.util.GameUtilities;

public final class ImageFactory {

  private ImageFactory() {
    // restrict instantiation
  }

  public static BufferedImage grayBlockImage() {
    return GameUtilities.loadImage(ImageFactory.class.getResource("images/gray_block.png"))
        .orElseThrow();
  }

  public static BufferedImage blackBlockImage() {
    return GameUtilities.loadImage(ImageFactory.class.getResource("images/black_block.png"))
        .orElseThrow();
  }

  public static BufferedImage lightBlueBlockImage() {
    return GameUtilities.loadImage(ImageFactory.class.getResource("images/light_blue_block.png"))
        .orElseThrow();
  }

  public static BufferedImage yellowBlockImage() {
    return GameUtilities.loadImage(ImageFactory.class.getResource("images/yellow_block.png"))
        .orElseThrow();
  }

  public static BufferedImage greenBlockImage() {
    return GameUtilities.loadImage(ImageFactory.class.getResource("images/green_block.png"))
        .orElseThrow();
  }

  public static BufferedImage redBlockImage() {
    return GameUtilities.loadImage(ImageFactory.class.getResource("images/red_block.png"))
        .orElseThrow();
  }

  public static BufferedImage blueBlockImage() {
    return GameUtilities.loadImage(ImageFactory.class.getResource("images/blue_block.png"))
        .orElseThrow();
  }

  public static BufferedImage orangeBlockImage() {
    return GameUtilities.loadImage(ImageFactory.class.getResource("images/orange_block.png"))
        .orElseThrow();
  }

  public static BufferedImage purpleBlockImage() {
    return GameUtilities.loadImage(ImageFactory.class.getResource("images/purple_block.png"))
        .orElseThrow();
  }
}
