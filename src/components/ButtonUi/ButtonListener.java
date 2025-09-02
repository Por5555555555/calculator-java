package components.ButtonUi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import LogicApp.InputLogic;
import components.TextFieldApp.TextFieldInit;
import logger.LogApp;

public class ButtonListener implements ActionListener {

  @Override
  public void actionPerformed(ActionEvent e) {
    LogApp log = new LogApp();
    String ctx = e.getActionCommand();
    InputLogic logic = InputLogic.init();
    log.Debug("User input -> " + ctx);

    switch (ctx) {
      case " ":
        log.Info("this func support for comming soom");
        break;
      case "CE":
        logic.Reset();
        break;
      case "/":
        logic.addObj(ctx.trim());
        break;
      case "*":
        logic.addObj(ctx.trim());
        break;
      case "+":
        logic.addObj(ctx.trim());
        break;
      case "-":
        logic.addObj(ctx.trim());
        break;
      case ".":
        logic.addPoint(ctx.trim());
        break;
      case "⏎":
        break;
      default:
        logic.addNumber(ctx.trim());
        break;
    }

    String data = logic.getString();
    TextFieldInit field = TextFieldInit.connect();
    field.setCxt(data);
    log.Debug(data);
  }
}
