package jtetris.component;

import static jtetris.common.Constants.BLOCK_SIZE;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.Objects;
import jglib.util.GameUtilities;
import jtetris.common.IBlock;
import jtetris.factories.ImageFactory;

public class ImageBlock implements IBlock {
  public static final IBlock GRAY = new ImageBlock(ImageFactory.grayBlockImage());
  public static final IBlock BLACK = new ImageBlock(ImageFactory.blackBlockImage());
  public static final IBlock LIGHT_BLUE = new ImageBlock(ImageFactory.lightBlueBlockImage());
  public static final IBlock YELLOW = new ImageBlock(ImageFactory.yellowBlockImage());
  public static final IBlock GREEN = new ImageBlock(ImageFactory.greenBlockImage());
  public static final IBlock RED = new ImageBlock(ImageFactory.redBlockImage());
  public static final IBlock BLUE = new ImageBlock(ImageFactory.blueBlockImage());
  public static final IBlock ORANGE = new ImageBlock(ImageFactory.orangeBlockImage());
  public static final IBlock PURPLE = new ImageBlock(ImageFactory.purpleBlockImage());

  private final BufferedImage image;

  public ImageBlock(BufferedImage image) {
    this.image = Objects.requireNonNull(image);
    if (image.getWidth() != BLOCK_SIZE || image.getHeight() != BLOCK_SIZE) {
      throw (new IllegalArgumentException(
          String.format(
              "Image size error: %d*%d != %d*%d",
              image.getWidth(), image.getHeight(), BLOCK_SIZE, BLOCK_SIZE)));
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
