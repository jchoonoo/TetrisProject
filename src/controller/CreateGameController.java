package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import tetrisModel.ITetrisModel;
import tetrisModel.TetrisModel;
import view.ITetrisView;
import view.TetrisView;

public class CreateGameController implements IController, ActionListener  {

  ITetrisView view;
  ITetrisModel model;
  ITetrisView gameView;
  Controller controller;

  public CreateGameController(ITetrisView view)  {
    this.view = view;
    view.setListeners(this);

  }



  //// *** starting level is level 1, at 325 delay then you add 25 every level until level 10 and u stop increasing speed at 100
  //use some kind of counter where if counter = x do it and if not add 1
  // ***** EDIT - use a counter - ex if counter = 20 do x, to increase speed or decrease speed write a method that takes in an int
  // and then changes the base counter value to = 19 and make the count = 19 --- this is the idea tweak it though because it wont work
  @Override
  public void actionPerformed(ActionEvent e) {
    switch (e.getActionCommand()) {
      case "default":
        view.unsetEditableText();
        view.resetTexts();
        break;
      case "customize":
        view.setEditableText();
        break;
      case "start":
        if(view.isDefaultButtonSelected()) {
          model = new TetrisModel(10, 18, 1);
          gameView = new TetrisView("");
          controller = new Controller(10, gameView, model);
          view.resetTexts();
          view.resetSelection();
          view.unviewGameTypePanel();
          view.unviewCreateGamePanel();
          view.unviewHome();
          controller.run(10);
        }
        else if(!view.isDefaultButtonSelected()) {
          if(view.getGameType().equals("casual")) {
            model = new TetrisModel(Integer.parseInt(view.getRowValue()), Integer.parseInt(view.getColumnValue()), 1);
            gameView = new TetrisView("");
            controller = new Controller(10, gameView, model);
            view.resetTexts();
            view.resetSelection();
            view.unviewCreateGamePanel();
            controller.run(10);
            view.unviewHome();
          } else {
            if(view.getGameType().equals("levels")) {
              model = new TetrisModel(Integer.parseInt(view.getRowValue()), Integer.parseInt(view.getColumnValue()), Integer.parseInt(view.getLevelValue()));
              gameView = new TetrisView("level");
              controller = new Controller(10, gameView, model);
              view.resetTexts();
              view.resetSelection();
              view.unviewCreateGamePanel();
              controller.run(10);
              view.unviewHome();

            }
          }
        }
        break;
      case "back":
        view.unviewCreateGamePanel();
        view.viewGameTypePanel();
        view.resetTexts();
        view.resetSelection();
        break;
    }
  }
//  public void run(int speed) {
//    view.run(model, speed);
////    timer.start();
//  }
}
