package tetrisModel;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

import tetrisShapes.ITetrisShape;
import tetrisShapes.LeftLShape;
import tetrisShapes.LeftZigSag;
import tetrisShapes.LineShape;
import tetrisShapes.RightLShape;
import tetrisShapes.RightZigSag;
import tetrisShapes.SquareShape;
import tetrisShapes.TriangleShape;
import utils.GridCell;
import utils.Position;
import utils.ShapeCell;
import view.TetrisNextShapesPanel;

public class TetrisModel implements ITetrisModel {
  public int boardWidth;
  public int boardHeight;
  public GridCell[][] board;
  public List<ShapeCell> CellsOnBoard;
  private List<ITetrisShape> nextShapes;
  private List<ITetrisShape> duplicateNextShapes;
  public ITetrisShape currentShape;
  private ShapeCell[] listOfJustLandedCells;
  public GridCell[][] nextShapesBoard;
  public int lineCount;
  public int level;


  /**
   * @param boardWidth    represents the width the board
   * @param boardHeight   represents the height of the board
   * board                represents every cell on the board (grid cell or shape cell)
   * CellsOnBoard         represents the list of shape cells on the board
   * nextShapes           represents the next two shapes waiting to fall
   * currentShape         represents the current falling shape
   * listOfJustLandedCell represents the cells/shapes that have just landed
   *
   */


  /**
   * creates a {@code TetrisModel} object
   * @param boardWidth the width of the board
   * @param boardHeight the height of the board
   */
  public TetrisModel(int boardWidth, int boardHeight) {
    this.init(boardWidth, boardHeight, 1);
  }

  public TetrisModel(int boardWidth, int boardHeight, int level) {
    this.init(boardWidth, boardHeight, level);
  }

  void init(int boardWidth, int boardHeight, int level) {
    if (boardWidth < 10 || boardHeight < 10) {
      throw new IllegalArgumentException("need a reasonable size of board, greater than 10 x 10");
    }
    if (level <= 0) {
      throw new IllegalArgumentException("no level less than 1");
    }
    this.boardWidth = boardWidth;
    this.boardHeight = boardHeight;
    this.board = new GridCell[boardWidth][boardHeight];
    this.nextShapesBoard = new GridCell[8][6];
    this.listOfJustLandedCells = new ShapeCell[4];
    this.createBoard(this.board);
    this.createBoard(this.nextShapesBoard);
    this.CellsOnBoard = new ArrayList<ShapeCell>();
    this.nextShapes = new ArrayList<ITetrisShape>();
    this.duplicateNextShapes = new ArrayList<ITetrisShape>();
    this.nextShapes.add(this.randomShape());
    this.nextShapes.add(this.randomShape());
    this.duplicateNextShapes.add(nextShapes.get(0).duplicate());
    this.setMainShapes(this.randomShape());
    this.setNextShapes(this.duplicateNextShapes.get(0));
    this.lineCount = 0;
    this.level = level;
  }

  /**
   * sets the next shape waiting to fall to be the current shape
   * @param s   the next tetris shape
   */
  private void setMainShapes(ITetrisShape s) {
    int middleX = boardWidth / 2;
    int topY = 0;
    this.currentShape = s;
    Hashtable<String, GridCell[]> startingCells = new Hashtable<String, GridCell[]>();
    startingCells.put("LeftLShape", new GridCell[]{board[middleX - 1][topY + 1], board[middleX - 1][topY], board[middleX][topY], board[middleX + 1][topY]});
    startingCells.put("LeftZigSag", new GridCell[]{board[middleX - 1][topY], board[middleX][topY], board[middleX][topY + 1], board[middleX + 1][topY + 1]});
    startingCells.put("LineShape", new GridCell[]{board[middleX - 1][topY], board[middleX][topY], board[middleX + 1][topY], board[middleX + 2][topY]});
    startingCells.put("RightLShape", new GridCell[]{board[middleX - 1][topY], board[middleX][topY], board[middleX + 1][topY], board[middleX + 1][topY + 1]});
    startingCells.put("RightZigZag", new GridCell[]{board[middleX - 1][topY + 1], board[middleX][topY + 1], board[middleX][topY], board[middleX + 1][topY]});
    startingCells.put("SquareShape", new GridCell[]{board[middleX - 1][topY], board[middleX][topY], board[middleX - 1][topY + 1], board[middleX][topY + 1]});
    startingCells.put("TriangleShape", new GridCell[]{board[middleX - 1][topY], board[middleX][topY], board[middleX][topY + 1], board[middleX + 1][topY]});
    s.setCells(startingCells.get(s.getShapeName()));
    for (ShapeCell s1 : s.getCells()) {
      board[s1.getX()][s1.getY()].setShapeCell(s1);
    }
    for (ShapeCell cell : s.getCells()) {
      this.CellsOnBoard.add(cell);
    }
  }

