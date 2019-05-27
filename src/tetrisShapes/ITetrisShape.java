package tetrisShapes;

import java.awt.*;
import java.util.ArrayList;

import utils.GridCell;
import utils.Position;
import utils.ShapeCell;

public interface ITetrisShape {

  /**
   * sets the cells of this shape to the correct starting positions on the board.
   * Also sets the pivot cell of this shape
   * @param startingCells list of grid cells where the shape should start
   */
  void setCells(GridCell[] startingCells);

   /**
    * sets the x and y coordinates of this shape
    * @param x x value
    * @param y y value
    */
  void setShapePos(int x, int y);

  /**
   * sets the color of this shape
   */
  void setColor();

  /**
   * changes the positions of each cell according to it's rotation
   */
  void fixCellPositions();

  /**
   * updates the shapes rotation number
   */
  void rotate();

  /**
   * moves the shape down
   */
  void moveDown();

  /**
   * moves the shape left
   */
  void moveLeft();

  /**
   * moves the shape right
   */
  void moveRight();

  /**
   * gets the cells on the bottom of the shape
   * @return a list of shapes
   */
  ArrayList<ShapeCell> bottomPositions();

  /**
   * gets the cells on the right of the shape
   * @return a list of shapes
   */
  ArrayList<ShapeCell> rightPositions();

  /**
   * gets the cells on the left of the shape
   * @return a list of shapes
   */
  ArrayList<ShapeCell> leftPositions();

  /**
   * gets the cells of the shape according to the side
   * @param direction the side of the shape e.g. "left, right, down"
   * @return
   */
  ArrayList<ShapeCell> sidePositions(String direction);

  /**
   * returns a list of positions that the shape will rotate into
   * @return array of positions
   */
  Position[][] rotationPositions();

  /**
   * gets the x position of this shape
   * @return x value of the shape
   */
  int getX();

  /**
   * gets the y position of this shape
   * @return y value of the shape
   */
  int getY();

  /**
   * gets the name of the shape
   * @return name of the shape
   */
  String getShapeName();

  /**
   * get this shapes cells
   * @return list of this shapes cells
   */
  ShapeCell[] getCells();

  /**
   * gets the rotation number of this shape
   * @return rotation number
   */
  int getRotation();

  Color getColor();

  ITetrisShape duplicate();
}
