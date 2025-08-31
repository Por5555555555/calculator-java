package components.ButtonUi;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import logger.LogApp;

public class ButtonUi extends JButton {
  private int width;
  private int hight;
  private int x;
  private int y;
  private Boolean centor = false;
  private int cenX;
  private Boolean setYpos = false;
  private int setY;
  private int XDef;
  private int YDef;
  private LogApp log;

  public JButton CreateButton(String ctx) {
    log.Debug("button create custom x -> " + String.valueOf(x) + "| y -> " + String.valueOf(y));
    JButton bt = new JButton(ctx);
    bt.setBounds(x, y, width, hight);
    return bt;
  }

  public JButton CreateButton(String ctx, int width, int hight) {
    log.Debug("button create custom x -> " + String.valueOf(x) + "| y -> " + String.valueOf(y));
    JButton bt = new JButton(ctx);
    bt.setBounds(x, y, width, hight);
    return bt;
  }

  public ButtonUi moveXRight() {
    this.x += width + this.XDef;
    return this;
  }

  public ButtonUi moveXStart() {
    if (this.centor == true) {
      this.x = cenX;
      return this;
    }
    this.x = this.XDef;
    return this;
  }

  public ButtonUi moveYDown() {
    this.y += hight + this.YDef;
    return this;
  }

  public ButtonUi moveYStart() {
    if (this.setYpos == true) {
      this.y = setY;
      log.Debug("local y -> " + String.valueOf(this.y));
      return this;
    }
    this.y = this.YDef;
    return this;
  }

  public ButtonUi setCenter(int MaxUiX, int maxCur) {
    this.cenX = (MaxUiX - ((this.width + this.x) * maxCur)) / 2;
    this.centor = true;
    log.Debug("Centor -> " + String.valueOf(cenX));
    return this;
  }

  public ButtonUi setPosYStart(int posY) {
    this.setY = posY;
    this.setYpos = true;
    log.Debug("Set y pos -> " + String.valueOf(posY));
    return this;
  }

  public ButtonUi(int x, int y, int width, int hight) {
    this.x = x;
    this.y = y;
    this.XDef = x;
    this.YDef = y;
    this.width = width;
    this.hight = hight;
    this.log = new LogApp();
  }

  public JPanel AddMitlPanel(ArrayList<JButton> btAll) {
    JPanel panel = new JPanel();
    panel.setLayout(null);
    for (int i = 0; i < btAll.size(); i++) {
      panel.add(btAll.get(i));
    }

    return panel;
  };
}
