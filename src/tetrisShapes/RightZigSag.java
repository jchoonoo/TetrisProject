package tetrisShapes;

import java.awt.*;
import java.util.ArrayList;
import utils.Position;
import utils.ShapeCell;


public class RightZigSag extends AbstractTetrisShape {

  /**
   * creates a {@code RightZigSag} object
   */
  public RightZigSag() {
    super();
    pivotCellNumber = 2;
  }

  @Override
  public void fixCellPositions() {
    switch (rotation) {
      case 1:
        this.cells[0].setX(this.cells[0].getX() + 2);
        this.cells[0].setY(this.cells[0].getY());
        this.cells[1].setX(this.cells[1].getX() + 1);
        this.cells[1].setY(this.cells[1].getY() - 1);
        this.cells[2].setX(this.cells[2].getX());
        this.cells[2].setY(this.cells[2].getY());
        this.cells[3].setX(this.cells[3].getX() - 1);
        this.cells[3].setY(this.cells[3].getY() - 1);
        break;
      case 2:
        this.cells[0].setX(this.cells[0].getX() - 2);
        this.cells[0].setY(this.cells[0].getY());
        this.cells[1].setX(this.cells[1].getX() - 1);
        this.cells[1].setY(this.cells[1].getY() + 1);
        this.cells[2].setX(this.cells[2].getX());
        this.cells[2].setY(this.cells[2].getY());
        this.cells[3].setX(this.cells[3].getX() + 1);
        this.cells[3].setY(this.cells[3].getY() + 1);
        break;
    }
  }

  @Override
  public ArrayList<ShapeCell> bottomPositions() {
    ArrayList<ShapeCell> bottomCells = new ArrayList<ShapeCell>();
    switch (this.rotation) {
      case 1:
        bottomCells.add(cells[0]);
        bottomCells.add(cells[1]);
        bottomCells.add(cells[3]);
        break;
      case 2:
        bottomCells.add(cells[2]);
        bottomCells.add(cells[0]);
        break;
      default:
        break;
    } return bottomCells;
  }

  @Override
  public ArrayList<ShapeCell> rightPositions() {
    ArrayList<ShapeCell> rightCells = new ArrayList<ShapeCell>();
    switch (this.rotation) {
      case 1:
        rightCells.add(cells[1]);
        rightCells.add(cells[3]);
        break;
      case 2:
        rightCells.add(cells[0]);
        rightCells.add(cells[1]);
        rightCells.add(cells[3]);
        break;
      default:
        break;
    } return rightCells;
  }

  @Override
  public ArrayList<ShapeCell> leftPositions() {
    ArrayList<ShapeCell> leftCells = new ArrayList<ShapeCell>();
    switch (this.rotation) {
      case 1:
        leftCells.add(cells[0]);
        leftCells.add(cells[2]);
        break;
      case 2:
        leftCells.add(cells[0]);
        leftCells.add(cells[2]);
        leftCells.add(cells[3]);
        break;
      default:
        break;
    } return leftCells;
  }

  @Override
  public ITetrisShape duplicate() {
    return new RightZigSag();
  }

  @Override
  public String getShapeName() {
    return "RightZigZag";
  }

  @Override
  public Position[][] rotationPositions() {
    Position[][] rotationPositions =  new Position[2][2];

    rotationPositions[0][0] = new Position(this.x, this.y - 1);
    rotationPositions[0][1] = new Position(this.x + 1, this.y + 1);

    rotationPositions[1][0] = new Position(this.x, this.y + 1);
    rotationPositions[1][1] = new Position(this.x - 1, this.y + 1);


    return rotationPositions;
  }

  @Override
  public void rotate() {
    this.fixCellPositions();
    if (rotation == 2) {
      rotation = 1;
    } else {
      rotation = rotation + 1;
    }
  }

  @Override
  public void setColor() {
    this.color = Color.CYAN;
  }
}
