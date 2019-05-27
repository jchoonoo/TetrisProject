package view;

import java.awt.*;

import javax.swing.*;

import tetrisModel.ITetrisModel;
import tetrisShapes.ITetrisShape;
import utils.ShapeCell;

public class TetrisNextShapesPanel extends JPanel {
  ITetrisModel model;
  int width;
  int height;
  int rows;
  int columns;
  ITetrisShape nextShape;
  public TetrisNextShapesPanel(ITetrisModel model) {
    super();
    this.model = model;
    this.setBackground(Color.BLACK);
  }


  /**
   * Draws the shapes at a certain position and with a certain color and size.
   *
   * @param g the graphics passed in
   */
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
 //    System.out.print(this.model);
    this.width = 130;
    this.height = 100;
    this.rows = 8;
    this.columns = 6;
    int rowHeight = (height - 10) / columns;
    int rowWidth = (width - 10) / rows;
    nextShape = model.getDupNextShapes().get(0);
   // System.out.print(nextShape);
    g2d.setColor(Color.DARK_GRAY);

//    for (int i = 0; i <= columns; i++) {
//      g2d.drawLine(10, i * rowHeight + 50, width, i * rowHeight + 50);
//    }
//
//    for (int i = 0; i <= rows; i++) {
//      g2d.drawLine(i * rowWidth + 10, 50, i * rowWidth + 10, height + 40);
//    }

    for(int i = 0; i <= columns; i++) {
      g2d.drawLine(0 + 10, i * rowHeight + 50, width, i * rowHeight + 50);
    }

    for(int i = 0; i <= rows; i++) {
      g2d.drawLine(i * rowWidth + 10, 0 + 50,i * rowWidth + 10, height - 10 + 50);
    }

    Stroke stroke1 = new BasicStroke(1F);
    for (ShapeCell c : nextShape.getCells()) {
      g2d.setColor(Color.BLACK);
      g2d.setStroke(stroke1);
      g2d.drawRect(c.getX() * 15 - 10 + 5, c.getY() * 15 - 10 + 10 + 50, 15, 15);
      g2d.setColor(c.getColor());
      g2d.fillRect(c.getX() * 15 - 10 + 5, c.getY() * 15 - 10 + 10 + 50, 15, 15);
    }
  }
//    Stroke stroke1 = new BasicStroke(1F);
//    for(ShapeCell c: model.getCellsOnBoard()) {
//      g2d.setColor(Color.BLACK);
//      g2d.setStroke(stroke1);
//      //g2d.setColor(c.getColor());

//    }
//  }
}
