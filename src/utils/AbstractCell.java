package utils;

public abstract class AbstractCell {
  int width;
  int height;
  int x;
  int y;
  Position pos;

  /**
   * constructs an {@code AbstractCell}
   * @param x x value
   * @param y y value
   */
  public AbstractCell(int x, int y) {
    this.width = 10;
    this.height = 10;
    this.x = x;
    this.y = y;
    this.pos = new Position(x, y);
  }

  /**
   * returns the x coordinate of this cell
   * @return x coordinate
   */
  public int getX() {
    return this.pos.getX();
  }

  /**
   * returns the y coordinate of this cell
   * @return y coordinate
   */
  public int getY() {
    return this.pos.getY();
  }

  /**
   * sets the x value for this cell
   * @param newX  x position
   */
  public void setX(int newX) {
    this.pos.setX(newX);;
  }

  /**
   * sets the y coordinate of this cell
   * @param newY  y position
   */
  public void setY(int newY) {
    this.pos.setY(newY);
  }
}
