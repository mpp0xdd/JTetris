package jtetris.component;

import jtetris.common.IField;

public final class FieldFactory {

  private FieldFactory() {
    // restrict instantiation
  }

  public static IField create() {
    return new Field();
  }
}
