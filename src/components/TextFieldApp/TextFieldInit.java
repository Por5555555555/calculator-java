package components.TextFieldApp;

import javax.swing.JPanel;
import javax.swing.JTextField;

import logger.LogApp;

public class TextFieldInit {
  private int x;
  private int y;
  private int width;
  private int height;
  private LogApp log = new LogApp();
  private JPanel panel;
  private int MaxUiX;
  private static String ctx;
  private static JTextField field;

  public static TextFieldInit Init(int width, int height, String ctxStr, int MaxUiX, int x, int y, JPanel panel) {
    ctx = ctxStr;
    return new TextFieldInit(x, y, width, height, ctxStr, MaxUiX, panel);
  }

  public static TextFieldInit connect() {
    return new TextFieldInit();
  }

  private TextFieldInit() {
  }

  private TextFieldInit(int x, int y, int width, int height, String ctxStr, int MaxUiX, JPanel panel) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
    this.MaxUiX = MaxUiX;
    this.panel = panel;
    ctx = ctxStr;
  }

  public TextFieldInit setCxt(String ctxStr) {
    field.setText(ctxStr);
    return this;
  }

  public JPanel setLabel() {
    if (this.panel == null) {
      log.Error("Panel is null for TextFieldInit");
      return new JPanel();
    }

    field = new TextField(width, height, ctx).setPos(x, y).setCenter(MaxUiX).Create();
    field.setEditable(false);

    this.panel.add(field);
    return panel;
  }

}
