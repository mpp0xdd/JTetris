package jtetris.component;

import jtetris.common.Field;

public final class FieldFactory {

  private FieldFactory() {
    // restrict instantiation
  }

  public static Field create() {
    return new DefaultField();
  }
}
