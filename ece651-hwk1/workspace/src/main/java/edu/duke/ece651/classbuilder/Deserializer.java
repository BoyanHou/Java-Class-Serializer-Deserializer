package edu.duke.ece651.classbuilder;

import org.json.JSONException;
import org.json.JSONObject;

import edu.duke.ece651.classbuilder.package1.Class2;


public class Deserializer {
  public static Class1 readClass1(JSONObject js) throws JSONException {
    Class1 class1 = new Class1();
    JSONObject values = js.getJSONObject("values");
    class1.setI1(Integer.valueOf(values.getString("i1")));
    class1.setI2(Integer.valueOf(values.getString("i2")));
    class1.setB1(Boolean.valueOf(values.getString("b1")));
    class1.setB2(Boolean.valueOf(values.getString("b2")));
    class1.setS1(values.getString("s1"));
    class1.setS2(values.getString("s2"));
    return class1;
  }

    public static Class2 readClass2(JSONObject js) throws JSONException {
      Class2 class2 = new Class2();
    //bcslfd
    JSONObject values = js.getJSONObject("values");
    class2.setB1(Byte.valueOf(values.getString("b1")));
    class2.setC1(values.getString("c1").charAt(0));
    class2.setS1(Short.valueOf(values.getString("s1")));
    class2.setL1(Long.valueOf(values.getString("l1")));
    class2.setF1(Float.valueOf(values.getString("f1")));
    class2.setD1(Double.valueOf(values.getString("d1")));
    return class2;
  }
}
