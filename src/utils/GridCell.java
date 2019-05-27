package utils;

public class GridCell extends AbstractCell {

  ShapeCell shapeCell;

  /**
   * creates a grid cell {@code GridCell} object
   * @param x
   * @param y
   */
  public GridCell(int x, int y) {
    super(x, y);
    shapeCell = null;
  }

  /**
   * checks if this grid cell has a shape cell
   * @return boolean
   */
  public boolean hasShapeCell() {
    return shapeCell != null;
  }

  /**
   * sets this grid cell's shape cell
   * @param s the shape cell to set
   */
  public void setShapeCell(ShapeCell s) {
    this.shapeCell = s;
  }

  /**
   * get this grid cell's shape cell
   * @return ShapeCell
   */
  public ShapeCell getShapeCell() {
    return this.shapeCell;
  }

  /**
   * removes the shape cell from this grid cell
   */
  public void revertGridCell() { this.shapeCell = null;}
}
