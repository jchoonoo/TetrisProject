package view;

import java.awt.event.ActionListener;

import javax.swing.*;

import tetrisModel.ITetrisModel;

public interface ITetrisView {

  void setListeners(ActionListener clicks);

  void run(ITetrisModel m, int speed);

  void drawTime();

  TetrisMainPanel getMainPanel();

  void addKeyBinding(JComponent comp, int keyCode, String id, ActionListener listener);

  JLabel getLinesLabel();

  JLabel getLevelLabel();

  String getGameType();

  void viewCreateGamePanel();

  void unviewCreateGamePanel();

  void viewGameTypePanel();

  void unviewGameTypePanel();

  void viewMainGamePanel();

  void setEditableText();

  void unsetEditableText();

  void addLevelOption();

  void resetTexts();

  void resetSelection();

  boolean isDefaultButtonSelected();

  void setGameType(String s);

  String getRowValue();

  String getColumnValue();

  String getLevelValue();

  void unviewHome();

  //void setKeyListeners(KeyListener press);

  /* plan of action ----
  first make a main screen jframe that holds everything
  first make it start with two buttons
  if the casual button is clicked make a new tetris game and as for how many rows and columns you want
  have an option for original and make original tetris
  if levels button is clicked have an option for how many rows and columns you want
  have an option for original
  have an option for which level you want to start on
  in each game have buttons for start, pause, quit, restart,
  in casual have button for increase/decrease speed

  ---- more details
  step 1: home screen : 2 buttons, casual or levels
  step 2: click on casual:
          brings you to a new view, contains:
          2 check boxes, original, or custome game
            custom game has under it 2 text boxes:
              number of rows, number of columns
          1 start button
          if original is checked create a new model with default values
            send it to the game view and send user to game view
          if custom game is checked controller create a new model with the specified width and height
            and start user at level 1 speed (might be confusing becuase speed is based on levels
            not levels based on speed)
  step 3: click on levels:
           brings you to new view that is exactly the same as casual view
             except that under custom game there is another text box for
             what level the user wants to start at
           controller does exactly the same as casual game except add level into model
           for custom game
  step 4: inside the game play view:
          buttons will be start, pause, restart and quit
          start pause and restart are trivial
          quit: the controller will figure out a way to end current game and bring user
                back to home screen
  notes: inside the casual view there will be an extra text line of info along with lines
          deleted and score. this extra text will be a number 1-10 representing speed
   */
}
