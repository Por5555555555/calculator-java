package components.ButtonUi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import logger.LogApp;

public class ButtonListener implements ActionListener {

  @Override
  public void actionPerformed(ActionEvent e) {
    LogApp log = new LogApp();
    log.Error("This function test input -> " + e.getActionCommand());
  }
}
