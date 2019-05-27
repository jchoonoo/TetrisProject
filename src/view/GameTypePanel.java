package view;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GameTypePanel {

  JPanel optionsPanel;
  JButton CasualPlayButton;
  JButton LevelsButton;

    public GameTypePanel() {
      super();
      optionsPanel = new JPanel();
      optionsPanel.setLayout(new FlowLayout());

      CasualPlayButton = new JButton("CasualPlay");
      CasualPlayButton.setActionCommand("CasualPlay");
      optionsPanel.add(CasualPlayButton);

      //pause button
      LevelsButton = new JButton("Levels");
      LevelsButton.setActionCommand("Levels");
      optionsPanel.add(LevelsButton);

      optionsPanel.setBackground(Color.BLACK);
      optionsPanel.setVisible(true);
    }

    public void setListeners(ActionListener clicks) {
      this.LevelsButton.addActionListener(clicks);
      this.CasualPlayButton.addActionListener(clicks);
    }

    public JPanel getPanel() {
      return this.optionsPanel;
    }

}
