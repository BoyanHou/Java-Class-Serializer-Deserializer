package edu.duke.ece651.classbuilder;

import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import edu.duke.ece651.classbuilder.package1.Class2;


public class Deserializer { 

  public static Class1 readClass1(JSONObject js) throws JSONException {
    HashMap<Integer, Object> map = new HashMap<>();
    return readClass1(js, map);
  }

  public static Class1 readClass1(JSONObject js, HashMap<Integer, Object> map) throws JSONException {
 if (js.has("ref")) {
      int key = js.getString("ref").hashCode();
      return (Class1)(map.get(key));
    } 
    
    Class1 class1 = new Class1();
    int id = js.getString("id").hashCode();
    map.put(id, class1);
    
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
    HashMap<Integer, Object> map = new HashMap<>();
    return readClass2(js, map);
  }

  public static Class2 readClass2(JSONObject js, HashMap<Integer, Object> map) throws JSONException {
 if (js.has("ref")) {
      int key = js.getString("ref").hashCode();
      return (Class2)(map.get(key));
    } 
    
    Class2 class2 = new Class2();
    int id = js.getString("id").hashCode();
    map.put(id, class2);
    
    JSONArray values = js.getJSONArray("values");
  
    class2.setB1(Byte.valueOf(values.getJSONObject(0).getString("b1")));
    class2.setC1(values.getJSONObject(1).getString("c1").charAt(0));
    class2.setS1(Short.valueOf(values.getJSONObject(2).getString("s1")));
    class2.setL1(Long.valueOf(values.getJSONObject(3).getString("l1")));
    class2.setF1(Float.valueOf(values.getJSONObject(4).getString("f1")));
    class2.setD1(Double.valueOf(values.getJSONObject(5).getString("d1")));
    return class2;
  }

  public static Class3 readClass3(JSONObject js) throws JSONException {
    HashMap<Integer, Object> map = new HashMap<>();
    return readClass3(js, map);
  }
  public static Class3 readClass3(JSONObject js, HashMap<Integer, Object>map) throws JSONException {
    if (js.has("ref")) {
      int key = js.getString("ref").hashCode();
      return (Class3)(map.get(key));
    } 
    
    Class3 class3 = new Class3();
    int id = js.getString("id").hashCode();
    map.put(id, class3);
    
    JSONArray values = js.getJSONArray("values");
    // for non-primitive&String
    class3.setC4(readClass4(values.getJSONObject(0).getJSONObject("c4"), map));
    return class3;
  }

  public static Class4 readClass4(JSONObject js) throws JSONException {
    HashMap<Integer, Object> map = new HashMap<>();
    return readClass4(js, map);
  }
  public static Class4 readClass4(JSONObject js, HashMap<Integer, Object>map) throws JSONException {
    if (js.has("ref")) {
      int key = js.getString("ref").hashCode();
      return (Class4)(map.get(key));
    } 
    
    Class4 class4 = new Class4();
    int id = js.getString("id").hashCode();
    map.put(id, class4);
    
    JSONArray values = js.getJSONArray("values");
    // for non-primitive&String
    class4.setC3(readClass3(values.getJSONObject(0).getJSONObject("c3"), map));
    return class4;
  }
}
