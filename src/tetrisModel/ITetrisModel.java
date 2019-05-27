package tetrisModel;

import java.util.ArrayList;
import java.util.List;

import tetrisShapes.ITetrisShape;
import utils.GridCell;
import utils.ShapeCell;

public interface ITetrisModel {

  /**
   * moves the shape in the given direction
   * @param direction the direction to move the shape
   */
  void move(String direction);

  /**
   * rotates the shape
   */
  void rotate();

  int getWidth();

  int getHeight();

  ITetrisShape getCurrent();

  GridCell getCells(int x, int y);

  List<ShapeCell> getCellsOnBoard();

  boolean isGameOver();

  List<ITetrisShape> getDupNextShapes();

  int getLineCount();

  int getLevel();

  void restartGame();

  void setSize(int width, int height);
}
