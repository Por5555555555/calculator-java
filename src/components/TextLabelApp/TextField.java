package components.TextFieldApp;

import javax.swing.JLabel;

public class TextLabel {
  private int x = 0;
  private int y = 0;
  private int width;
  private int height;
  private String ctx;

  public TextLabel(int width, int height, String ctx) {
    this.width = width;
    this.height = height;
    this.ctx = ctx;
  }

  public JLabel Create() {
    JLabel text = new JLabel(ctx);
    text.setBounds(x, y, width, height);
    return text;
  }

  public TextLabel setPos(int x, int y) {
    this.x = x;
    this.y = y;
    return this;
  }

  public TextLabel setSize(int width, int height) {
    this.height = height;
    this.width = width;
    return this;
  }

  public TextLabel setCxt(String ctx) {
    this.ctx = ctx;
    return this;
  }
}
