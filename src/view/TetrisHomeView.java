package view;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;

import tetrisModel.ITetrisModel;
import tetrisShapes.LeftLShape;

public class TetrisHomeView extends JFrame implements ITetrisView {
      GameTypePanel gameTypePanel;
      CreateGamePanel createGamePanel;
      JLabel TitlePanel;
      ImageIcon imageIcon;



      public TetrisHomeView(String type) {
        super();
        this.setLayout(new FlowLayout());
        this.createGamePanel = new CreateGamePanel();
        this.gameTypePanel = new GameTypePanel();
        imageIcon = new ImageIcon("src/TetrisTitle.png"); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(395, 200,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        imageIcon = new ImageIcon(newimg);
        TitlePanel = new JLabel(imageIcon);
  }

  @Override
  public void setVisible(boolean b) {
    super.setVisible(b);
  }

  @Override
  public void setListeners(ActionListener clicks) {
    gameTypePanel.setListeners(clicks);
    createGamePanel.setListeners(clicks);
  }

  @Override
  public void drawTime() {
//    this.setVisible(true);
//    mainPanel.setVisible(true);
//    nextShapesPanel.setVisible(true);
//    mainPanel.repaint();
//    nextShapesPanel.repaint();
  }

  @Override
  public TetrisMainPanel getMainPanel() {
    return null;
  }

  @Override
  public void addKeyBinding(JComponent comp, int keyCode, String id, ActionListener listener) {

  }

  @Override
  public JLabel getLinesLabel() {
    return null;
  }

  @Override
  public JLabel getLevelLabel() {
    return null;
  }


  public void run(ITetrisModel model, int speed) {
    ITetrisModel m = model;
    this.setTitle("Tetris!");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
    this.setSize(new Dimension(395, 472));
    this.getContentPane().setBackground(Color.BLACK);
    this.add(TitlePanel);
    this.add(gameTypePanel.getPanel());
    this.add(createGamePanel.getPanel());
    System.out.print("run");

  }

  public void addd(JPanel pan) {
    this.add(pan);
  }

  public void viewCreateGamePanel() {
    createGamePanel.getPanel().setVisible(true);
    createGamePanel.getPanel().setPreferredSize(new Dimension(200, 200));
    System.out.print(createGamePanel.getPanel().getWidth());
  }

  public void unviewCreateGamePanel() {
    createGamePanel.getPanel().setVisible(false);
    createGamePanel.getPanel().setPreferredSize(new Dimension(200, 200));
  }

  public void viewGameTypePanel() {
    gameTypePanel.getPanel().setVisible(true);
    gameTypePanel.getPanel().setPreferredSize(new Dimension(200, 200));
  }

  public void unviewGameTypePanel() {
    gameTypePanel.getPanel().setVisible(false);
    gameTypePanel.getPanel().setPreferredSize(new Dimension(200, 200));
  }

  @Override
  public void viewMainGamePanel() {
  }

  @Override
  public void setEditableText() {
    createGamePanel.setEditableText();
  }

  @Override
  public void unsetEditableText() {
    createGamePanel.unsetEditableText();
  }

  @Override
  public void addLevelOption() {
    createGamePanel.addLevelsOption();
  }

  @Override
  public void resetTexts() {
    createGamePanel.resetTexts();
  }

  @Override
  public void resetSelection() {
    createGamePanel.resetSelection();
  }

  @Override
  public boolean isDefaultButtonSelected() {
    return createGamePanel.isDefaultGameSelected();
  }

  @Override
  public void setGameType(String s) {
    this.createGamePanel.setGameType(s);
  }

  @Override
  public String getRowValue() {
    return createGamePanel.getRowsValue();
  }

  @Override
  public String getColumnValue() {
    return createGamePanel.getColumnValue();
  }

  @Override
  public String getLevelValue() {
    return createGamePanel.getLevelsValue();
  }

  @Override
  public String getGameType() {
    return this.createGamePanel.getGameType();
  }

  @Override
  public void unviewHome() {
        this.setVisible(false);
  }
}

