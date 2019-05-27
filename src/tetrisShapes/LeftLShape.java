package tetrisShapes;

import java.awt.*;
import java.util.ArrayList;
import utils.Position;
import utils.ShapeCell;


public class LeftLShape extends AbstractTetrisShape {

  /**
   * creates a {@code LeftLShape} object
   */
     public LeftLShape() {
      super();
      pivotCellNumber = 2;
    }

    @Override
  public void fixCellPositions() {
    switch (rotation) {
      case 1:
        this.cells[0].setX(this.cells[0].getX());
        this.cells[0].setY(this.cells[0].getY() - 2);
        this.cells[1].setX(this.cells[1].getX() + 1);
        this.cells[1].setY(this.cells[1].getY() - 1);
        this.cells[2].setX(this.cells[2].getX());
        this.cells[2].setY(this.cells[2].getY());
        this.cells[3].setX(this.cells[3].getX() - 1);
        this.cells[3].setY(this.cells[3].getY() + 1);
        break;
      case 2:
        this.cells[0].setX(this.cells[0].getX() + 2);
        this.cells[0].setY(this.cells[0].getY());
        this.cells[1].setX(this.cells[1].getX() + 1);
        this.cells[1].setY(this.cells[1].getY() + 1);
        this.cells[2].setX(this.cells[2].getX());
        this.cells[2].setY(this.cells[2].getY());
        this.cells[3].setX(this.cells[3].getX() - 1);
        this.cells[3].setY(this.cells[3].getY() - 1);
        break;
      case 3:
        this.cells[0].setX(this.cells[0].getX());
        this.cells[0].setY(this.cells[0].getY() + 2);
        this.cells[1].setX(this.cells[1].getX() - 1);
        this.cells[1].setY(this.cells[1].getY() + 1);
        this.cells[2].setX(this.cells[2].getX());
        this.cells[2].setY(this.cells[2].getY());
        this.cells[3].setX(this.cells[3].getX() + 1);
        this.cells[3].setY(this.cells[3].getY() - 1);
        break;
      case 4:
        this.cells[0].setX(this.cells[0].getX() - 2);
        this.cells[0].setY(this.cells[0].getY());
        this.cells[1].setX(this.cells[1].getX() - 1);
        this.cells[1].setY(this.cells[1].getY() - 1);
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
        bottomCells.add(cells[2]);
        bottomCells.add(cells[3]);
        break;
      case 2:
        bottomCells.add(cells[0]);
        bottomCells.add(cells[3]);
        break;
      case 3:
        bottomCells.add(cells[1]);
        bottomCells.add(cells[2]);
        bottomCells.add(cells[3]);
        break;
      case 4:
        bottomCells.add(cells[0]);
        bottomCells.add(cells[1]);
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
        rightCells.add(cells[0]);
        rightCells.add(cells[3]);
        break;
      case 2:
        rightCells.add(cells[1]);
        rightCells.add(cells[2]);
        rightCells.add(cells[3]);
        break;
      case 3:
        rightCells.add(cells[0]);
        rightCells.add(cells[1]);
        break;
      case 4:
        rightCells.add(cells[0]);
        rightCells.add(cells[2]);
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
        leftCells.add(cells[1]);
        break;
      case 2:
        leftCells.add(cells[0]);
        leftCells.add(cells[2]);
        leftCells.add(cells[3]);
        break;
      case 3:
        leftCells.add(cells[0]);
        leftCells.add(cells[3]);
        break;
      case 4:
        leftCells.add(cells[1]);
        leftCells.add(cells[2]);
        leftCells.add(cells[3]);
        break;
      default:
        break;
    } return leftCells;
  }

  @Override
  public ITetrisShape duplicate() {
       LeftLShape duplicate = new LeftLShape();
    return new LeftLShape();
  }

  @Override
  public void rotate() {
    this.fixCellPositions();
    if (rotation == 4) {
      rotation = 1;
    } else {
      rotation = rotation + 1;
    }
  }

  @Override
  public String getShapeName() {
    return "LeftLShape";
  }

  @Override
  public void setColor() {
    this.color = Color.BLUE;
  }

  @Override
  public Position[][] rotationPositions() {
    Position[][] rotationPositions =  new Position[4][3];
    rotationPositions[0][0] = new Position(this.x - 1, this.y - 1);
    rotationPositions[0][1] = new Position(this.x, this.y - 1);
    rotationPositions[0][2] = new Position(this.x, this.y + 1);

    rotationPositions[1][0] = new Position(this.x - 1, this.y);
    rotationPositions[1][1] = new Position(this.x + 1, this.y);
    rotationPositions[1][2] = new Position(this.x + 1, this.y - 1);

    rotationPositions[2][0] = new Position(this.x, this.y - 1);
    rotationPositions[2][1] = new Position(this.x, this.y + 1);
    rotationPositions[2][2] = new Position(this.x + 1, this.y + 1);

    rotationPositions[3][0] = new Position(this.x + 1, this.y);
    rotationPositions[3][1] = new Position(this.x - 1, this.y);
    rotationPositions[3][2] = new Position(this.x - 1, this.y + 1);

    return rotationPositions;
  }
}
