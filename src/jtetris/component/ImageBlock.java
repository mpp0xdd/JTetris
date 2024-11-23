package jtetris.component;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.Objects;
import jglib.util.GameUtilities;
import jtetris.common.Block;
import jtetris.resource.ImageFactory;

public class ImageBlock implements Block {
  public static final Block GRAY = new ImageBlock(ImageFactory.newGrayBlockImage());
  public static final Block BLACK = new ImageBlock(ImageFactory.newBlackBlockImage());
  public static final Block LIGHT_BLUE = new ImageBlock(ImageFactory.newLightBlueBlockImage());
  public static final Block YELLOW = new ImageBlock(ImageFactory.newYellowBlockImage());
  public static final Block GREEN = new ImageBlock(ImageFactory.newGreenBlockImage());
  public static final Block RED = new ImageBlock(ImageFactory.newRedBlockImage());
  public static final Block BLUE = new ImageBlock(ImageFactory.newBlueBlockImage());
  public static final Block ORANGE = new ImageBlock(ImageFactory.newOrangeBlockImage());
  public static final Block PURPLE = new ImageBlock(ImageFactory.newPurpleBlockImage());

  private final BufferedImage image;

  public ImageBlock(BufferedImage image) {
    this.image = Objects.requireNonNull(image);
    if (image.getWidth() != size() || image.getHeight() != size()) {
      throw (new IllegalArgumentException(
          String.format(
              "Image size error: %d*%d != %d*%d",
              image.getWidth(), image.getHeight(), size(), size())));
    }
  }

  public ImageBlock(URL url) {
    this(GameUtilities.loadImage(url).orElseThrow());
  }

  @Override
  public void draw(Graphics g, int x, int y) {
    g.drawImage(image, x, y, null);
  }

  @Override
  public int hashCode() {
    return Objects.hash(image);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    ImageBlock other = (ImageBlock) obj;
    return Objects.equals(image, other.image);
  }
}
