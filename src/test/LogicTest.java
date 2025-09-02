package test;

import logger.LogApp;
import LogicApp.InputLogic;

public class LogicTest {
  private LogApp log = new LogApp();
  private InputLogic logic = new InputLogic();

  public void test() {
    log.Info(" --------------------------------------\n\ttest logic\n\t--------------------------------------");
    logic.addNumber("1234")
        .addObj("+")
        .addNumber("2312")
        .addObj("-")
        .addNumber("23456");
    String ctx = logic.getString();
    log.Info("Ctx test ->> " + ctx);
    System.exit(0);
  }
}
