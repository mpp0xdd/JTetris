package jtetris.component;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Objects;
import jtetris.common.Block;
import jtetris.resource.ImageFactory;

public enum ImageBlock implements Block {
  GRAY(ImageFactory.newGrayBlockImage()),
  BLACK(ImageFactory.newBlackBlockImage()),
  LIGHT_BLUE(ImageFactory.newLightBlueBlockImage()),
  YELLOW(ImageFactory.newYellowBlockImage()),
  GREEN(ImageFactory.newGreenBlockImage()),
  RED(ImageFactory.newRedBlockImage()),
  BLUE(ImageFactory.newBlueBlockImage()),
  ORANGE(ImageFactory.newOrangeBlockImage()),
  PURPLE(ImageFactory.newPurpleBlockImage());

  private final BufferedImage image;

  private ImageBlock(BufferedImage image) {
    this.image = Objects.requireNonNull(image);
    if (image.getWidth() != size() || image.getHeight() != size()) {
      throw (new IllegalArgumentException(
          String.format(
              "Image size error: %d*%d != %d*%d",
              image.getWidth(), image.getHeight(), size(), size())));
    }
  }

  @Override
  public void draw(Graphics g, int x, int y) {
    g.drawImage(image, x, y, null);
  }
}
