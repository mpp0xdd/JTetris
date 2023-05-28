package jtetris.component;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.Objects;
import jglib.util.GameUtilities;
import jtetris.common.IBlock;

public class ImageBlock implements IBlock {
  public static final IBlock GRAY =
      new ImageBlock(ImageBlock.class.getResource("images/gray_block.png"));
  public static final IBlock BLACK =
      new ImageBlock(ImageBlock.class.getResource("images/black_block.png"));
  public static final IBlock LIGHT_BLUE =
      new ImageBlock(ImageBlock.class.getResource("images/light_blue_block.png"));
  public static final IBlock YELLOW =
      new ImageBlock(ImageBlock.class.getResource("images/yellow_block.png"));
  public static final IBlock GREEN =
      new ImageBlock(ImageBlock.class.getResource("images/green_block.png"));
  public static final IBlock RED =
      new ImageBlock(ImageBlock.class.getResource("images/red_block.png"));
  public static final IBlock BLUE =
      new ImageBlock(ImageBlock.class.getResource("images/blue_block.png"));
  public static final IBlock ORANGE =
      new ImageBlock(ImageBlock.class.getResource("images/orange_block.png"));
  public static final IBlock PURPLE =
      new ImageBlock(ImageBlock.class.getResource("images/purple_block.png"));

  private final BufferedImage image;

  public ImageBlock(BufferedImage image) {
    this.image = Objects.requireNonNull(image);
    if (image.getWidth() != SIZE || image.getHeight() != SIZE) {
      throw (new IllegalArgumentException(
          String.format(
              "Image size error: %d*%d != %d*%d",
              image.getWidth(), image.getHeight(), SIZE, SIZE)));
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
