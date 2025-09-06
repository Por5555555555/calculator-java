import components.ButtonUi.ButtonUiInit;
import components.TextFieldApp.TextFieldInit;
import logger.LogApp;
import javax.swing.JFrame;
import javax.swing.JPanel;

import LogicApp.InputLogic;

public class App {
  static int width = 50;
  static int hight = 50;
  static int x = 10;
  static int y = 10;
  static int MaxUiX = 500;
  static int MaxCur = 4;
  static int setPosY = 150;
  static int FieldWidth = 250;
  static int FieldHeight = 60;
  static int FieldX = -10;
  static int FieldY = 50;
  public static int data_test = 0;

  public static void main(String[] args) {
    InputLogic.initWithNewIndex();// .addNumber("123");

    // new LogicTest().test();
    // new LogicCalTest().test();

    LogApp log = new LogApp();
    log.Info("Create gui");

    JFrame frame = new GuiInit(500, 550).init();
    JPanel box = new ButtonUiInit(width, hight, x, y, MaxUiX, MaxCur, setPosY).SetButtonUi();

    TextFieldInit field = TextFieldInit.Init(FieldWidth, FieldHeight, "", MaxUiX, FieldX, FieldY, box);
    JPanel fieldText = field.setLabel();

    frame.add(fieldText);
    frame.setVisible(true);
  }
}
