package Main;

import javax.swing.*;

import controller.GameTypeController;
import tetrisModel.ITetrisModel;
import tetrisModel.TetrisModel;
import view.ITetrisView;
import view.TetrisHomeView;

public final class Main {
  static ITetrisView view;
  static JFrame frame;

  public static void main(String[] args) {

//    view = new TetrisHomeView("hi");
//    GameTypeController controller = new GameTypeController(25, view);
//    controller.run(10000);

//

    ITetrisModel model = new TetrisModel(10, 18, 10);
    view = new TetrisHomeView("Casual");
    GameTypeController controller = new GameTypeController(25, view);
    controller.run(10000);

  }

//  private static final class Builder {
//
//    private int boardWidth;
//    private int boardHeight;
//    private int level;
//    private String boardType;
//
//    private Builder(String boardType, int boardWidth, int boardHeight, int level) {
//      if (boardType.equals("Casual")) {
//        this.boardType = "Casual";
//        this.boardWidth = boardWidth;
//        this.boardHeight = boardHeight;
//        this.level = 1;
//      } else {
//        if (boardType.equals("Levels")) {
//          this.boardType = "Levels";
//          this.boardWidth = boardWidth;
//          this.boardHeight = boardHeight;
//          this.level = level;
//        } else {
//            throw new IllegalArgumentException("need a board type");
//          }
//        }
//      }
//
//
//    private ITetrisModel build() {
//      if (this.boardType.equals("Causal")) {
//        return new TetrisModel(this.boardWidth, this.boardHeight, this.level);
//      } else {
//        if (this.boardType.equals("european")) {
//          return new EuropeanSolitaireModelImpl(this.armLength, this.sRow, this.sCol);
//        } else {
//          if (this.boardType.equals("triangle")) {
//            return new TriangleSolitaireModelImpl(this.armLength, this.sRow, this.sCol);
//          } else {
//            throw new IllegalStateException("need a board type");
//          }
//        }
//      }
//    }
//
//    private Builder setArmLength(int armLength) {
//      this.armLength = armLength;
//      return this;
//    }
//
//    private Builder setSRow(int sRow) {
//      this.sRow = sRow;
//      return this;
//    }
//
//    private Builder setSCol(int sCol) {
//      this.sCol = sCol;
//      return this;
//    }
//  }
}