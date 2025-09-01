package components.TextFieldApp;

import javax.swing.JPanel;
import javax.swing.JTextField;
import logger.LogApp;

public class TextFieldInit {
  private int x;
  private int y;
  private int width;
  private int height;
  private String ctx;
  private LogApp log = new LogApp();
  private JPanel panel;
  private int MaxXUi;

  public TextFieldInit(int width, int height, String ctx, JPanel panel, int MaxXUi, int x, int y) {
    this.width = width;
    this.height = height;
    this.ctx = ctx;
    this.panel = panel;
    this.MaxXUi = MaxXUi;
    this.x = x;
    this.y = y;
  }

  public TextFieldInit setSize(int width, int height) {
    this.height = height;
    this.width = width;
    return this;
  }

  public TextFieldInit setCxt(String ctx) {
    this.ctx = ctx;
    return this;
  }

  public JPanel setLabel() {
    if (this.panel == null) {
      log.Error("Panel is null for TextFieldInit");
      return new JPanel();
    }

    JTextField text = new TextField(width, height, ctx).setPos(x, y).setCenter(MaxXUi).Create();
    text.setEditable(false);

    this.panel.add(text);
    return panel;
  }
}
