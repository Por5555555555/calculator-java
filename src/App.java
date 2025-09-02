import components.ButtonUi.ButtonUiInit;
import test.LogicTest;
import components.TextFieldApp.TextFieldInit;
import logger.LogApp;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
    new LogicTest().test();

    LogApp log = new LogApp();
    log.Info("Create gui");

    JFrame frame = new GuiInit(500, 550).init();
    JPanel box = new ButtonUiInit(width, hight, x, y, MaxUiX, MaxCur, setPosY).SetButtonUi();
    JPanel fieldText = new TextFieldInit(FieldWidth, FieldHeight, "", box, MaxUiX, FieldX, FieldY).setLabel();

    frame.add(fieldText);
    frame.setVisible(true);
  }
}
