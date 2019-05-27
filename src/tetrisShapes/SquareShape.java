package tetrisShapes;

import java.awt.*;
import java.util.ArrayList;
import utils.Position;
import utils.ShapeCell;


public class SquareShape extends AbstractTetrisShape {

  /**
   * creates a {@code SquareShape} object
   */
  public SquareShape() {
    super();
    pivotCellNumber = 0;
  }

  @Override
  public void fixCellPositions() {
    switch (rotation) {
      case 1:
        this.cells[0].setX(this.cells[0].getX());
        this.cells[0].setY(this.cells[0].getY());
        this.cells[1].setX(this.cells[1].getX());
        this.cells[1].setY(this.cells[1].getY());
        this.cells[2].setX(this.cells[2].getX());
        this.cells[2].setY(this.cells[2].getY());
        this.cells[3].setX(this.cells[3].getX());
        this.cells[3].setY(this.cells[3].getY());
        break;
    }
  }

  @Override
  public ArrayList<ShapeCell> bottomPositions() {
    ArrayList<ShapeCell> leftCells = new ArrayList<ShapeCell>();
    leftCells.add(cells[2]);
    leftCells.add(cells[3]);
    return leftCells;
  }

  @Override
  public ArrayList<ShapeCell> rightPositions() {
    ArrayList<ShapeCell> leftCells = new ArrayList<ShapeCell>();
    leftCells.add(cells[1]);
    leftCells.add(cells[3]);
    return leftCells;
  }

  @Override
  public ArrayList<ShapeCell> leftPositions() {
    ArrayList<ShapeCell> leftCells = new ArrayList<ShapeCell>();
    leftCells.add(cells[0]);
    leftCells.add(cells[2]);
    return leftCells;
  }

  @Override
  public ITetrisShape duplicate() {
    return new SquareShape();
  }

  @Override
  public String getShapeName() {
    return "SquareShape";
  }

  @Override
  public Position[][] rotationPositions() {
    Position[][] rotationPositions =  new Position[1][1];
    rotationPositions[0][0] = new Position(this.getX(), this.getY());
    return rotationPositions;
  }

  @Override
  public void rotate() {
    this.fixCellPositions();
    rotation = 1;
  }

  @Override
  public void setColor() {
    this.color = Color.RED;
  }
}
