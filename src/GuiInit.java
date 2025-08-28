import javax.swing.JFrame;
import logger.LogApp;

public class GuiInit extends JFrame {
  private int x;
  private int y;

  public GuiInit(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public JFrame init() {
    LogApp log = new LogApp();
    log.Info("Create frame");
    JFrame frame = new JFrame();
    frame.setSize(this.x, this.y);
    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    frame.setResizable(false);
    frame.setTitle("App cal");
    return frame;
  }
}
