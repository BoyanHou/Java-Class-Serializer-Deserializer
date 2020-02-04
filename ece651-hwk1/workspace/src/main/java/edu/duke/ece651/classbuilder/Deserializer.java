package edu.duke.ece651.classbuilder;

import org.json.JSONException;
import org.json.JSONObject;

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
}
