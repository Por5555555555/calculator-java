package components.ButtonUi;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JPanel;

import logger.LogApp;

public class ButtonUiInit {
  private int width;
  private int hight;
  private int x;
  private int y;
  private int MaxUiX;
  private int maxCur;
  private int posY;
  private LogApp log = new LogApp();

  public ButtonUiInit(int width, int hight, int x, int y, int MaxUiX, int MaxCur, int setPosY) {
    this.width = width;
    this.hight = hight;
    this.x = x;
    this.y = y;
    this.maxCur = MaxCur;
    this.MaxUiX = MaxUiX;
    this.posY = setPosY;
  }

  public JPanel SetButtonUi() {

    log.Info("Create button fn");
    ButtonUi LayerBt = new ButtonUi(x, y, width, hight).setCenter(MaxUiX, maxCur).setPosYStart(posY);

    JButton bt1 = LayerBt.moveXStart().moveYStart().CreateButton("CE");
    JButton bt2 = LayerBt.moveXRight().CreateButton("/");
    JButton bt3 = LayerBt.moveXRight().CreateButton("*");
    JButton bt4 = LayerBt.moveXRight().CreateButton("-");
    JButton bt5 = LayerBt.moveXStart().moveYDown().CreateButton("7");
    JButton bt6 = LayerBt.moveXRight().CreateButton("8");
    JButton bt7 = LayerBt.moveXRight().CreateButton("9");
    JButton bt8 = LayerBt.moveXRight().CreateButton("+", width, hight * 2 + y);
    JButton bt9 = LayerBt.moveYDown().moveXStart().CreateButton("4");
    JButton bt10 = LayerBt.moveXRight().CreateButton("5");
    JButton bt11 = LayerBt.moveXRight().CreateButton("6");
    JButton bt12 = LayerBt.moveYDown().moveXStart().CreateButton("1");
    JButton bt13 = LayerBt.moveXRight().CreateButton("2");
    JButton bt14 = LayerBt.moveXRight().CreateButton("3");
    JButton bt15 = LayerBt.moveXRight().CreateButton("⏎", width, hight * 2 + y);
    JButton bt16 = LayerBt.moveYDown().moveXStart().CreateButton("0", width * 2 + x, hight);
    JButton bt17 = LayerBt.moveXRight().moveXRight().CreateButton(".");

    ArrayList<JButton> myBt = new ArrayList<JButton>(
        Arrays.asList(
            bt1, bt2, bt3,
            bt4, bt5, bt6,
            bt7, bt8, bt9,
            bt10, bt11, bt12,
            bt13, bt14, bt15,
            bt16, bt17));

    myBt.forEach(button -> button.addActionListener(new ButtonListener()));
    JPanel box = LayerBt.AddMitlPanel(myBt);
    return box;
  }
}
