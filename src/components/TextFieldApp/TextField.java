package components.TextFieldApp;

import javax.swing.JTextField;

import logger.LogApp;

public class TextField {
  private int x = 0;
  private int y = 0;
  private int width;
  private int height;
  private String ctx;
  private LogApp log = new LogApp();

  public TextField(int width, int height, String ctx) {
    this.width = width;
    this.height = height;
    this.ctx = ctx;
  }

  public JTextField Create() {
    JTextField text = new JTextField(ctx);
    text.setBounds(x, y, width, height);
    log.Debug(
        "Field new \n\t\tx->" + String.valueOf(x) + " y->" + String.valueOf(y) + "\n\t\tw->" + String.valueOf(width)
            + " h->" + String.valueOf(height));
    return text;
  }

  public TextField setPos(int x, int y) {
    this.x = x;
    this.y = y;
    return this;
  }

  public TextField setSize(int width, int height) {
    this.height = height;
    this.width = width;
    return this;
  }

  public TextField setCenter(int MaxXUi) {
    this.x = (MaxXUi - width) / 2;
    return this;
  }

  public TextField setCxt(String ctx) {
    this.ctx = ctx;
    return this;
  }
}
