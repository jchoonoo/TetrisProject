package view;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

import tetrisModel.ITetrisModel;

public class CreateGamePanel {
    JPanel optionsPanel;
  JTextField rows;
  JTextField columns;
  JTextField levels;
  JRadioButton defaultGame;
  JRadioButton customize;
  JLabel rowsLabel;
  JLabel columnsLabel;
  JLabel levelsLabel;
  JButton startButton;
  JButton backButton;
  ButtonGroup options;
  String rowsValue;
  String columnsValue;
  String levelsValue;
  String gameType;

    public CreateGamePanel() {
      super();
      optionsPanel = new JPanel();
      optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.Y_AXIS));

      defaultGame = new JRadioButton("default game");
      defaultGame.setForeground(Color.white);
      defaultGame.setActionCommand("default");
      optionsPanel.add(defaultGame);

      customize = new JRadioButton("customize");
      customize.setForeground(Color.WHITE);
      customize.setActionCommand("customize");
      optionsPanel.add(customize);

      rowsLabel = new JLabel("rows");
      rowsLabel.setForeground(Color.WHITE);
      rowsLabel.setLabelFor(rows);
      optionsPanel.add(rowsLabel);

      rows = new JTextField();
      optionsPanel.add(rows);
      rows.setColumns(1);

      columnsLabel = new JLabel("columns");
      columnsLabel.setForeground(Color.WHITE);
      columnsLabel.setLabelFor(columns);
      optionsPanel.add(columnsLabel);

      columns = new JTextField();
      optionsPanel.add(columns);
      columns.setColumns(1);

      levelsLabel = new JLabel("level");
      levelsLabel.setForeground(Color.WHITE);
      levelsLabel.setLabelFor(levels);

      levels = new JTextField();
      levels.setColumns(1);

      this.unsetEditableText();

      options = new ButtonGroup();
      options.add(defaultGame);
      options.add(customize);

      startButton = new JButton("Start Button");
      startButton.setActionCommand("start");
      optionsPanel.add(startButton);

      backButton = new JButton("Back");
      backButton.setActionCommand("back");
      optionsPanel.add(backButton);


      optionsPanel.setBackground(Color.BLACK);
      optionsPanel.setVisible(false);
    }

  public void setListeners(ActionListener clicks) {
    this.defaultGame.addActionListener(clicks);
    this.customize.addActionListener(clicks);
    this.startButton.addActionListener(clicks);
    this.backButton.addActionListener(clicks);
  }

  public JPanel getPanel() {
      return this.optionsPanel;
  }

  public void setEditableText() {
      rows.setEditable(true);
      columns.setEditable(true);
      levels.setEditable(true);
  }

  public void unsetEditableText() {
    rows.setEditable(false);
    columns.setEditable(false);
    levels.setEditable(false);
  }

  public void addLevelsOption() {
    optionsPanel.add(levelsLabel);
    optionsPanel.add(levels);
  }

  public void resetTexts() {
      rows.setText("");
      columns.setText("");
      levels.setText("");
  }

  public void resetSelection() {
    options.clearSelection();
  }

  public String getRowsValue() {
      return rows.getText();
  }

  public String getColumnValue() {
    return columns.getText();
  }

  public String getLevelsValue() {
    return levels.getText();
  }

  public boolean isDefaultGameSelected() {
      return defaultGame.isSelected();
  }

  public void setGameType(String s) {
      this.gameType = s;
  }

  public String getGameType() {
      return this.gameType;
  }
}
