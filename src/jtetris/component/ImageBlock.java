package jtetris.component;

import static jtetris.common.Constants.BLOCK_SIZE;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.Objects;
import jglib.util.GameUtilities;
import jtetris.common.IBlock;
import jtetris.resource.ImageFactory;

public class ImageBlock implements IBlock {
  public static final IBlock GRAY = new ImageBlock(ImageFactory.newGrayBlockImage());
  public static final IBlock BLACK = new ImageBlock(ImageFactory.newBlackBlockImage());
  public static final IBlock LIGHT_BLUE = new ImageBlock(ImageFactory.newLightBlueBlockImage());
  public static final IBlock YELLOW = new ImageBlock(ImageFactory.newYellowBlockImage());
  public static final IBlock GREEN = new ImageBlock(ImageFactory.newGreenBlockImage());
  public static final IBlock RED = new ImageBlock(ImageFactory.newRedBlockImage());
  public static final IBlock BLUE = new ImageBlock(ImageFactory.newBlueBlockImage());
  public static final IBlock ORANGE = new ImageBlock(ImageFactory.newOrangeBlockImage());
  public static final IBlock PURPLE = new ImageBlock(ImageFactory.newPurpleBlockImage());

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
