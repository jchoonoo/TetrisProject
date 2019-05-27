package controller;

import org.omg.CORBA.Current;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;


import javax.swing.*;

import tetrisModel.ITetrisModel;
import tetrisModel.TetrisModel;
import view.ITetrisView;
import view.TetrisView;

public class GameTypeController implements IController, ActionListener {

  ITetrisModel model;
  ITetrisView view;
  IController controller;
  ITetrisView createGameView;


  public GameTypeController(int speed, ITetrisView view) {
    this.view = view;
    view.setListeners(this);



    //// *** starting level is level 1, at 325 delay then you add 25 every level until level 10 and u stop increasing speed at 100
    //use some kind of counter where if counter = x do it and if not add 1
    // ***** EDIT - use a counter - ex if counter = 20 do x, to increase speed or decrease speed write a method that takes in an int
    // and then changes the base counter value to = 19 and make the count = 19 --- this is the idea tweak it though because it wont work
  }
  @Override
  public void actionPerformed(ActionEvent e) {
    switch (e.getActionCommand()) {
      case "CasualPlay":
        controller = new CreateGameController(view);
        view.viewCreateGamePanel();
        view.unviewGameTypePanel();
        view.setGameType("casual");
        break;
      case "Levels":
        controller = new CreateGameController(view);
        view.viewCreateGamePanel();
        view.unviewGameTypePanel();
        view.addLevelOption();
        view.setGameType("levels");
        break;
      }
    }



  public void run(int speed) {
    view.run(model, speed);
//    timer.start();
  }
}