  private void setNextShapes(ITetrisShape s) {
    int middleX = nextShapesBoard.length / 2;
    int topY = 0;
    Hashtable<String, GridCell[]> startingCells = new Hashtable<String, GridCell[]>();
    startingCells.put("LeftLShape", new GridCell[]{nextShapesBoard[middleX + 2][topY + 2], nextShapesBoard[middleX + 1][topY + 2], nextShapesBoard[middleX][topY + 2], nextShapesBoard[middleX][topY + 3]});
    startingCells.put("LeftZigSag", new GridCell[]{nextShapesBoard[middleX][topY + 2], nextShapesBoard[middleX + 1][topY + 2], nextShapesBoard[middleX + 1][topY + 3], nextShapesBoard[middleX + 2][topY + 3]});
    startingCells.put("LineShape", new GridCell[]{nextShapesBoard[middleX - 1][topY + 3], nextShapesBoard[middleX][topY + 3], nextShapesBoard[middleX + 1][topY + 3], nextShapesBoard[middleX + 2][topY + 3]});
    startingCells.put("RightLShape", new GridCell[]{nextShapesBoard[middleX][topY + 2], nextShapesBoard[middleX + 1][topY + 2], nextShapesBoard[middleX + 2][topY + 2], nextShapesBoard[middleX + 2][topY + 3]});
    startingCells.put("RightZigZag", new GridCell[]{nextShapesBoard[middleX][topY + 3], nextShapesBoard[middleX + 1][topY + 3], nextShapesBoard[middleX + 1][topY + 2], nextShapesBoard[middleX + 2][topY + 2]});
    startingCells.put("SquareShape", new GridCell[]{nextShapesBoard[middleX][topY + 2], nextShapesBoard[middleX][topY + 3], nextShapesBoard[middleX + 1][topY + 2], nextShapesBoard[middleX + 1][topY + 3]});
    startingCells.put("TriangleShape", new GridCell[]{nextShapesBoard[middleX][topY + 2], nextShapesBoard[middleX + 1][topY + 2], nextShapesBoard[middleX + 1][topY + 3], nextShapesBoard[middleX + 2][topY + 2]});
    s.setCells(startingCells.get(s.getShapeName()));
    for (ShapeCell s1 : s.getCells()) {
      nextShapesBoard[s1.getX()][s1.getY()].setShapeCell(s1);
    }
  }

  /**
   * creates a new random shape to add to the list of shapes waiting to fall
   * @return a new tetris shape
   */
  private ITetrisShape randomShape() {
    Random generator = new Random();
    int randomShape = generator.nextInt(7) + 1;

    switch (randomShape) {
      case 1:
        return new LeftLShape();
      case 2:
        return new LeftZigSag();
      case 3:
        return new LineShape();
      case 4:
        return new RightLShape();
      case 5:
        return new RightZigSag();
      case 6:
        return new SquareShape();
      case 7:
        return new TriangleShape();
      default:
        //throw new IOException("cannot retrieve random shape");
        throw new IllegalArgumentException("h");
    }
  }

  @Override
  public void rotate() {
    switch (currentShape.getRotation()) {
      case 1:
        if(this.validRotation(0)) {
          this.revertGridCells();
          currentShape.rotate();
          this.setShapeCells();
        }
        break;
      case 2:
        if(this.validRotation(1)) {
          this.revertGridCells();
          currentShape.rotate();
          this.setShapeCells();
        }
        break;
      case 3:
        if(this.validRotation(2)) {
          this.revertGridCells();
          currentShape.rotate();
          this.setShapeCells();
        }
        break;
      case 4:
        if(this.validRotation(3)) {
          this.revertGridCells();
          currentShape.rotate();
          this.setShapeCells();
        }
        break;
      default:
        throw new IllegalArgumentException("need a valid rotation number");
    }
  }

