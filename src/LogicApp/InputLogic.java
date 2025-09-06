package LogicApp;

import java.util.ArrayList;

import logger.LogApp;

public class InputLogic {
  private static ArrayList<String> NumberStringArrayList = new ArrayList<>();
  private static ArrayList<String> ObjStringsArrayList = new ArrayList<>();
  private static int IndexNumber = 0;
  private static int IndexObj = 0;
  private static LogApp log = new LogApp();

  public ArrayList<String> getNumberStringArrayList() {
    return NumberStringArrayList;
  }

  public ArrayList<String> getObjStringArrayList() {
    return ObjStringsArrayList;
  }

  public InputLogic removeLastIndexObj() {
    ObjStringsArrayList.remove(ObjStringsArrayList.size() - 1);
    return this;
  }

  public static InputLogic initWithNewIndex() {
    NumberStringArrayList.add("");
    ObjStringsArrayList.add("");
    log.Debug("init array");
    return new InputLogic();
  }

  public static InputLogic init() {
    return new InputLogic();
  }

  private InputLogic() {
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
    NumberStringArrayList.add("");
    ObjStringsArrayList.add("");
    return this;
  }

  public InputLogic addNumber(String newCharNum) {
    String numOld = NumberStringArrayList.get(IndexNumber);
    String numNew = numOld + newCharNum;
    NumberStringArrayList.set(IndexNumber, numNew);
    log.Debug("Add number ->> " + newCharNum);
    return this;
  }

  public InputLogic addPoint(String newCharPoint) {
    if (NumberStringArrayList.get(IndexNumber).length() < 1) {
      log.Error("U cannot input ponter first");
      return this;
    }
    for (int i = 0; i < NumberStringArrayList.get(IndexNumber).length(); i++) {
      char NumChar = NumberStringArrayList.get(IndexNumber).charAt(i);
      if (NumChar != '.')
        continue;
      log.Error("U cannot add muilt dot");
      return this;
    }

    String oldNum = NumberStringArrayList.get(IndexNumber);
    String newNum = oldNum + newCharPoint;
    NumberStringArrayList.set(IndexNumber, newNum);
    log.Info("Add point");
    return this;
  }

  public InputLogic inputCalData() {
    log.Info("Size numberArray ->> " + String.valueOf(NumberStringArrayList.size())
        + "\n\tSize ObjArray ->> " + String.valueOf(ObjStringsArrayList.size()));
    if (NumberStringArrayList.size() < ObjStringsArrayList.size()) {
      log.Error("U cannot number size < obj");
      return this;
    }
    CalLogic logicCal = CalLogic.Init();
    logicCal.CalData();
    Reset();
    NumberStringArrayList.set(0, logicCal.getAws());
    return this;
  }

  private InputLogic UpdatePointerWithIndex() {
    String numStr = NumberStringArrayList.get(IndexNumber);
    float num = Float.parseFloat(numStr);
    NumberStringArrayList.set(IndexNumber, String.valueOf(num));
    return this;
  }

  public InputLogic addObj(String newCharObj) {
    if (NumberStringArrayList.get(IndexNumber) == "") {
      log.Error("Error u cannnot add move obj");
      return this;
    }

    log.Debug("Add obj new ->> " + newCharObj);
    ObjStringsArrayList.set(IndexObj, newCharObj);
    UpdatePointerWithIndex();
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
