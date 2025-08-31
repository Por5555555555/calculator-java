package components.ButtonUi;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonUiInit {
  private int width;
  private int hight;
  private int x;
  private int y;
  private int MaxUiX;
  private int maxCur;
  private int posY;

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
    ArrayList<JButton> myBt = new ArrayList<JButton>();
    ButtonUi LayerBt = new ButtonUi(x, y, width, hight).setCenter(MaxUiX, maxCur).setPosYStart(posY);

    JButton bt1 = LayerBt.moveXStart().moveYStart().CreateButton(" ");
    JButton bt2 = LayerBt.moveXRight().CreateButton("/");
    JButton bt3 = LayerBt.moveXRight().CreateButton("*");
    JButton bt4 = LayerBt.moveXRight().CreateButton("-");
    JButton bt5 = LayerBt.moveXStart().moveYDown().CreateButton("7");
    JButton bt6 = LayerBt.moveXRight().CreateButton("8");
    JButton bt7 = LayerBt.moveXRight().CreateButton("9");
    JButton bt8;
    JButton bt9;
    JButton bt10;

    bt1.addActionListener(new ButtonListener());
    bt2.addActionListener(new ButtonListener());
    bt3.addActionListener(new ButtonListener());
    bt4.addActionListener(new ButtonListener());
    bt5.addActionListener(new ButtonListener());
    bt6.addActionListener(new ButtonListener());
    bt7.addActionListener(new ButtonListener());

    myBt.add(bt1);
    myBt.add(bt2);
    myBt.add(bt3);
    myBt.add(bt4);
    myBt.add(bt5);
    myBt.add(bt6);
    myBt.add(bt7);

    myBt.add(LayerBt
        .moveXRight()
        .CreateButton("+", 50, 50 * 2 + 10));

    // button layer 3
    myBt.add(LayerBt
        .moveXStart()
        .moveYDown()
        .CreateButton("4"));
    myBt.add(LayerBt
        .moveXRight()
        .CreateButton("5"));
    myBt.add(LayerBt
        .moveXRight()
        .CreateButton("6"));

    // button layer 4
    myBt.add(LayerBt
        .moveXStart()
        .moveYDown()
        .CreateButton("1"));
    myBt.add(LayerBt
        .moveXRight()
        .CreateButton("2"));
    myBt.add(LayerBt
        .moveXRight()
        .CreateButton("3"));
    myBt.add(LayerBt
        .moveXRight()
        .CreateButton("⏎", 50, 50 * 2 + 10));

    // button layer 5
    myBt.add(LayerBt
        .moveXStart()
        .moveYDown()
        .CreateButton("0", 50 * 2 + 10, 50));
    myBt.add(LayerBt
        .moveXRight()
        .moveXRight()
        .CreateButton("."));

    JPanel box = LayerBt.AddMitlPanel(myBt);
    return box;
  }
}
