import components.ButtonUi.ButtonUiInit;
import logger.LogApp;
import javax.swing.JFrame;
import javax.swing.JPanel;

class App {
  static int width = 50;
  static int hight = 50;
  static int x = 10;
  static int y = 10;
  static int MaxUiX = 500;
  static int MaxCur = 4;
  static int setPosY = 150;

  public static void main(String[] args) {
    LogApp log = new LogApp();
    log.Info("Create gui");

    JFrame frame = new GuiInit(500, 550).init();
    JPanel box = new ButtonUiInit(width, hight, x, y, MaxUiX, MaxCur, setPosY).SetButtonUi();

    frame.add(box);
    frame.setVisible(true);
  }
}