  @Override
  public int getWidth() {
    return this.boardWidth;
  }

  @Override
  public int getHeight() {
    return this.boardHeight;
  }

  @Override
  public ITetrisShape getCurrent() {
    return this.currentShape;
  }

  @Override
  public GridCell getCells(int x, int y) {
    return board[x][y];
  }

  @Override
  public List<ShapeCell> getCellsOnBoard() {
    return this.CellsOnBoard;
  }

  @Override
  public boolean isGameOver() {
    for (ShapeCell c : this.getCellsOnBoard()) {
      if (c.getY() == 0 && c.isLanded()) {
        return true;
      }
    }
    return false;
  }

  @Override
  public List<ITetrisShape> getDupNextShapes() {
    return this.duplicateNextShapes;
  }

  /**
   * checks if the next rotation is a valid move
   * @param i the rotation number
   * @return is the rotation valid or not
   */
  private boolean validRotation(int i) {
    boolean validRotation = true;
    for (Position pos : this.currentShape.rotationPositions()[i]) {
      if (!this.isWithinBounds(pos.getX(), pos.getY()) || (board[pos.getX()][pos.getY()].hasShapeCell())) {
        validRotation = false;
      }
    } return validRotation;
  }


  /**
   *  removes the full lines of cells on the board
   * @param filledLines     the list of the row number that represents the rows that have full lines
   */
  private void removeLine(ArrayList<Integer> filledLines) {
    if(filledLines.size() == 0) {
      return;
    }
      for (int j : filledLines) {
        for (int i = 0; i < boardWidth; i++) {
          CellsOnBoard.remove(board[i][j].getShapeCell());
          board[i][j].revertGridCell();
        }
        lineCount = lineCount + 1;
        this.nextLevel();
        this.moveCellsDown(j);
        }
      }


  /** potential problem is that this only moves cells down starting from the row moving down, does not make the rest of
   * the cells above move down
   *
   * @param removedLineRow    the starting row number to move cells down
   */
  private void moveCellsDown(int removedLineRow) {
      for (int i = 0; i < boardWidth; i++) {
          for (int j = removedLineRow; j > -1; j--) {
              ShapeCell current = board[i][j].getShapeCell();
              if (board[i][j].hasShapeCell()) {
                current.setY(current.getY() + 1);
                board[i][j + 1].setShapeCell(current);
                board[i][j].revertGridCell();
              }
            }
          }
}

  /**
   * checks if the move is valid
   * @param x the number of cells to move the x coordinate
   * @param y the number of cells to move the y coordinate
   * @param side the direction of the movement
   * @return is the move valid
   */
  private boolean isMoveValid(int x, int y, String side) {
    for(ShapeCell s:currentShape.sidePositions(side)) {
      // this is whats fucking it up
      // its the side positions thats fucking it up
      if(!this.isWithinBounds(s.getX() + x, s.getY() + y)
             || (board[s.getX() + x][s.getY() + y].hasShapeCell())) {
        return false;
      }
    } return true;
}


@Override
  public void move(String direction) {
    if (direction.equals("down")) {
      if(this.isMoveValid(0, 1, direction)) {
        this.revertGridCells();
        currentShape.moveDown();
        this.setShapeCells();
      } else {
        this.setShapeCells();
        this.landShape();
        listOfJustLandedCells = currentShape.getCells();
        this.removeLine(this.isLineFilled());
        this.setMainShapes(nextShapes.get(0));
        nextShapes.remove(nextShapes.get(0));
        nextShapes.add(this.randomShape());
        this.duplicateNextShapes.remove(this.duplicateNextShapes.get(0));
        this.duplicateNextShapes.add(nextShapes.get(0).duplicate());
        this.setNextShapes(this.duplicateNextShapes.get(0));
   //     System.out.print(this.duplicateNextShapes.get(0));
        this.removeLine(this.isLineFilled());
      }

    }
    if (direction.equals("left")) {
     if(this.isMoveValid(-1, 0, direction)) {
        this.revertGridCells();
        currentShape.moveLeft();
        this.setShapeCells();
      }
    }
    if (direction.equals("right")) {
      if (this.isMoveValid(1, 0, direction)) {
        this.revertGridCells();
        currentShape.moveRight();
        this.setShapeCells();
      }
    }
  }

