package tetrisShapes;

import java.awt.*;
import java.util.ArrayList;

import utils.GridCell;
import utils.Position;
import utils.ShapeCell;


public abstract class AbstractTetrisShape implements ITetrisShape {

  public ShapeCell[] cells;
  protected Color color;
  protected int x;
  protected int y;
  protected int rotation;
  protected int pivotCellNumber;

  /**
   * creates a {@object AbstractTetrisShape} object
   */
  public AbstractTetrisShape() {
    this.cells = new ShapeCell[4];
    this.setColor();
    this.rotation = 1;
  }

  @Override
  public void setCells(GridCell[] startingCells) {
    this.cells[0] = new ShapeCell(startingCells[0].getX(), startingCells[0].getY(), this.color);
    this.cells[1] = new ShapeCell(startingCells[1].getX(), startingCells[1].getY(), this.color);
    this.cells[2] = new ShapeCell(startingCells[2].getX(), startingCells[2].getY(), this.color);
    this.cells[3] = new ShapeCell(startingCells[3].getX(), startingCells[3].getY(), this.color);
    this.setShapePos(cells[pivotCellNumber].getX(), cells[pivotCellNumber].getY());
  }

 @Override
  public void setShapePos(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public void moveRight() {
    this.cells[0].setX(this.cells[0].getX() + 1);
    this.cells[1].setX(this.cells[1].getX() + 1);
    this.cells[2].setX(this.cells[2].getX() + 1);
    this.cells[3].setX(this.cells[3].getX() + 1);
    this.setShapePos(cells[pivotCellNumber].getX(), cells[pivotCellNumber].getY());
  }

  @Override
  public void moveLeft() {
    this.cells[0].setX(this.cells[0].getX() - 1);
    this.cells[1].setX(this.cells[1].getX() - 1);
    this.cells[2].setX(this.cells[2].getX() - 1);
    this.cells[3].setX(this.cells[3].getX() - 1);
    this.setShapePos(cells[pivotCellNumber].getX(), cells[pivotCellNumber].getY());
  }

  @Override
  public void moveDown() {
    this.cells[0].setY(this.cells[0].getY() + 1);
    this.cells[1].setY(this.cells[1].getY() + 1);
    this.cells[2].setY(this.cells[2].getY() + 1);
    this.cells[3].setY(this.cells[3].getY() + 1);
    this.setShapePos(cells[pivotCellNumber].getX(), cells[pivotCellNumber].getY());
  }

  @Override
  public ArrayList<ShapeCell> sidePositions(String side) {
    if(side.equals("down")) {
      return this.bottomPositions();
    } else {
      if(side.equals("right")) {
        return this.rightPositions();
      } else {
        if(side.equals("left")) {
          return this.leftPositions();
        } else {
          throw new IllegalArgumentException("needs a valid direction");
        }
      }
    }
  }

  @Override
  public Color getColor(){
    return this.color;
  }


  @Override
  public int getX() {
    return this.x;
  }

  @Override
  public int getY() {
    return this.y;
  }

  @Override
  public int getRotation() {
    return this.rotation;
  }

  @Override
  public ShapeCell[] getCells() {
    return this.cells;
  }

  @Override
  public abstract String getShapeName();

  @Override
  public abstract Position[][] rotationPositions();

  @Override
  public abstract void fixCellPositions();

  @Override
  public abstract void rotate();

  @Override
  public abstract void setColor();

  @Override
  public abstract ArrayList<ShapeCell> bottomPositions();

  @Override
  public abstract ArrayList<ShapeCell> rightPositions();

  @Override
  public abstract ArrayList<ShapeCell> leftPositions();

  @Override
  public abstract ITetrisShape duplicate();
}
