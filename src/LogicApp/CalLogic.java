package LogicApp;

import java.util.ArrayList;
import logger.LogApp;

public class CalLogic {
  private ArrayList<String> newNum = new ArrayList<>();
  private ArrayList<String> newObj = new ArrayList<>();
  private ArrayList<String> oldNum = new ArrayList<>();
  private ArrayList<String> oldObj = new ArrayList<>();
  private LogApp Log = new LogApp();
  private String add = "+";
  private String rmo = "-";
  private String mit = "x";
  private String hef = "/";
  private static String aws;

  public CalLogic newNumberArray() {
    newNum = new ArrayList<>();
    return this;
  }

  public CalLogic newObjArrayList() {
    newObj = new ArrayList<>();
    return this;
  }

  public static CalLogic Init() {
    return new CalLogic();
  }

  public String getAws() {
    return aws;
  }

  private CalLogic() {
  }

  public ArrayList<Float> toArrayListFloat(ArrayList<String> NumString) {
    ArrayList<Float> numFloatArray = new ArrayList<>();
    for (int i = 0; i < NumString.size(); i++) {
      try {
        float numFloat = Float.parseFloat(NumString.get(i));
        numFloatArray.add(numFloat);
      } catch (NumberFormatException e) {
        numFloatArray.add(Float.valueOf(0));
        Log.Error(e);
      }
    }
    return numFloatArray;
  }

  private String CalLogicFloat(Float num1, Float num2, String obj) {
    float calNum = 0;
    String objLow = obj.toLowerCase();

    if (objLow == this.add)
      calNum = num1 + num2;
    if (objLow == this.rmo)
      calNum = num1 - num2;
    if (objLow == this.mit)
      calNum = num1 * num2;
    if (objLow == this.hef)
      calNum = num1 / num2;

    return String.valueOf(calNum);
  }

  private CalLogic CalDataLogic(ArrayList<String> Num, ArrayList<String> Obj) {
    ArrayList<Float> oldNum = toArrayListFloat(Num);
    ArrayList<String> oldObj = Obj;
    Boolean muilt = false;
    int localObj = 0;
    int localX = 0;
    int localY = 1;

    Log.Status("Find ??? ->> ");
    for (int i = 0; i < oldObj.size(); i++) {
      if (oldObj.get(i) != this.mit && oldObj.get(i) != this.hef) {
        continue;
      }
      muilt = true;
      localObj = i;
      localX = i;
      localY = i + 1;
      break;
    }

    if (muilt)
      System.out.println("Found ->> " + String.valueOf(localObj)
          + " : " + String.valueOf(oldObj.get(localObj)));
    else
      System.out.println("Not found");

    Log.Info(
        "Size oldNum ->> " + String.valueOf(oldNum.size())
            + "\n\tLocalX num ->> " + String.valueOf(oldNum.get(localX))
            + "\n\tLocalY ->> " + String.valueOf(oldNum.get(localY))
            + "\n\tAll number ->> " + String.valueOf(oldNum)
            + "\n\tAll obj ->> " + String.valueOf(oldObj));

    Log.Debug("Local Obj ->> " + String.valueOf(localObj)
        + "\n\tLocalX ->> " + String.valueOf(localX)
        + "\n\tLocalY ->> " + String.valueOf(localY));

    newNum = Num;
    newNum.set(localX, CalLogicFloat(oldNum.get(localX), oldNum.get(localY), oldObj.get(localObj)));
    newNum.remove(localY);
    newObj = oldObj;
    newObj.remove(localObj);
    return this;
  }

  public CalLogic CalData() {
    InputLogic input = InputLogic.init();
    oldNum = input.getNumberStringArrayList();
    oldObj = input.removeLastIndexObj().getObjStringArrayList();

    while (oldNum.size() > 1) {
      CalDataLogic(oldNum, oldObj);
      oldNum = newNum;
      oldObj = newObj;
      newNumberArray();
      newObjArrayList();
    }

    aws = oldNum.getFirst();
    Log.Info("Last cal data ->> " + aws);
    return this;
  }
}
