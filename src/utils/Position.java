package utils;

public class Position {
  int x;
  int y;

  /**
   * creates a {@code Position} object
   * @param x x value
   * @param y y value
   */
  public Position(int x, int y) {
    this.x = x;
    this.y = y;
  }

  /**
   * gets this x position of this position
   * @return x position
   */
  public int getX() {
    return this.x;
  }

  /**
   * gets this x position of this position
   * @return x position
   */
  public int getY() {
    return this.y;
  }

  /**
   * sets the x coordinate of this position
   * @param x x value
   */
  public void setX(int x) {
    this.x = x;
  }

  /**
   * sets the y coordinate of this position
   * @param y y value
   */
  public void setY(int y) {
    this.y = y;
  }
}
