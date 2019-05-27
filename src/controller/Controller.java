package controller;

import org.omg.CORBA.Current;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;


import javax.swing.*;

import tetrisModel.ITetrisModel;
import view.ITetrisView;

public class Controller implements  IController, ActionListener {

  ITetrisModel model;
  Timer timer;
  boolean paused;
  int speed;
  ITetrisView view;
  int delayCountTarget;
  int delayCount;
  int CurrentLevel;


public Controller(int speed, ITetrisView view, ITetrisModel model) {
  this.view = view;
  view.setListeners(this);
  this.timer = new Timer(25, this);
  timer.setActionCommand("down");
  this.model = model;
  this.paused = true;
  this.speed = speed;
  this.delayCount = 0;
  this.CurrentLevel = model.getLevel();
  this.delayCountTarget = 13 - model.getLevel();



  //// *** starting level is level 1, at 325 delay then you add 25 every level until level 10 and u stop increasing speed at 100
  //use some kind of counter where if counter = x do it and if not add 1
  // ***** EDIT - use a counter - ex if counter = 20 do x, to increase speed or decrease speed write a method that takes in an int
  // and then changes the base counter value to = 19 and make the count = 19 --- this is the idea tweak it though because it wont work
}
  @Override
  public void actionPerformed(ActionEvent e) {
    switch (e.getActionCommand()) {
      case "down":
        view.drawTime();
        if(!paused) {
          if (delayCount == delayCountTarget) {
            if (model.isGameOver()) {
              paused = false;
            } else {
              model.move("down");
              view.drawTime();
            }
            delayCount = 0;
          } else {
            delayCount = delayCount + 1;
          }
        }
        break;
      case "start":
        paused = false;
        timer.start();
        break;
      case "size":
        model.setSize(40, 40);
        model.restartGame();
        System.out.print("size");
        view.run(model, 10);
        view.drawTime();
      case "pause":
          paused = true;
        break;
      case "resume":
        paused = false;
        break;
      case "quit":
        model.restartGame();
        this.paused = true;
        view.drawTime();
        System.out.print("quit");
        break;
      case "increase speed":
        if(delayCountTarget > 3) {
          if (delayCount < delayCountTarget) {
            delayCountTarget = delayCountTarget - 1;
          } else {
            delayCount = delayCountTarget;
          }
        } else {
          delayCountTarget = 3;
        }
        break;
      case "decrease speed":
        if(delayCountTarget < 12) {
            delayCountTarget = delayCountTarget + 1;
          }
        break;
      default:
        }
        view.getLinesLabel().setText("Line Count: " + model.getLineCount());
    if(view.getGameType().equals("Levels")) {
      view.getLevelLabel().setText("Level: " + model.getLevel());
      if (model.getLevel() <= 10 && model.getLevel() == 1 + CurrentLevel) {
        CurrentLevel = model.getLevel();
        delayCountTarget = delayCountTarget - 1;
        System.out.print(delayCountTarget);
      }
    }
    }



  public void setSpeed(int speed) {
    this.speed = speed;
  }


  public void run(int speed) {
    view.run(model, speed);
    timer.start();
    view.addKeyBinding(view.getMainPanel(), KeyEvent.VK_RIGHT, "right", (evt) -> model.move("right"));
    view.addKeyBinding(view.getMainPanel(), KeyEvent.VK_LEFT, "left", (evt) -> model.move("left"));
    view.addKeyBinding(view.getMainPanel(), KeyEvent.VK_UP, "rotate", (evt) -> model.rotate());
    view.addKeyBinding(view.getMainPanel(), KeyEvent.VK_DOWN, "down", (evt) -> model.move("down"));
  }



  public void setModel(ITetrisModel m) {
    this.model = m;
  }
}