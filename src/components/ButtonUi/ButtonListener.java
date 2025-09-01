package components.ButtonUi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import logger.LogApp;

public class ButtonListener implements ActionListener {
  private int data;

  @Override
  public void actionPerformed(ActionEvent e) {
    LogApp log = new LogApp();
    log.Debug("User input -> " + e.getActionCommand());
  }
}
