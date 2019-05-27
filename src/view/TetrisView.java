package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.border.Border;

import tetrisModel.ITetrisModel;

public class TetrisView extends JFrame implements ITetrisView {
JButton startButton;
JButton pauseButton;
JButton resumeButton;
JButton quitButton;
JButton increaseButton;
JButton decreaseButton;
  JButton sizeButton;
String UP;
String LEFT;
String RIGHT;
String DOWN;
JPanel p;
JPanel main;
JLabel lines;
JLabel level;
String type;


public TetrisMainPanel mainPanel;
public TetrisNextShapesPanel nextShapesPanel;

ITetrisModel model;

public TetrisView(String type) {
  super();
  this.type = type;
  this.setLayout(new BorderLayout());
  p = new JPanel();
  mainPanel = new TetrisMainPanel(model);
  nextShapesPanel = new TetrisNextShapesPanel(model);
  p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
  this.UP = "rotate";
  this.LEFT = "left";
  this.RIGHT = "right";
  this.DOWN = "down";
//  main = new TetrisHomeView("casual");
  //this.add(j, BorderLayout.CENTER);
  // mainPanel.getPreferredSize();
  // mainPanel.setFocusable(true);

  startButton = new JButton("start");
  startButton.setActionCommand("start");
  p.add(startButton);

  //pause button
  pauseButton = new JButton("pause");
  pauseButton.setActionCommand("pause");
  p.add(pauseButton);

  //pause button
  sizeButton = new JButton("size");
  sizeButton.setActionCommand("size");
  p.add(sizeButton);

  //pause button
  resumeButton = new JButton("resume");
  resumeButton.setActionCommand("resume");
  p.add(resumeButton);

  //quit button
  quitButton = new JButton("quit");
  quitButton.setActionCommand("quit");
  p.add(quitButton);

  if (type.equals("Casual")) {
    //increase speed button
    increaseButton = new JButton("increase speed");
    increaseButton.setActionCommand("increase speed");
    p.add(increaseButton);

    //decrease speed button
    decreaseButton = new JButton("decrease speed");
    decreaseButton.setActionCommand("decrease speed");
    p.add(decreaseButton);
  }
  this.add(p, BorderLayout.LINE_END);
}

  @Override
  public void setVisible(boolean b) {
    super.setVisible(b);
  }

  @Override
  public void setListeners(ActionListener clicks) {
    this.startButton.addActionListener(clicks);
    this.pauseButton.addActionListener(clicks);
    this.resumeButton.addActionListener(clicks);
    this.quitButton.addActionListener(clicks);
    this.sizeButton.addActionListener(clicks);
    if(this.type.equals("Casual")) {
      this.increaseButton.addActionListener(clicks);
      this.decreaseButton.addActionListener(clicks);
    }
  }

//  public void setKeyListeners(KeyListener press) {
//    mainPanel.addKeyListener(press);
//  }

//  @Override
////  public void draw() {
////    this.setVisible(true);
////    TetrisMainPanel.setVisible(true);
////  }

  @Override
  public void drawTime() {
    this.setVisible(true);
    mainPanel.setVisible(true);
    nextShapesPanel.setVisible(true);
    mainPanel.repaint();
    nextShapesPanel.repaint();
  }

  @Override
  public TetrisMainPanel getMainPanel() {
    return this.mainPanel;
  }

  public void addKeyBinding(JComponent comp, int keyCode, String id, ActionListener listener) {
    InputMap im = comp.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
    im.put(KeyStroke.getKeyStroke(keyCode, 0), id);
    ActionMap ap = comp.getActionMap();
    ap.put(id, new AbstractAction() {
      @Override
      public void actionPerformed(ActionEvent e) {
        listener.actionPerformed(e);
      }}
    );
  }

  @Override
  public JLabel getLinesLabel() {
    return lines;
  }

  @Override
  public JLabel getLevelLabel() {
    return level;
  }

  public void run(ITetrisModel model, int speed) {
  ITetrisModel m = model;
  mainPanel = new TetrisMainPanel(m);
  nextShapesPanel = new TetrisNextShapesPanel(m);
    lines = new JLabel("Line Count: " + Integer.toString(model.getLineCount()), JLabel.CENTER);
    lines.setBackground(Color.BLACK);
    lines.setForeground(Color.white);
    p.add(nextShapesPanel);
    nextShapesPanel.getPreferredSize();
    p.add(lines);
    if(this.type.equals("Levels")) {
      level = new JLabel("Level: " + Integer.toString(model.getLevel()), JLabel.CENTER);
      level.setForeground(Color.white);
      level.setBackground(Color.BLACK);
      p.add(level);
    }
  this.setTitle("Tetris!");
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  this.setVisible(true);
  p.setBackground(Color.BLACK);
  //p.setPreferredSize(new Dimension(140, 100));
  this.setResizable(false);
  this.add(mainPanel, BorderLayout.CENTER);
  this.pack();
//  System.out.print(main.getHeight());

  ////// yellow shape does not move left ---- can rotate and then it moves left ----
}

@Override
  public String getGameType() {
  return this.type;
}

  @Override
  public void viewCreateGamePanel() {

  }

  @Override
  public void unviewCreateGamePanel() {

  }

  @Override
  public void viewGameTypePanel() {

  }

  @Override
  public void unviewGameTypePanel() {

  }

  @Override
  public void viewMainGamePanel() {

  }

  @Override
  public void setEditableText() {

  }

  @Override
  public void unsetEditableText() {

  }

  @Override
  public void addLevelOption() {

  }

  @Override
  public void resetTexts() {

  }

  @Override
  public void resetSelection() {

  }

  @Override
  public boolean isDefaultButtonSelected() {
    return false;
  }

  @Override
  public void setGameType(String s) {

  }

  @Override
  public String getRowValue() {
    return null;
  }

  @Override
  public String getColumnValue() {
    return null;
  }

  @Override
  public String getLevelValue() {
    return null;
  }

  @Override
  public void unviewHome() {
    this.setVisible(false);
  }


}
