package view;

import java.awt.*;

import javax.swing.*;

import tetrisModel.ITetrisModel;
import utils.ShapeCell;


public class TetrisMainPanel extends JPanel {
  ITetrisModel model;
  int width;
  int height;
  int rows;
  int columns;
  public TetrisMainPanel(ITetrisModel model) {
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
    this.width = model.getWidth() * 25;
    this.height = model.getHeight() * 25;
    this.rows = model.getWidth();
    this.columns = model.getHeight();
    int rowHeight = height / columns;
    int rowWidth = width / rows;
    g2d.setColor(Color.DARK_GRAY);

    for(int i = 0; i <= columns; i++) {
      g2d.drawLine(0, i * rowHeight, width, i * rowHeight);
    }

    for(int i = 0; i <= rows; i++) {
      g2d.drawLine(i * rowWidth, 0,i * rowWidth, height);
    }

    Stroke stroke1 = new BasicStroke(1F);
    for(ShapeCell c: model.getCellsOnBoard()) {
      g2d.setColor(Color.BLACK);
      g2d.setStroke(stroke1);
      //g2d.setColor(c.getColor());
          g2d.drawRect(c.getX() * 25, c.getY() * 25,25,25);
          g2d.setColor(c.getColor());
          g2d.fillRect(c.getX() * 25, c.getY() * 25,25,25);
    }
  }

  /**
   * Sets the dimension to the canvas's height and width.
   *
   * @return the dimension
   */
  @Override
  public Dimension getPreferredSize() {
    return new Dimension(model.getWidth() * 25, model.getHeight() * 25);
  }
}
