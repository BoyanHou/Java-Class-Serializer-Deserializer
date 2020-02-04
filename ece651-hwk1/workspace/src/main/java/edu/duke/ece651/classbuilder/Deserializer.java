package edu.duke.ece651.classbuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import edu.duke.ece651.classbuilder.package1.Class2;


public class Deserializer {
  public static Class1 readClass1(JSONObject js) throws JSONException {
    Class1 class1 = new Class1();
    JSONArray values = js.getJSONArray("values");
    class1.setI1(Integer.valueOf(values.getJSONObject(0).getString("i1")));
    class1.setI2(Integer.valueOf(values.getJSONObject(1).getString("i2")));
    class1.setB1(Boolean.valueOf(values.getJSONObject(2).getString("b1")));
    class1.setB2(Boolean.valueOf(values.getJSONObject(3).getString("b2")));
    class1.setS1(String.valueOf(values.getJSONObject(4).getString("s1")));
    class1.setS2(String.valueOf(values.getJSONObject(5).getString("s2")));
    return class1;
  }

  public static Class2 readClass2(JSONObject js) throws JSONException {
    Class2 class2 = new Class2();
    //bcslfd
    JSONArray values = js.getJSONArray("values");
    class2.setB1(Byte.valueOf(values.getJSONObject(0).getString("b1")));
    class2.setC1(values.getJSONObject(1).getString("c1").charAt(0));
    class2.setS1(Short.valueOf(values.getJSONObject(2).getString("s1")));
    class2.setL1(Long.valueOf(values.getJSONObject(3).getString("l1")));
    class2.setF1(Float.valueOf(values.getJSONObject(4).getString("f1")));
    class2.setD1(Double.valueOf(values.getJSONObject(5).getString("d1")));
    return class2;
  }
}
