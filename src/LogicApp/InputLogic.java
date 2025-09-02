package LogicApp;

import java.util.ArrayList;

import logger.LogApp;

public class InputLogic {
  private static ArrayList<String> NumberStringArrayList = new ArrayList<>();
  private static ArrayList<String> ObjStringsArrayList = new ArrayList<>();
  private static int IndexNumber = 0;
  private static int IndexObj = 0;
  private LogApp log = new LogApp();

  public InputLogic() {
    NumberStringArrayList.add("");
    ObjStringsArrayList.add("");
  }

  public InputLogic moveIndexNumber() {
    IndexNumber += 1;
    NumberStringArrayList.add("");
    return this;
  }

  public InputLogic moveIndexObj() {
    IndexObj += 1;
    ObjStringsArrayList.add("");
    return this;
  }

  public InputLogic Reset() {
    IndexNumber = 0;
    IndexObj = 0;
    NumberStringArrayList = new ArrayList<>();
    ObjStringsArrayList = new ArrayList<>();
    return this;
  }

  public InputLogic addNumber(String newCharNum) {
    String numOld = NumberStringArrayList.get(IndexNumber);
    String numNew = numOld + newCharNum;
    NumberStringArrayList.set(IndexNumber, numNew);
    return this;
  }

  public InputLogic addObj(String newCharObj) {
    String objOld = ObjStringsArrayList.get(IndexObj);
    String nuwNew = objOld + newCharObj;
    ObjStringsArrayList.set(IndexObj, nuwNew);
    moveIndexNumber();
    moveIndexObj();
    return this;
  }

  public String getString() {
    String mapString = new String();
    int max = NumberStringArrayList.size() + ObjStringsArrayList.size();
    int obj = 0;
    int num = 0;
    log.Info("Max data input ->> " + String.valueOf(max));

    for (int i = 0; i < max; i++) {
      if ((i + 1) % 2 == 0) {
        log.Debug("ctx obj ->> " + ObjStringsArrayList.get(obj));
        mapString += ObjStringsArrayList.get(obj);
        mapString += " ";
        obj += 1;
        continue;
      }
      log.Debug("ctx index ->> " + NumberStringArrayList.get(num));
      mapString += NumberStringArrayList.get(num);
      mapString += " ";
      num += 1;
    }
    log.Debug("num -> " + String.valueOf(num) + " obj -> " + String.valueOf(obj));
    return mapString;
  }
}
