package test;

import LogicApp.CalLogic;
import LogicApp.InputLogic;
import logger.LogApp;

public class LogicCalTest {
  private LogApp log = new LogApp();

  public void test() {
    log.Debug("Star test");
    InputLogic input = InputLogic.init();
    input.addNumber("123")
        .addObj("x").addNumber("321")
        .addObj("+").addNumber("12345")
        .addObj("-").addNumber("5345")
        .addObj("/").addNumber("1315");
    log.Debug("Create number");

    // ArrayList<String> test = input.getObjStringArrayList();
    // log.Info(test);

    CalLogic cal = CalLogic.Init();
    cal.CalData();
    System.exit(0);
  }
}
