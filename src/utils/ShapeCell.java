package utils;

import java.awt.*;

public class ShapeCell extends AbstractCell {

  /**
   * creates a {@code ShapeCell} object
   * @param x x coordinate
   * @param y y cooridnate
   */
  Color color;
  Boolean landed;
  public ShapeCell(int x, int y, Color color) {
    super(x, y);
    this.color = color;
    this.landed = false;
  }

  public Color getColor() {
    return this.color;
  }

  public void setLanded() {
    this.landed = true;
  }

  public boolean isLanded() {
    return this.landed;
  }
}