  /**
   * creates the array of array for board
   */
  private void createBoard(GridCell[][] boardtype) {
    for (int i = 0; i < boardtype.length; i++) {
      for (int j = 0; j < boardtype[i].length; j++) {
        boardtype[i][j] = new GridCell(i, j);
      }
    }
  }

  /**
   * draws the board
   * @return a string representing the board ofr testing
   */
  public String drawBoard() {
    StringBuilder local = new StringBuilder();
    for (int i = 0; i < this.boardHeight; i++) {
      for (int j = 0; j < this.boardWidth; j++) {
        if (board[j][i].hasShapeCell()) {
          local.append("O ");
          if (j == this.boardWidth - 1) {
            local.append("\n");
          }
        } else {
          local.append("_ ");
          if (j == this.boardWidth - 1) {
            local.append("\n");
          }
        }
      }
    }
    return local.toString();
  }

  /**
   * checks if the x and y coordinate are in the bounds of the board
   * @param x x coorindate of shape
   * @param y y coordinate of shape
   * @return returns a boolean
   */
  private boolean isWithinBounds(int x, int y) {
    return x < boardWidth && y < boardHeight && x >= 0 && y >= 0;
  }

  /**
   * checks which lines are filled
   * @return returns a list of row numbers of filled rows sorted
   */
  private ArrayList<Integer> isLineFilled() {
    ArrayList<Integer> filledLines = new ArrayList<Integer>();
    for (int i = 0; i < listOfJustLandedCells.length; i++) {
      if (this.isEveryCellInThisLineFilled(i)) {
        if (!filledLines.contains(listOfJustLandedCells[i].getY())) {
          filledLines.add(listOfJustLandedCells[i].getY());
        }
      }
      }
      Collections.sort(filledLines);
      return filledLines;
  }

  /**
   * checks if every cell in the row is a shape cell
   * @param i the row to check
   * @return a boolean checking if the number of filled cells in the row equals the board width
   */
  private boolean isEveryCellInThisLineFilled(int i) {
    int filledCells = 0;
      for (int j = 0; j < boardWidth; j++) {
        if (board[j][listOfJustLandedCells[i].getY()].hasShapeCell()) {
          filledCells = filledCells + 1;
        }
      }
    return filledCells == boardWidth;
  }

  /**
   * sets the current shape's cells on the board
   */
  private void setShapeCells() {
    for (ShapeCell s : currentShape.getCells()) {
      board[s.getX()][s.getY()].setShapeCell(s);
    }
  }

  /**
   * changes the grid cell's shape cell back to null
   */
  private void revertGridCells() {
    for (ShapeCell s : currentShape.getCells()) {
      board[s.getX()][s.getY()].revertGridCell();
    }
  }

  private void landShape() {
    for(ShapeCell c:currentShape.getCells()) {
      c.setLanded();
    }
  }

  public int getLineCount() {
    return this.lineCount;
  }

  public void nextLevel() {
    if(this.lineCount % 10 == 0) {
      this.level = level + 1;
    }
  }

  public int getLevel() {
    return this.level;
  }

  public void restartGame() {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        board[i][j].revertGridCell();
      }
    }
    this.CellsOnBoard.clear();
    this.listOfJustLandedCells = new ShapeCell[4];
    this.setMainShapes(this.randomShape());
    this.setNextShapes(this.duplicateNextShapes.get(0));
    this.lineCount = 0;
    this.level = 1;
    for (int i = 0; i < nextShapesBoard.length; i++) {
      for(int j = 0; j < nextShapesBoard[i].length; j++) {
        nextShapesBoard[i][j].revertGridCell();
        }
    }
  }

  @Override
  public void setSize(int width, int height) {
    this.restartGame();
    this.boardWidth = width;
    this.boardHeight = height;
    board = new GridCell[width][height];
    this.createBoard(board);
  }
}


